package model;

public class Board {
    public final int ROW_SIZE = 10;
    public final int COL_SIZE = 10;
    char[][] board = new char[ROW_SIZE][COL_SIZE];
    char[][] battleship = new char[10][10];
    char[][] battleshipLabel = new char[][]{
            {'_', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'},
            {'1', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'2', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'3', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'4', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'5', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'6', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'7', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'8', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'9', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'0', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    public void board() {
        for (int rowlab = 0; rowlab < 11; rowlab++) {
            for (int colLab = 0; colLab < 11; colLab++) {
                if (battleshipLabel[rowlab][colLab] == ' ') {
                    String boardLayout = String.valueOf(battleshipLabel[rowlab][colLab] = 'E');
                    System.out.print(boardLayout + " ");
                } else {
                    System.out.print(battleshipLabel[rowlab][colLab] + " ");
                }
            }
            System.out.println();
        }
    }

    public char[][] getBoard() {
        return board;
    }
}
