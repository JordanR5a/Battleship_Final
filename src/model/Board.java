package model;

import view.UI;

public class Board {
    public final char[] COL_SIGNIFIERS = {'A', 'B', 'C','D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public final int ROW_SIZE = 10;
    public final int COL_SIZE = 10;

    private final char SHIP_SIGNIFIER = 'S';
    private final char HIT_SIGNIFIER = 'H';
    private final char MISS_SIGNIFIER = 'M';
    private final char EMPTY_SIGNIFIER = 'E';

    private int[][] CARRIER_LOCATION;
    private int[][] BATTLESHIP_LOCATION;
    private int[][] DESTROYER_LOCATION;
    private int[][] SUBMARINE_LOCATION;
    private int[][] PATROL_COAT_LOCATION;

    private char[][] board;

    public Board(int[][] CARRIER_LOCATION, int[][] BATTLESHIP_LOCATION, int[][] DESTROYER_LOCATION, int[][] SUBMARINE_LOCATION, int[][] PATROL_COAT_LOCATION, char[][] board) {
        this.CARRIER_LOCATION = CARRIER_LOCATION;
        this.BATTLESHIP_LOCATION = BATTLESHIP_LOCATION;
        this.DESTROYER_LOCATION = DESTROYER_LOCATION;
        this.SUBMARINE_LOCATION = SUBMARINE_LOCATION;
        this.PATROL_COAT_LOCATION = PATROL_COAT_LOCATION;
        this.board = fillNullBoard();
    }

    public char[][] getBoard() {
        return board;
    }

    private char[][] fillNullBoard(){
        char[][] board = new char[ROW_SIZE][COL_SIZE];
        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                board[row][col] = EMPTY_SIGNIFIER;
            }
        }
        return board;
    }

    public char checkSpace(int[] space){
        return board[space[0]][space[1]];
    }

    public void mutateSpace(int[] space, char signifier) {
            board[space[0]][space[1]] = signifier;
    }
}
