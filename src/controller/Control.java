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
            if (players[i].getClass() == Artificial.class) this.players[i] = new Artificial(
                    new Board("Home Board"), new Board("Target Board"), DEFAULT_NAMES[i]);
            else if (players[i].getClass() == Natural.class) {
                this.players[i] = new Natural(new Board("Home Board"), new Board("Target Board"),
                        ui.promptForString(String.format("Please enter player %d's name", i + 1), 1));
                placeShips(i);
            }
        }
    }

    private void placeShips(int player){
        boolean replay;
        for(Ship ship : Ship.values()){
            do{
                try{
                    this.players[player].placeShip(ship, translate(ui.promptForString(String.format(
                            "Please enter the starting space of %s's %s", this.players[player].getName(), ship.toString()), 2)),
                            Player.Direction.valueOfSpecial(ui.promptForString(String.format("Please enter the direction (N, E, S, W) for %s's %s",
                                    this.players[player].getName(), ship.toString()), 1).toUpperCase()));
                    ui.displayBoard(this.players[player].getHomeBoard());
                    replay = false;
                } catch (IllegalArgumentException ex) {
                    ui.displayError(ex.getMessage());
                    replay = true;
                }
            } while (replay);
        }
    }

    private void playerTurn(int playerIndex){
        int input;
        do{
            input = ui.promptForMenuSelection(turnMenu);
            switch (input){
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
                    players[enemy].spaceAttacked(space);
                    break;
            }
        } while (input != turnMenu.length);

    }

    private void game(){
        int current = RandomNumGenerator.randomNum(0,1);
        do{
            if (current == 0) playerTurn(current++);
            else playerTurn(current--);
        } while (!players[0].isDead() && !players[1].isDead());
        declareOutcome();
    }

    private int[] translate(String space){
        if(space.length() != 2) throw new IllegalStateException("space must have two characters");
        String row = space.trim().substring(0, 1), col = space.trim().substring(1);
        int inrow = Integer.parseInt(row);
        return new int[]{inrow, colSel(col)};
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

    private int colSel(String col){
        int colo = 0;
        switch (col){
            case "A":
                colo = 0;
                break;
            case "B":
                colo = 1;
                break;
            case "C":
                colo = 2;
                break;
            case "D":
                colo = 3;
                break;
            case "E":
                colo = 4;
                break;
            case "F":
                colo = 5;
                break;
            case "G":
                colo = 6;
                break;
            case "H":
                colo = 7;
                break;
            case "I":
                colo = 8;
                break;
            case "J":
                colo = 9;
                break;
        }
        return colo;
    }
}
