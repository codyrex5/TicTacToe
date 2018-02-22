import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Qaasim Ashraf
 *
 */
public class TicTacToe {
    static Scanner in;
    static String[] board;
    static String turn;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe.");
        System.out.println("Input a board size.");
        System.out.println("For example, inputting 3 would make a 3x3 board.");
        int boardSize = in.nextInt();
        board = new String[boardSize * boardSize];
        turn = "X";
        String winner = null;
        
        for (int a = 0; a < (boardSize * boardSize); a++) {
            board[a] = String.valueOf(a+1);
        }
        
        System.out.println("--------------------------------");
        System.out.println("How many people will be playing today? (1 or 2)");
        int playerChoice;
        playerChoice = in.nextInt();
        
        while (!(playerChoice == 1 || playerChoice == 2)) {
            System.out.println("Invalid input; re-enter number of players (1 or 2):");
            playerChoice = in.nextInt();
        }
        
        printBoard();
        if (playerChoice == 2){
            System.out.println("X's will play first. Enter a slot number to place X in:");

            while (winner == null) {
                String numInput = in.next();
                int newInput = Integer.parseInt(numInput);
                if (newInput == 0 || newInput == -1){
                    System.out.println("Maybe I wasn't clear enough: enter a SLOT NUMBER.");
                    numInput = in.next();
                    newInput = Integer.parseInt(numInput);
                }
                if (board[newInput-1].equals(String.valueOf(newInput))) {
                    board[newInput-1] = turn;
                    if (turn.equals("X")) {
                        turn = "O";
                    } else {
                        turn = "X";
                    }
                    printBoard();
                    winner = checkWinner();
                } else {
                    System.out.println("Slot already taken; re-enter slot number:");
                    continue;
                }
            }
            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("It's a draw! Thanks for playing.");
            } else {
                System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
            }
        }

        if (playerChoice == 1){
            System.out.println("You are X's and will play first. Enter a slot number to place X in:");

        }
    }

    static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                line = board[0] + board[1] + board[2];
                break;
                case 1:
                line = board[3] + board[4] + board[5];
                break;
                case 2:
                line = board[6] + board[7] + board[8];
                break;
                case 3:
                line = board[0] + board[3] + board[6];
                break;
                case 4:
                line = board[1] + board[4] + board[7];
                break;
                case 5:
                line = board[2] + board[5] + board[8];
                break;
                case 6:
                line = board[0] + board[4] + board[8];
                break;
                case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a+1))) {
                break;
            }
            else if (a == 8) return "draw";
        }

        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }

    // static void printBoard() {     
        // System.out.print("|");
        // for (int i = 1; i < (Math.sqrt(board.length)); i++){
            // System.out.print("---|");
        // } 
        // System.out.println("---|");
        // for (int i = 0; i < (Math.sqrt(board.length)); i++){
            // for (int j = 0; j < (Math.sqrt(board.length)); i++){
                // System.out.print("| " + board[j] + " ");
            // }
            // System.out.println("|");
        // }
        // System.out.print("|");
        // for (int i = 1; i < (Math.sqrt(board.length)); i++){
            // System.out.print("---|");
        // }
        // System.out.println("---|");
    // }
    static void printBoard() {      
        System.out.println("/---|---|---\\");      
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");      
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("/---|---|---\\");
    }
}