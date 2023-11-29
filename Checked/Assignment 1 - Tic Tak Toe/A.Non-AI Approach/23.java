import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToe {
    static char board[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    static void display() {
        System.out.println("Player 1 is X");
        System.out.println("Player 2 is O");
        System.out.println("|  |  |  |");
        System.out.println("| " + board[1] + "| " + board[2] + "| " + board[3] + "|");
        System.out.println("|  |  |  |");
        System.out.println("| " + board[4] + "| " + board[5] + "| " + board[6] + "|");
        System.out.println("|  |  |  |");
        System.out.println("| " + board[7] + "| " + board[8] + "| " + board[9] + "|");
    }

    static int checkwin() {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char mark;
        int player = 1;
        int choice = 0, i;
        do {
            display();
            if (player % 2 == 1)
                player = 1;
            else {
                player = 2;
            }
            try {
                System.out.println("Player" + player + ", Enter your number");
                choice = sc.nextInt();
                if (choice < 0 || choice > 9) {
                    throw new InputMismatchException();
                }
            } catch (Exception e) {
                sc.nextLine();
            }

            if (player == 1)
                mark = 'X';
            else {
                mark = 'O';
            }
            if (choice == 1 && board[1] == '1')
                board[1] = mark;
            else if (choice == 2 && board[2] == '2')
                board[2] = mark;
            else if (choice == 3 && board[3] == '3')
                board[3] = mark;
            else if (choice == 4 && board[4] == '4')
                board[4] = mark;
            else if (choice == 5 && board[5] == '5')
                board[5] = mark;
            else if (choice == 6 && board[6] == '6')
                board[6] = mark;
            else if (choice == 7 && board[7] == '7')
                board[7] = mark;
            else if (choice == 8 && board[8] == '8')
                board[8] = mark;
            else if (choice == 9 && board[9] == '9')
                board[9] = mark;
            else {
                System.out.println("Invalid Move. Try again");
                player--;
            }
            i = checkwin();
            player++;
        } while (i == 0);

        display();

        if (i == 1) {
            System.out.println("Player " + --player + " Wins.....");
        } else if (i == -1) {
            System.out.println("Game draw....");
        }
        sc.close();
    }
}