import java.util.Scanner;

public class 33_TicTacToe_Non_AI {
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;

    public TicTacToe() {            
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private void makeMove(int cell) {
        // Calculates the values of row and column based on the cell number
        int row = (cell - 1) / 3;
        int col = (cell - 1) % 3;

        if (cell >= 1 && cell <= 9 && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        } else {
            System.out.println("\nInvalid move! Try again.");
        }
    }

    private boolean checkWin(char player) {
        // Check rows for a win
        for (int i = 0; i < 3; i++) {
            // If all cells in the current row are occupied by the same player, return true
            if (board[i][0] == player && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
    
        // Check columns for a win
        for (int i = 0; i < 3; i++) {
            // If all cells in the current column are occupied by the same player, return true
            if (board[0][i] == player && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
    
        // Check diagonals for a win
        // If all cells in the diagonal from top-left to bottom-right are occupied by the same player, return true
        if (board[0][0] == player && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        
        // If all cells in the diagonal from top-right to bottom-left are occupied by the same player, return true
        if (board[0][2] == player && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
    
        // No win condition is met, return false
        return false;
    }

    private boolean checkTie() {
        // Iterate through each cell of the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // If any cell is empty, the game is not a tie yet, so return false
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        
        // All cells are filled with 'X' or 'O', indicating a tie
        return true;
    }
    

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
    
        // Continue the game until it is ended
        while (!gameEnded) {
            System.out.println("\nCurrent board:");
            printBoard();
    
            System.out.println("\nPlayer " + currentPlayer + ", make your move (cell number [1-9]):");
            int cell = scanner.nextInt();
    
            // Make a move based on the player's input
            makeMove(cell);
    
            // Check if the current player has won
            if (checkWin('X')) {
                System.out.println("\nPlayer X wins!");
                gameEnded = true;
            } else if (checkWin('O')) {
                System.out.println("\nPlayer O wins!");
                gameEnded = true;
            }
            // If no player has won and the game is a tie
            else if (checkTie()) {
                System.out.println("\nIt's a tie!");
                gameEnded = true;
            }
        }
    
        System.out.println("\nFinal board:");
        printBoard();
        scanner.close();
    }
    

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
