import java.util.Scanner;

public class TicTacToeAI {
    public char[][] board = new char[3][3];
    public final char playerSymbol = 'X';
    public final char computerSymbol = 'O';

    public TicTacToeAI() {
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isMoveValid(int move) {
        return move >= 1 && move <= 9 && board[(move - 1) / 3][(move - 1) % 3] == '-';
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public int evaluateBoard() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                if (board[row][0] == playerSymbol) {
                    return -1; 
                } else if (board[row][0] == computerSymbol) {
                    return 1; 
                }
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                if (board[0][col] == playerSymbol) {
                    return -1; 
                } else if (board[0][col] == computerSymbol) {
                    return 1;
                }
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == playerSymbol) {
                return -1; 
            } else if (board[0][0] == computerSymbol) {
                return 1;
            }
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == playerSymbol) {
                return -1; 
            } else if (board[0][2] == computerSymbol) {
                return 1;
            }
        }

        return 0; 
    }

    public int minimax(boolean isMaximizing) {
        int score = evaluateBoard();

        if (score == 1 || score == -1) {
            return score;
        }

        if (isBoardFull()) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        board[i][j] = computerSymbol;
                        bestScore = Math.max(bestScore, minimax(false));
                        board[i][j] = '-';
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        board[i][j] = playerSymbol;
                        bestScore = Math.min(bestScore, minimax(true));
                        board[i][j] = '-';
                    }
                }
            }
            return bestScore;
        }
    }

    public void makeComputerMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int move = 1; move <= 9; move++) {
            if (isMoveValid(move)) {
                board[(move - 1) / 3][(move - 1) % 3] = computerSymbol;
                int score = minimax(false);
                board[(move - 1) / 3][(move - 1) % 3] = '-';

                if (score > bestScore) {
                    bestScore = score;
                    bestMove = move;
                }
            }
        }

        board[(bestMove - 1) / 3][(bestMove - 1) % 3] = computerSymbol;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int move;
    
        System.out.println("You are X, and the computer is O.");
        System.out.println("To make a move, enter a number between 1 and 9: ");
    
        boolean playerTurn = true;
        while (true) {
            if (playerTurn) {
                System.out.print("Your turn (X): ");
                move = scanner.nextInt();
                if (isMoveValid(move)) {
                    board[(move - 1) / 3][(move - 1) % 3] = playerSymbol;
                    if (evaluateBoard() == -1) {
                        printBoard();
                        System.out.println("Congratulations! You win!");
                        break;
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }
            } else {
                makeComputerMove();
                if (evaluateBoard() == 1) {
                    printBoard();
                    System.out.println("Sorry, the computer wins!");
                    break;
                }
                printBoard();
            }
    
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
    
            playerTurn = !playerTurn;
        }
    
        scanner.close();
    }
    

    public static void main(String[] args) {
        TicTacToeAI game = new TicTacToeAI();
        game.play();
    }
}
