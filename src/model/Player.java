package model;

import view.UI;

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
        if (homeBoard.checkSpace(space) == homeBoard.SHIP_SIGNIFIER){
            homeBoard.mutateSpace(space, homeBoard.HIT_SIGNIFIER);
        } else if (homeBoard.checkSpace(space) == homeBoard.EMPTY_SIGNIFIER){
            homeBoard.mutateSpace(space, homeBoard.MISS_SIGNIFIER);
        }
    }

    public void attackSpace(int[] space, Board enemyBoard){
        if (enemyBoard.checkSpace(space) == enemyBoard.SHIP_SIGNIFIER){
            targetBoard.mutateSpace(space, targetBoard.HIT_SIGNIFIER);
        } else if (enemyBoard.checkSpace(space) == enemyBoard.EMPTY_SIGNIFIER){
            targetBoard.mutateSpace(space, targetBoard.MISS_SIGNIFIER);
        }
    }

    public int[][] placeShip(Ship ship, int[] startingSpace, Direction direction){
        int[][] loc = new int[ship.getSize()][2];
        for (int i = 0; i < ship.getSize(); i++) {
            homeBoard.mutateSpace(startingSpace, homeBoard.SHIP_SIGNIFIER);
            if (direction == Direction.N){
                startingSpace[0] -= 1;
            } else if (direction == Direction.E){
                startingSpace[1] += 1;
            } else if (direction == Direction.S){
                startingSpace[0] += 1;
            } else if ((direction == Direction.W)){
                startingSpace[1] -= 1;
            }
            loc[i] = startingSpace;
        }
        return loc;
    }

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

    public static void main(String[] args) {
        Player player1 = new Player(new Board(), new Board(), "player1");
        Player player2 = new Player(new Board(), new Board(), "player2");
        UI ui = new UI();
        int[] array = {5, 5};
        player1.getHomeBoard().setBATTLESHIP_LOCATION(player1.placeShip(Ship.BATTLESHIP, array, Direction.N));
        int[] array2 = {0, 5};
        player2.attackSpace(array2, player1.homeBoard);
        player1.spaceAttacked(array2);
        ui.displayBoard(player2.targetBoard);
        ui.displayBoard(player1.homeBoard);

    }
}

