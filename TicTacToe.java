import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Qaasim Ashraf
 *
 */
public class TicTacToe {
    Scanner in;
    String[][] board;
    int boardSize;
    String turn = "X";

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe.");
        System.out.println("--------------------------------");

        TicTacToe game = new TicTacToe();
        game.setupBoard();
        game.printBoard();
        game.play();

    }

    void play()
    {
        String winner = null;
        System.out.println("X's will play first.");

        while (winner == null) {
            System.out.println("It's " + turn + "'s turn.");
            System.out.println("Please enter a row (anything from 1 to " + (boardSize) + ").");
            int row = in.nextInt();
            System.out.println("Please enter a column (anything from 1 to " + (boardSize) + ").");
            int col = in.nextInt();

            if ( (board[row-1][col-1]).equals("X") || (board[row-1][col-1]).equals("O") ){
                System.out.println("Slot already taken; re-enter slot number:");
                continue;
            }

            board[row-1][col-1] = turn;
            printBoard();
            winner = checkForWin(row,col);

            if (turn.equals("X")) {
                turn = "O";
            } else {
                turn = "X";
            }


        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
    }

    String checkForWin(int row, int col) {

        //check for row win
        boolean rowWin = checkForRowWin(row);
        boolean colWin = checkForColWin(col);
        boolean TLBR = checkForTLBRDiagWin();
        boolean TRBL = checkForTRBLDiagWin();
        if (rowWin || colWin || TLBR || TRBL){
            return turn;
        }
        boolean checkDraw = checkForDraw();
        if (checkDraw){
         return "draw";   
        }
        return null;
    }

    boolean checkForDraw(){
        for (int i = 0; i < (boardSize); i++) {
            for (int j = 0; j < (boardSize); j++) {
                if (!(board[i][j]).equals("X") || !(board[i][j]).equals("O")){
                    return false;
                }
            }
        } 
        return true;
    }

    boolean checkForRowWin(int row)
    {
        boolean rowSame = true;
        for (int i = 0; i < (boardSize); i++) {
            // System.out.println("i = " + i + " row=" + row + " turn= " + turn + " board[row-1[i]= " + board[row-1][i]);
            if (!(board[row-1][i].equals(turn))){
                rowSame = false;
            }

        }
        return rowSame;
    }

    boolean checkForColWin(int col)
    {
        boolean colSame = true;
        for (int i = 0; i < (boardSize); i++) {
            if (!(board[i][col-1].equals(turn))){
                colSame = false;
            }

        }
        return colSame;
    }

    boolean checkForTLBRDiagWin()
    {
        boolean topLeftToBottomRight = true;
        for (int i = 0; i < (boardSize); i++) {
            if (!(board[i][i].equals(turn))){
                topLeftToBottomRight = false;
            }

        }
        return topLeftToBottomRight;
    }

    boolean checkForTRBLDiagWin()
    {
        boolean topRightToBottomLeft = true;
        for (int i = 0; i < (boardSize); i++) {
            if (!(board[i][(boardSize-1)-i].equals(turn))){
                topRightToBottomLeft = false;
            }

        }
        return topRightToBottomLeft;
    }

    void setupBoard()
    {
        in = new Scanner(System.in);
        System.out.println("Please input a board size.");
        System.out.println("For example, inputting 3 would make a 3x3 board.");
        boardSize = in.nextInt();
        board = new String[boardSize][boardSize];  

        int count = 1;
        for (int i = 0; i < (boardSize); i++) {
            for (int j = 0; j < (boardSize); j++) {
                board[i][j] = String.valueOf(count);
                count++;
            }
        }

    }

    void printBoard() {     
        System.out.print("|");
        for (int i = 0; i < (boardSize); i++){
            System.out.print("---|");
        }
        System.out.println("");

        for (int i = 0; i < (boardSize); i++){
            for (int j = 0; j < (boardSize); j++){
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.print("|");
        for (int i = 0; i < (boardSize); i++){
            System.out.print("---|");
        }
        System.out.println("");
    }

    boolean validateInput(int n)
    {
        if (n < 1 || n > boardSize){
            System.out.println("Invalid input, enter value from 1 to " + boardSize + ".");
            return false;
        }
        return true;
    }
}