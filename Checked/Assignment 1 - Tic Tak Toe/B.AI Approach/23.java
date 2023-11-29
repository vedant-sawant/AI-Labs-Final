import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToeAi {
    static char board[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    static void display() {
        System.out.println("Player 1 is X (Human)");
        System.out.println("Player 2 is O (AI)");
        // System.out.println("| | | |");
        System.out.println("| " + board[1] + "| " + board[2] + "| " + board[3] + "|");
        System.out.println("|  |  |  |");
        System.out.println("| " + board[4] + "| " + board[5] + "| " + board[6] + "|");
        System.out.println("|  |  |  |");
        System.out.println("| " + board[7] + "| " + board[8] + "| " + board[9] + "|");
    }

    static int checkwin(char[] board) {
        if (board[1] == board[2] && board[2] == board[3])
            return 1;
        else if (board[1] == board[4] && board[4] == board[7])
            return 1;
        else if (board[1] == board[5] && board[5] == board[9])
            return 1;
        else if (board[2] == board[5] && board[5] == board[8])
            return 1;
        else if (board[3] == board[6] && board[6] == board[9])
            return 1;
        else if (board[4] == board[5] && board[5] == board[6])
            return 1;
        else if (board[7] == board[8] && board[8] == board[9])
            return 1;
        else if (board[3] == board[5] && board[5] == board[7])
            return 1;

        int allmarked = 0;
        for (int i = 1; i < board.length; i++) {
            if (board[i] == 'X' || board[i] == 'O')
                allmarked++;
        }
        if (allmarked == 9) {
            return -1;
        }
        return 0;
    }

    static int minimax(int depth, boolean isMaximizing) {
        int score = checkwin(board);

        if (score == 1)// ai win
            return 10 - depth;
        if (score == -1)// human wins
            return depth - 10;
        if (score == 0)// draw
            return 0;

        if (isMaximizing) {
            int bestScore = -999;
            for (int i = 1; i < board.length; i++) {
                if (board[i] != 'X' && board[i] != 'O') {
                    char temp = board[i];
                    board[i] = 'X';
                    int currentScore = minimax(depth + 1, false);
                    board[i] = temp;
                    bestScore = Math.max(bestScore, currentScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = 999;
            for (int i = 1; i < board.length; i++) {
                if (board[i] != 'X' && board[i] != 'O') {
                    char temp = board[i];
                    board[i] = 'O';
                    int currentScore = minimax(depth + 1, true);
                    board[i] = temp;
                    bestScore = Math.min(bestScore, currentScore);
                }
            }
            return bestScore;
        }
    }

    static int findBestMove(char[] board) {
        int bestMove = -1;
        int bestScore = -999;
        for (int i = 1; i < board.length; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                char temp = board[i];
                board[i] = 'X';
                int currentScore = minimax(0, false);
                board[i] = temp;
                if (currentScore > bestScore) {
                    bestScore = currentScore;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char mark;
        int player = 0;
        int choice = 0, i = 2;
        // int i;

        do {
            display();
            if (player % 2 == 1)
                player = 1;
            else
                player = 2;

            if (player == 1) {
                try {
                    System.out.println("Player 1, Enter your number");
                    choice = sc.nextInt();
                    if (choice < 0 || choice > 9 || board[choice] == 'X' || board[choice] == 'O') {
                        throw new InputMismatchException();
                    }
                } catch (Exception e) {
                    sc.nextLine();
                    continue;
                }
                mark = 'X';
            } else {
                // AI's turn
                choice = findBestMove(board);
                mark = 'O';
            }

            if (board[choice] != 'X' && board[choice] != 'O')
                board[choice] = mark;
            else {
                System.out.println("Invalid Move. Try again");
                player--;
            }

            i = checkwin(board);
            player++;
        } while (i == 0);

        display();

        if (i == 1 && player == 3) {
            System.out.println("AI Wins.....");
        } else if (i == 1 && player == 2) {
            System.out.println("You're the Winner...");
        } else if (i == -1) {
            System.out.println("Game draw....");
        }
        sc.close();
    }
}