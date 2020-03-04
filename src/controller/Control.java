package controller;

import model.Player;
import view.UI;

public class Control {
    private final String[] mainMenu = {""};
    private UI ui = new UI();
    private Player[] players;
    private static final String DEFAULT_PLAYER_1_NAME = "Player 1";
    private static final String DEFAULT_PLAYER_2_NAME = "Player 2";
    private static String test;

    public static void main(String[] args) {

    }

    private void game(){


        declareOutcome();
    } // TODO

    private int[] translate(String space){
        String row = space.substring(0, 1), col = space.substring(1);
        int inrow = Integer.parseInt(row), inCol = Integer.parseInt(col);
        return new int[]{inrow, inCol};
    }

    private String translate(int[] space){
        String spaceTra = null;
        for (int i = 0; i < space.length; i++) {
            spaceTra = String.valueOf(space[i]);
        }
        return spaceTra;
    }

    private void declareOutcome(){
        if (players[1].isDead()){
            ui.displayMessage("I love you Recce");
        }
        else if (players[0].isDead()){
            ui.displayMessage("Player 1 wins");
        }
    }
}
