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
        int row = RandomNumGenerator.randomNum(0, Board.ROW_SIZE - 1);
        int col = RandomNumGenerator.randomNum(0, Board.COL_SIZE - 1);
        return new int[]{row, col};
    }

    private int[] simulatedArtificialAttack(){
        simulatedControl = new Control();
        simulatedBoard = new Board(simulatedArray());

        return null;
    }

    public int[] artificialPlacement(){
        int row = RandomNumGenerator.randomNum(0, Board.ROW_SIZE - 1);
        int col = RandomNumGenerator.randomNum(0, Board.COL_SIZE - 1);
        return new int[]{row, col};
    }

    public Direction artificialDirection(){
        int rand = RandomNumGenerator.randomNum(0, Direction.values().length - 1);
        for (Direction direction : Direction.values()){
            if (direction.ordinal() == rand) return direction;
        }
        throw new IllegalStateException("Direction cannot be null");
    }

    private char[][] simulatedArray() {
        char[][] simulation = new char[Board.ROW_SIZE][Board.COL_SIZE];
        for (int i = 0; i < Board.ROW_SIZE; i++) {
            for (int a = 0; a < Board.COL_SIZE; a++) {
                simulation[i][a] = getTargetBoard().getBoard()[i][a];
            }
        }
        return simulation;
    }
}
