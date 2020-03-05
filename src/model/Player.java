package model;

import view.UI;

public class Player {
    public enum Direction{
        N,
        E,
        S,
        W;

        public static Direction valueOfSpecial(String str){
            try{
                return Direction.valueOf(str);
            } catch (IllegalArgumentException ex){
                throw new IllegalArgumentException("You input does not match an acceptable direction. Please, try again.");
            }
        }
    }

    private Board homeBoard;
    private Board targetBoard;
    private String name;

    public Player() {
    }

    public Player(Board homeBoard, Board targetBoard, String name) {
        this.homeBoard = homeBoard;
        this.targetBoard = targetBoard;
        this.name = name;
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
        boolean acceptable = true;
        for (int i = 0; i < ship.getSize(); i++) {
            if (homeBoard.checkSpace(startingSpace) != homeBoard.EMPTY_SIGNIFIER) acceptable = false;
            for (int j = 0; j < loc[i].length; j++) {
                loc[i][j] = startingSpace[j];
            }
            if (direction == Direction.N){
                startingSpace[0] -= 1;
            } else if (direction == Direction.E){
                startingSpace[1] += 1;
            } else if (direction == Direction.S){
                startingSpace[0] += 1;
            } else if ((direction == Direction.W)){
                startingSpace[1] -= 1;
            }
        }
        if (acceptable){
            for (int i = 0; i < loc.length; i++) {
                homeBoard.mutateSpace(loc[i], homeBoard.SHIP_SIGNIFIER);
            }
            return loc;
        } else throw new IllegalArgumentException("Ships cannot overlap");
    }

    public boolean isDead(){
        int[][][] locations = {homeBoard.getCARRIER_LOCATION(), homeBoard.getBATTLESHIP_LOCATION(),
                homeBoard.getDESTROYER_LOCATION(), homeBoard.getSUBMARINE_LOCATION(),
                homeBoard.getPATROL_COAT_LOCATION()};
        int destroyedShips = 0;
        boolean destroyed = false;
        for (int[][] loc : locations){
            for (int[] space : loc){
                destroyed = true;
                if (homeBoard.checkSpace(space) == homeBoard.SHIP_SIGNIFIER) destroyed = false;
            }
            if (destroyed) destroyedShips++;
        }
        return (Ship.values().length == destroyedShips);
    }

    public Board getHomeBoard() {
        return homeBoard;
    }

    public Board getTargetBoard() {
        return targetBoard;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Natural player1 = new Natural(new Board("jdsaf"), new Board("dsafhs"), "player 1");
        player1.getHomeBoard().setCARRIER_LOCATION(player1.placeShip(Ship.CARRIER, new int[]{0, 0}, Direction.S));
        player1.getHomeBoard().setBATTLESHIP_LOCATION(player1.placeShip(Ship.BATTLESHIP, new int[]{0, 1}, Direction.S));
        player1.getHomeBoard().setDESTROYER_LOCATION(player1.placeShip(Ship.DESTROYER, new int[]{0, 2}, Direction.S));
        player1.getHomeBoard().setSUBMARINE_LOCATION(player1.placeShip(Ship.SUBMARINE, new int[]{0, 3}, Direction.S));
        player1.getHomeBoard().setPATROL_COAT_LOCATION(player1.placeShip(Ship.PATROL_BOAT, new int[]{0, 4}, Direction.S));
        new UI().displayBoard(player1.getHomeBoard());
        System.out.println(player1.isDead());
    }

}

