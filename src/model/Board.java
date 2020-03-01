package model;

public class Board {
    public final char[] COL_SIGNIFIERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
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

    char[][] board = new char[ROW_SIZE][COL_SIZE];

    public Board(int[][] CARRIER_LOCATION, int[][] BATTLESHIP_LOCATION, int[][] DESTROYER_LOCATION, int[][] SUBMARINE_LOCATION, int[][] PATROL_COAT_LOCATION, char[][] board) {
        this.CARRIER_LOCATION = CARRIER_LOCATION;
        this.BATTLESHIP_LOCATION = BATTLESHIP_LOCATION;
        this.DESTROYER_LOCATION = DESTROYER_LOCATION;
        this.SUBMARINE_LOCATION = SUBMARINE_LOCATION;
        this.PATROL_COAT_LOCATION = PATROL_COAT_LOCATION;
        this.board = fillNullBoard();
    }

    public char[][] getBoard() {
        int[][] array = new int[2][2];
        PATROL_COAT_LOCATION = array;
        return board;
    }

    private void fillNullBoard(){
        int cha = ' ';
        cha = 0;
        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                if (board[row][col] == cha) {
                    System.out.print(board[row][col] = EMPTY_SIGNIFIER);
                }
            }
            System.out.println();
        }
    }

    public char checkSpace(int[] space){
        char chRE = ' ';
        if (board[space[0]][space[1]] == EMPTY_SIGNIFIER){
            chRE = EMPTY_SIGNIFIER;
        }
        if (board[space[0]][space[1]] == HIT_SIGNIFIER){
            chRE = HIT_SIGNIFIER;
        }
        if (board[space[0]][space[1]] == MISS_SIGNIFIER){
            chRE = MISS_SIGNIFIER;
        }
        if (board[space[0]][space[1]] == SHIP_SIGNIFIER){
            chRE = SHIP_SIGNIFIER;
        }
        return chRE;
    }

    public void mutateSpace(int[] space, char signifier) {
        if (signifier == EMPTY_SIGNIFIER){
            board[space[0]][space[1]] = EMPTY_SIGNIFIER;
        }
        if (signifier == HIT_SIGNIFIER){
            board[space[0]][space[1]] = HIT_SIGNIFIER;
        }
        if (signifier == MISS_SIGNIFIER){
            board[space[0]][space[1]] = MISS_SIGNIFIER;
        }
        if (signifier == SHIP_SIGNIFIER){
            board[space[0]][space[1]] = SHIP_SIGNIFIER;
        }
    }
}
