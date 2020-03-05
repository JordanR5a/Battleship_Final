package controller;

import model.*;
import utilities.RandomNumGenerator;
import view.UI;


public class Control {
    private final String[] mainMenu = {"Human vs Human", "Human vs Computer", "Exit"};
    private final String[] turnMenu = {"Show Board", "Target the Enemy"};
    private UI ui = new UI();
    private Player[] players = new Player[2];
    private  static final String[] DEFAULT_NAMES= {"Player 1", "Player 2"};

    public static void main(String[] args) {
        Control control = new Control();
        control.main();
    }

    private void main(){
        int input;
        do{
            input = ui.promptForMenuSelection(mainMenu);
            switch (input){
                case 1:
                    createPlayer(new Player[]{new Natural(), new Natural()});
                    game();
                    break;
                case 2:
                    createPlayer(new Player[]{new Natural(), new Artificial()});
                    game();
                    break;
            }
        } while (mainMenu.length != input);
    }

    private void createPlayer(Player[] players){
        for (int i = 0; i < players.length; i++) {
            if (players[i].getClass() == Artificial.class) {
                this.players[i] = new Artificial(new Board("Home Board"),
                        new Board("Target Board"), DEFAULT_NAMES[i]);
                placeArtificialShips((Artificial)this.players[i]);
            }
            else if (players[i].getClass() == Natural.class) {
                this.players[i] = new Natural(new Board("Home Board"), new Board("Target Board"),
                        ui.promptForString(String.format("Please enter player %d's name", i + 1), 1));
                placeShips(this.players[i]);
            }
        }
    }

    private void placeArtificialShips(Artificial player){
        boolean replay;
        for(Ship ship : Ship.values()){
            do{
                try{
                    player.getHomeBoard().setLocation(player.placeShip(ship, player.artificialPlacement(),
                            player.artificialDirection()), ship);
                    replay = false;
                } catch (IllegalArgumentException ex) { replay = true; }
            } while (replay);
        }
    }

    private void placeShips(Player player){
        boolean replay;
        for(Ship ship : Ship.values()){
            do{
                try{
                    player.getHomeBoard().setLocation(player.placeShip(ship, translate(ui.promptForString(String.format(
                            "Please enter the starting space of %s's %s", player.getName(), ship.toString()), 2)),
                            Direction.valueOfSpecial(ui.promptForString(String.format("Please enter the direction (N, E, S, W) for %s's %s",
                                    player.getName(), ship.toString()), 1).toUpperCase())), ship);
                    ui.displayBoard(player.getHomeBoard());
                    replay = false;
                } catch (IllegalArgumentException ex) {
                    ui.displayError(ex.getMessage());
                    replay = true;
                }
            } while (replay);
        }
    }

    private void playerTurn(int playerIndex){
        if (players[playerIndex].getClass() == Natural.class) {
            int input;
            do {
                ui.displayMessage(String.format("%s's options:", players[playerIndex].getName()));
                input = ui.promptForMenuSelection(turnMenu);
                switch (input) {
                    case 1:
                        ui.displayBoard(players[playerIndex].getHomeBoard());
                        break;
                    case 2:
                        ui.displayBoard(players[playerIndex].getTargetBoard());
                        int enemy;
                        if (playerIndex == 0) enemy = 1;
                        else enemy = 0;
                        int[] space = translate(ui.promptForString("Please enter the space you wish to target", 2));
                        players[playerIndex].attackSpace(space, players[enemy].getHomeBoard());
                        ui.displayBoard(players[playerIndex].getTargetBoard());
                        players[enemy].spaceAttacked(space);
                        break;
                }
            } while (input != turnMenu.length);
        } else if (players[playerIndex].getClass() == Artificial.class){
            Artificial player = (Artificial)players[playerIndex];
            int enemy;
            if (playerIndex == 0) enemy = 1;
            else enemy = 0;
            int[] space = player.artificialAttack();
            player.attackSpace(space, players[enemy].getHomeBoard());
            ui.displayBoard(players[playerIndex].getTargetBoard());
            players[enemy].spaceAttacked(space);
        }
    }

    private void game(){
        int current = RandomNumGenerator.randomNum(0,1);
        do{
            if (current == 0){
                playerTurn(current++);
            }
            else{
                playerTurn(current--);
            }
        } while (!players[0].isDead() && !players[1].isDead());
        declareOutcome();
    }

    private int[] translate(String space){
        if(space.length() != 2) throw new IllegalArgumentException("space must have two characters");
        String row = space.trim().substring(0, 1), col = space.trim().substring(1).toUpperCase();
        char charCol = col.charAt(0);
        int inrow = Integer.parseInt(row);
        return new int[]{(inrow - 1), colSel(charCol)};
    }

    private String translate(int[] space){
        if (space.length != 2) throw new IllegalStateException("space must have two indexes");
        String spaceTra = null;
        for (int i = 0; i < space.length; i++) {
            spaceTra = String.valueOf(space[i]);
        }
        return spaceTra;
    }

    private void declareOutcome(){
        if (players[1].isDead()){
            ui.displayMessage("Player 2 wins");
        } else if (players[0].isDead()){
            ui.displayMessage("Player 1 wins");
        }
    }

    private int colSel(char col){
        int colInt = -1;
        for (int i = 0; i < Board.COL_SIGNIFIERS.length; i++) {
            if (col == Board.COL_SIGNIFIERS[i]) colInt = i;
        }
        return colInt;
    }
}
