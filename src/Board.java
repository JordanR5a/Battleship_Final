
public class Board {
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
}
