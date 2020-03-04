package controller;

import model.Player;
import view.UI;

public class Control {
    private final String[] mainMenu = {"Human vs Human", "Human vs Computer", "Exit"};
    private final String[] turnMenu = {"Show Board", "Target the Enemy"};
    private UI ui = new UI();
    private Player[] players;
    private static final String DEFAULT_PLAYER_1_NAME = "Player 1";
    private static final String DEFAULT_PLAYER_2_NAME = "Player 2";

    public static void main(String[] args) {

    }

    private void main(){
        int input = 0;
        do{
            ui.promptForMenuSelection(mainMenu);
        } while (mainMenu.length != input);
    }

    private void game(){
        do{

            declareOutcome();
        } while (!players[0].isDead() && !players[1].isDead());
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
