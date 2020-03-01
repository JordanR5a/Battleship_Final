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

    } //TODO

    public void attackSpace(int[] space){

    } //TODO

    public int[][] placeShip(Ship ship, int[] startingSpace, Direction direction){
        return null;
    } //TODO

    public boolean checkDeath(){
        return false;
    } //TODO

    public Board getHomeBoard() {
        return homeBoard;
    }

    public Board getTargetBoard() {
        return targetBoard;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}

