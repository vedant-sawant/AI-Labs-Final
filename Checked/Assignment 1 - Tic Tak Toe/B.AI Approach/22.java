
import java.util.*;

public class tictactoe_AI {

    public static boolean game(char positions[]) {
        if ((positions[0] == positions[1] && positions[1] == positions[2])
                || (positions[3] == positions[4] && positions[4] == positions[5])
                || (positions[6] == positions[7] && positions[7] == positions[8])
                || (positions[0] == positions[3] && positions[3] == positions[6])
                || (positions[1] == positions[4] && positions[4] == positions[7])
                || (positions[2] == positions[5] && positions[5] == positions[8])
                || (positions[0] == positions[4] && positions[4] == positions[8])
                || (positions[2] == positions[4] && positions[4] == positions[6])) {
            return true;

        }

        return false;
    }

    public static int evaluate(char positions[], char player) {
        char aiPlayer = 'O';
        char humanPlayer = 'X';

        if ((positions[0] == player && positions[1] == player && positions[2] == player)
                || (positions[3] == player && positions[4] == player && positions[5] == player)
                || (positions[6] == player && positions[7] == player && positions[8] == player)
                || (positions[0] == player && positions[3] == player && positions[6] == player)
                || (positions[1] == player && positions[4] == player && positions[7] == player)
                || (positions[2] == player && positions[5] == player && positions[8] == player)
                || (positions[0] == player && positions[4] == player && positions[8] == player)
                || (positions[2] == player && positions[4] == player && positions[6] == player)) {
            return (player == aiPlayer) ? 10 : -10;
        }
        return 0;
    }

    public static int minimax(char positions[], int depth, boolean isMaximizing) {
        char aiPlayer = 'O';
        char humanPlayer = 'X';

        int score = evaluate(positions, aiPlayer);
        if (score == 10)
            return score;
        if (score == -10)
            return score;
        if (game(positions))
            return 0;

        if (isMaximizing) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (positions[i] != 'X' && positions[i] != 'O') {
                    char temp = positions[i];
                    positions[i] = aiPlayer;
                    best = Math.max(best, minimax(positions, depth + 1, !isMaximizing));
                    positions[i] = temp;
                }
            }
            return best- depth;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (positions[i] != 'X' && positions[i] != 'O') {
                    char temp = positions[i];
                    positions[i] = humanPlayer;
                    best = Math.min(best, minimax(positions, depth + 1, !isMaximizing));
                    positions[i] = temp;
                }
            }
            return best + depth;
        }
    }

    public static void makeMoveAI(char positions[]) {
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE;
        char aiPlayer = 'O';

        for (int i = 0; i < 9; i++) {
            if (positions[i] != 'X' && positions[i] != 'O') {
                char temp = positions[i];
                positions[i] = aiPlayer;
                int moveScore = minimax(positions, 0, false);
                positions[i] = temp;
                if (moveScore > bestScore) {
                    bestScore = moveScore;
                    bestMove = i;
                }
            }
        }

        positions[bestMove] = aiPlayer;
        System.out.println("Player " + aiPlayer + " chose position " + bestMove);
    }

    public static void validinput(char positions[], char player) {
        if (player == 'X') {
            Scanner sc = new Scanner(System.in);
            System.out.println("Player " + player + " Please Enter your choice");
            int choice = sc.nextInt();
            if (choice < 0 || choice > 8) {
                System.out.println("Invalid input!!!!  Try again");
                validinput(positions, player);
            } else {
                if (positions[choice] != 'X' && positions[choice] != 'O') {
                    positions[choice] = player;
                } else {
                    System.out.println("Invalid input!!!!  Try again");
                    validinput(positions, player);
                }
            }
        } else if (player == 'O') {
            makeMoveAI(positions);
        }
    }

    public static void display(char positions[]) {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                System.out.println();
                System.out.println("------------");
            }

            System.out.print(positions[i] + " | ");
        }
        System.out.println();
        System.out.println();

    }

    public static void main(String args[]) {
        System.out.println("Enter only numeric input (0 to 8)");

        int count = 0;
        char positions[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };

        System.out.println("Let's start game");
        display(positions);

        while (!game(positions)) {
            if (count == 9) {
                System.out.println("Game is draw!!!");
                break;
            }

            validinput(positions, 'X');
            count++;

            display(positions);
            if (game(positions)) {
                display(positions);
                System.out.println("Player X is winner.");
                break;
            }
            if (count == 9) {
                display(positions);
                System.out.println("Game is over!!!");
                break;
            }

            validinput(positions, 'O');
            count++;
            display(positions);

            if (game(positions)) {
                display(positions);
                System.out.println("Player O is winner.");
                break;
            }

        }

    }
}