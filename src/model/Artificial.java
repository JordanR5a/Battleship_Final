package model;

public class Artificial extends Player{
    char[][] simulatedBoard;

    public Artificial() {
    }

    public Artificial(Board homeBoard, Board targetBoard, String name) {
        super(homeBoard, targetBoard, name);
    }

    public int[] artificialAttack(){
        return null;
    }//TODO

    public int[] artificialPlacement(){
        return null;
    }//TODO

    private char[][] simulatedArray() {
        char[][] simulation = new char[getTargetBoard().ROW_SIZE][getTargetBoard().COL_SIZE];
        for (int i = 0; i < getTargetBoard().ROW_SIZE; i++) {
            for (int a = 0; a < getTargetBoard().COL_SIZE; a++) {
                simulation[i][a] = getTargetBoard().getBoard()[i][a];
            }
        }
        return simulation;
    }
}
