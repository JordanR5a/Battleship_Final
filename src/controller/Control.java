package controller;

import model.Player;
import view.UI;

public class Control {
    private final String[] mainMenu = {""};
    private UI ui = new UI();
    private Player[] players;
    private static final String DEFAULT_PLAYER_1_NAME = "Player 1";
    private static final String DEFAULT_PLAYER_2_NAME = "Player 2";

    public static void main(String[] args) {

    }

    private void game(){


        declareOutcome();
    } // TODO

    private int[] translate(String space){
        String col = space.substring(0, 1), row = space.substring(1);
        int inrow = Integer.parseInt(row);
        return new int[]{selcCol(col), inrow};
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
    private int selcCol(String row){
        int col = 0;
        switch (row){
            case "A":
                col = 0;
                break;
            case "B":
                col = 1;
                break;
            case "C":
                col = 2;
                break;
            case "D":
                col = 3;
                break;
            case "E":
                col = 4;
                break;
            case "F":
                col = 5;
                break;
            case "G":
                col = 6;
                break;
            case "H":
                col = 7;
                break;
            case "I":
                col = 8;
                break;
            case "J":
                col = 9;
                break;
        }
        return col;
    }
}
