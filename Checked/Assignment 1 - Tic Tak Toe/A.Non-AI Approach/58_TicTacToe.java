//TicTacToe Game

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] playboard = new char[3][3];

        char chance;
        String p1;
        String p2;

        System.out.print("Enter Player 1's name: ");
        p1 = sc.nextLine();

        System.out.print("Enter Player 2's name: ");
        p2 = sc.nextLine();

        System.out.println(p1+" plays: X");
        System.out.println(p2+" plays: O \n");

        for (int i = 0; i < 9; i++) {

            if (i == 8) {
                System.out.println("Draw");
                break;
            }

            if ((playboard[0][0] == 'X' && playboard[1][1] == 'X' && playboard[2][2] == 'X')
                    || (playboard[0][2] == 'X' && playboard[1][1] == 'X' && playboard[2][0] == 'X')) {
                System.out.println("*************************");
                System.out.println( p1 + " won !");
                System.out.println("*************************");
                break;
            } else if ((playboard[0][0] == 'O' && playboard[1][1] == 'O' && playboard[2][2] == 'O')
                    || (playboard[0][2] == 'O' && playboard[1][1] == 'O' && playboard[2][0] == 'O')) {
                System.out.println("*************************");
                System.out.println(p2 + " won !");
                System.out.println("*************************");
                break;
            }

            if ((playboard[0][0] == 'X' && playboard[0][1] == 'X' && playboard[0][2] == 'X')
                    || (playboard[1][0] == 'X' && playboard[1][1] == 'X' && playboard[1][2] == 'X')
                    || (playboard[2][0] == 'X' && playboard[2][1] == 'X' && playboard[2][2] == 'X')) {
                System.out.println("*************************");
                System.out.println( p1 + " won !");
                System.out.println("*************************");
                break;
            } else if ((playboard[0][0] == 'O' && playboard[0][1] == 'O' && playboard[0][2] == 'O')
                    || (playboard[1][0] == 'O' && playboard[1][1] == 'O' && playboard[1][2] == 'O')
                    || (playboard[2][0] == 'O' && playboard[2][1] == 'O' && playboard[2][2] == 'O')) {
                System.out.println("*************************");
                System.out.println(p2 + " won !");
                System.out.println("*************************");
                break;
            }

            if ((playboard[0][0] == 'X' && playboard[1][0] == 'X' && playboard[2][0] == 'X')
                    || (playboard[0][1] == 'X' && playboard[1][1] == 'X' && playboard[2][1] == 'X')
                    || (playboard[0][2] == 'X' && playboard[1][2] == 'X' && playboard[2][2] == 'X')) {
                System.out.println("*************************");
                System.out.println( p1 + " won !");
                System.out.println("*************************");
                break;
            } else if ((playboard[0][0] == 'O' && playboard[1][0] == 'O' && playboard[2][0] == 'O')
                    || (playboard[0][1] == 'O' && playboard[1][1] == 'O' && playboard[2][1] == 'O')
                    || (playboard[0][2] == 'O' && playboard[1][2] == 'O' && playboard[2][2] == 'O')) {
                System.out.println("*************************");
                System.out.println(p2 + " won !");
                System.out.println("*************************");
                break;
            }

            if (i % 2 == 0) {
                System.out.println("*******************************************");
                System.out.println(p1 + "'s turn to play!");
                System.out.println("*******************************************");
                chance = 'X';
            } else {
                System.out.println("*******************************************");
                System.out.println(p2 + "'s turn to play!");
                System.out.println("*******************************************");
                chance = 'O';
            }
            System.out.print("Enter the position of your move (range: 1-9): ");
            int pos = sc.nextInt();
            sc.nextLine();

            int r = 0;
            int c = 0;

            if (pos == 1) {
                r = 0;
                c = 0;
            } else if (pos == 2) {
                r = 0;
                c = 1;
            } else if (pos == 3) {
                r = 0;
                c = 2;
            } else if (pos == 4) {
                r = 1;
                c = 0;
            } else if (pos == 5) {
                r = 1;
                c = 1;
            } else if (pos == 6) {
                r = 1;
                c = 2;
            } else if (pos == 7) {
                r = 2;
                c = 0;
            } else if (pos == 8) {
                r = 2;
                c = 1;
            } else if (pos == 9) {
                r = 2;
                c = 2;
            }

            playboard[r][c] = chance;
            System.out.println("|---|---|---|");
            System.out.println("| " + playboard[0][0] + " | "
                    + playboard[0][1] + " | " + playboard[0][2]
                    + " |");
            System.out.println("|-----------|");
            System.out.println("| " + playboard[1][0] + " | "
                    + playboard[1][1] + " | " + playboard[1][2]
                    + " |");
            System.out.println("|-----------|");
            System.out.println("| " + playboard[2][0] + " | "
                    + playboard[2][1] + " | " + playboard[2][2]
                    + " |");
            System.out.println("|---|---|---|");
        }

        System.out.println("Winning matrix: " + Arrays.deepToString(playboard));
    }
}
