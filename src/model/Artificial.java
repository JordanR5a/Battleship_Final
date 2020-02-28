package model;

import utilities.RandomNumGenerator;

public class Artificial extends Player{
    char[][] simulatedBoard;

    public Artificial(Board homeBoard, Board targetBoard, String name) {
        super(homeBoard, targetBoard, name);
    }

    public int[] artificialAttack(){
        do{

        } while(true);
    }

    public int[] artificialPlacement(){
        return null;
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
