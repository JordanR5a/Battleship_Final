package model;

public class Board {
    public final char[] COL_SIGNIFIERS = new char[]{};
    public final int ROW_SIZE = 10;
    public final int COL_SIZE = 10;

    private final char SHIP_SIGNIFIER = 'S';
    private final char HIT_SIGNIFIER = 'H';
    private final char MISS_SIGNIFIER = 'M';
    private final char EMPTY_SIGNIFIER = 'E';

    private final int[][] CARRIER_LOCATION = new int[Ship.CARRIER.getSize()][1];
    private final int[][] BATTLESHIP_LOCATION= new int[Ship.BATTLESHIP.getSize()][1];
    private final int[][] DESTROYER_LOCATION= new int[Ship.DESTROYER.getSize()][1];
    private final int[][] SUBMARINE_LOCATION= new int[Ship.SUBMARINE.getSize()][1];
    private final int[][] PATROL_COAT_LOCATION= new int[Ship.PATROL_BOAT.getSize()][1];

    char[][] board = new char[ROW_SIZE][COL_SIZE];

    public void board() {
        fillNullBoard();
    }

    public char[][] getBoard() {
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
