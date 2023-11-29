import java.util.Scanner;

public class Main {
    public static void printboard(char board[]) {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8] + " ");

    }

    public static void takeinput(char board[], char player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player "+player + " enter your choice");
        int choice = sc.nextInt();
        if(choice<0 || choice > 8)
        {
            System.out.println("Invalid move.. Try again...");
            takeinput(board, player);
        }
        else
        {
            if (board[choice] != 'X' && board[choice] != 'O') {
                board[choice] = player;
            } else {
                System.out.println("Invalid move.. Try again...");
                takeinput(board, player);
            }
        }

    }

    public static boolean win(char[] board) {
        if ((board[0] == board[1] && board[1] == board[2])
               || (board[3] == board[4] && board[4] == board[5])
                || (board[6] == board[7] && board[7] == board[8])
                || (board[0] == board[3] && board[3] == board[6])
                || (board[1] == board[4] && board[4] == board[7])
                || (board[2] == board[5] && board[5] == board[8])
                || (board[0] == board[4] && board[4] == board[8])
                || (board[2] == board[4] && board[4] == board[6]))
        {
            return true;

        }

        return false;

    }

    public static boolean gameover(char board[]) {
        if (board[0] != '0' && board[1] != '1' && board[2] != '2' && board[3] != '3' && board[4] != '4' && board[5] != '5' &&
                board[6] != '6' && board[7] != '7' && board[8] != '8') {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        char board[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
        char player;
        player = 'X';
        while (!gameover(board))
        {
            printboard(board);
            takeinput(board, player);
            if (win(board))
            {
                System.out.println("Player "+player + " won the game");
                break;
            }
            if (gameover(board))
            {
                System.out.println("Game is Tie!!! Try Again....");
                break;
            }
            if (player == 'X')
            {
                player = 'O';
            }
            else
            {
                player = 'X';
            }

        }

    }
}
