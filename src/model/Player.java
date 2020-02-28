package model;

public class Player {
    private enum Direction{
        N,
        E,
        S,
        W
    }
    private Board homeBoard;
    private Board targetBoard;
    private String name;
    private boolean alive;

    public Player(Board homeBoard, Board targetBoard, String name) {
        this.homeBoard = homeBoard;
        this.targetBoard = targetBoard;
        this.name = name;
        this.alive = true;
    }

    public void spaceAttacked(int[] space){

    }

    public void attackSpace(int[] space){

    }

    public int[][] placeShip(Ship ship, int[] startingSpace, Direction direction){
        return null;
    }

    public boolean checkDeath(){
        return false;
    }
}

