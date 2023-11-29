import java.util.*;

    public class tic_tac_toe_1{
    
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
    
       
  

    

    public static void validinput(char positions[], char player) {
       
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
                System.out.println("Game is over!!!");
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