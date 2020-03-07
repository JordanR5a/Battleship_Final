package model;

public class Board {
    public static final char[] COL_SIGNIFIERS = {'A', 'B', 'C','D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static final int ROW_SIZE = 10;
    public static final int COL_SIZE = 10;

    public final char SHIP_SIGNIFIER = 'S';
    public final char HIT_SIGNIFIER = 'H';
    public final char MISS_SIGNIFIER = 'M';
    public final char EMPTY_SIGNIFIER = 'L';

    private int[][] CARRIER_LOCATION;
    private int[][] BATTLESHIP_LOCATION;
    private int[][] DESTROYER_LOCATION;
    private int[][] SUBMARINE_LOCATION;
    private int[][] PATROL_COAT_LOCATION;

    private char[][] board;
    private String name;

    public Board(String name) {
        this.name = name;
        this.board = fillNullBoard();
    }

    public Board(char[][] board) {
        this.board = board;
    }

    public String getName() {
        return name;
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

    public void setCARRIER_LOCATION(int[][] CARRIER_LOCATION) {
        this.CARRIER_LOCATION = CARRIER_LOCATION;
    }

    public void setBATTLESHIP_LOCATION(int[][] BATTLESHIP_LOCATION) {
        this.BATTLESHIP_LOCATION = BATTLESHIP_LOCATION;
    }

    public void setDESTROYER_LOCATION(int[][] DESTROYER_LOCATION) {
        this.DESTROYER_LOCATION = DESTROYER_LOCATION;
    }

    public void setSUBMARINE_LOCATION(int[][] SUBMARINE_LOCATION) {
        this.SUBMARINE_LOCATION = SUBMARINE_LOCATION;
    }

    public void setPATROL_COAT_LOCATION(int[][] PATROL_COAT_LOCATION) {
        this.PATROL_COAT_LOCATION = PATROL_COAT_LOCATION;
    }

    public void setLocation(int[][] location, Ship ship){
        switch (ship){
            case CARRIER:
                setCARRIER_LOCATION(location);
                break;
            case BATTLESHIP:
                setBATTLESHIP_LOCATION(location);
                break;
            case DESTROYER:
                setDESTROYER_LOCATION(location);
                break;
            case SUBMARINE:
                setSUBMARINE_LOCATION(location);
                break;
            case PATROL_BOAT:
                setPATROL_COAT_LOCATION(location);
                break;
            default:
                throw new IllegalStateException("This code must be updated with all available ships");
        }
    }

    public int[][] getCARRIER_LOCATION() {
        return CARRIER_LOCATION;
    }

    public int[][] getBATTLESHIP_LOCATION() {
        return BATTLESHIP_LOCATION;
    }

    public int[][] getDESTROYER_LOCATION() {
        return DESTROYER_LOCATION;
    }

    public int[][] getSUBMARINE_LOCATION() {
        return SUBMARINE_LOCATION;
    }

    public int[][] getPATROL_COAT_LOCATION() {
        return PATROL_COAT_LOCATION;
    }

}
