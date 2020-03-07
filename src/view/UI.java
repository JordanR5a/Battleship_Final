package view;

import model.Board;
import zarkowski.reece.utilities.ConsoleIO;

public class UI {
    ConsoleIO consoleIO = new ConsoleIO();

    public void displayBoard(Board board){
        String boardStr = "________________________________________\n";
        boardStr += String.format("%s:\n    ", board.getName());
        for (char ch : Board.COL_SIGNIFIERS){
            boardStr += ch + "  ";
        }
        boardStr += "\n";
        for (int i = 0; i < Board.ROW_SIZE; i++) {
            if (i < 9) boardStr += " " + (i + 1);
            else boardStr += i + 1;
            boardStr += "  ";
            for (int a = 0; a < Board.COL_SIZE; a++) {
                boardStr += board.getBoard()[i][a] + "  ";
            }
            boardStr += "\n";
        }
        boardStr += "________________________________________\n";
        displayMessage(boardStr);
    }

    public String promptForString(String prompt, int minLength){
        return consoleIO.promptForString(prompt, minLength);
    }

    public int promptForInt(String prompt, int min, int max){
        return consoleIO.promptForInt(prompt, min, max);
    }

    public boolean promptForBoolean(String prompt, String trueString, String falseString){
        return consoleIO.promptForBoolean(prompt, trueString, falseString);
    }

    public int promptForMenuSelection(String[] options){
        return consoleIO.promptForMenuSelection(options);
    }

    public void displayMessage(String msg){
        consoleIO.displayMessage(msg);
    }

    public void displayError(String err){
        consoleIO.displayError(err);
    }
}
