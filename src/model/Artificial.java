package model;

import controller.Control;
import utilities.RandomNumGenerator;

public class Artificial extends Player{
    private Board simulatedBoard;
    private Control simulatedControl;

    public Artificial() {
    }

    public Artificial(Board homeBoard, Board targetBoard, String name) {
        super(homeBoard, targetBoard, name);
    }

    public int[] artificialAttack(){
        return null;
    }//TODO

    public int[] artificialPlacement(){
        int row = RandomNumGenerator.randomNum(0, getHomeBoard().ROW_SIZE);
        int col = RandomNumGenerator.randomNum(0, getHomeBoard().COL_SIZE);
        return new int[]{row, col};
    }

    public Direction artificialDirection(){
        for (Direction direction : Direction.values()){
            if (direction.ordinal() == RandomNumGenerator.randomNum(0, Direction.values().length)) return direction;
        }
        throw new IllegalStateException("Direction cannot be null");
    }

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
