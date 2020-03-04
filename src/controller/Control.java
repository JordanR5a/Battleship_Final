package controller;

import model.Artificial;
import model.Board;
import model.Natural;
import model.Player;
import utilities.RandomNumGenerator;
import view.UI;


public class Control {
    private final String[] mainMenu = {"Human vs Human", "Human vs Computer", "Exit"};
    private final String[] turnMenu = {"Show Board", "Target the Enemy"};
    private UI ui = new UI();
    private Player[] players;
    private  static final String[] DEFAULT_NAMES= {"Player 1", "Player 2"};

    public static void main(String[] args) {

    }

    private void main(){
        int input = 0;
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
                    new Board(), new Board(), DEFAULT_NAMES[i]);
            if (players[i].getClass() == Natural.class) this.players[i] = new Natural(new Board(), new Board(),
                    ui.promptForString(String.format("Please enter player %d's name", i + 1), 1));
        }
    }

    private void playerTurn(int playerIndex){
        int input = ui.promptForMenuSelection(turnMenu);
        do{
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
    } // TODO

    private int[] translate(String space){
        if(space.length() != 2) throw new IllegalStateException("space must have two characters");
        String row = space.substring(0, 1), col = space.substring(1);
        int inrow = Integer.parseInt(row), inCol = Integer.parseInt(col);
        return new int[]{inrow, inCol};
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
}
