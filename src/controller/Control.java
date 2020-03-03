package controller;

public class Control {
    private final String[] mainMenu = {""};
    private Player[] players;
    private static final String DEFAULT_PLAYER_1_NAME = "Player 1";
    private static final String DEFAULT_PLAYER_2_NAME = "Player 2";

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
        Player outcome = new Player();
        if (outcome.isDead()){
            //PLAYER 1 WIN
        }
        if (outcome.isDead()){
            //PLAYER 2 WIN
        }
    } // TODO
}
