 import java.util.*;

public class TicTacToe
{
	static int arr[][] = new int[3][3];
	static int cnt = 0, trial = 9;
	static String plyr1, plyr2;

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[])
	{
		int respo = 1;
		System.out.print("Tic Tac Toe \n");
		System.out.print("Note: By default player 1 is assigned '1' and player 2 is assigned '2'");
		System.out.print("\n\nEnter the name of player 1: ");
		plyr1 = sc.nextLine();

		System.out.print("Enter the name of player 2: ");
		plyr2 = sc.nextLine();
		
		do
		{
			aa:while(trial >= 1)
			{
				player1Turn();
				cnt++;
				if(cnt > 4)
				{
					for(int a = 0; a <= 2; a++)
					{
						if(arr[a][0] ==1 && arr[a][1] == 1 && arr[a][2] == 1 || arr[0][a] == 1 && arr[1][a] == 1 && arr[2][a] == 1)
						{
							System.out.print("\n\n " + plyr1 + " wins!!");
							break aa;	
						}
						
					}
		
					//checking the diagonals
					if(arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1 || arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1)
					{
						System.out.print("\n\n " + plyr1 + " wins!!");
							break aa;
					}
				}
		
				//checkLine();
			
				//System.out.print(trial);
			
				if(trial == 0)
				{
					System.out.println("\n\n It's a draw!!");				
						break;
				}
				
				
				player2Turn();
				cnt++;
				if(cnt > 4)
				{
					for(int a = 0; a <= 2; a++)
					{	
						if(arr[a][0] ==2 && arr[a][1] == 2 && arr[a][2] == 2 || arr[0][a] == 2 && arr[1][a] == 2 && arr[2][a] == 2)
						{
							System.out.print("\n\n " + plyr2 + " wins!!");
							break aa;	
						}
						
					}
		
					if(arr[0][0] == 2 && arr[1][1] == 2 && arr[2][2] == 2 || arr[0][2] == 2 && arr[1][1] == 2 && arr[2][0] == 2)
					{
						System.out.print("\n\n " + plyr2 + " wins!!");
						break aa;
					}
				}
				//checkLine();
				
				//System.out.print(trial);
			}
			System.out.print("\n\nDo you want to continue [0/1]?");
			respo = sc.nextInt();
		}while(respo != 1);
	}

	public static void player1Turn()
	{
		System.out.print("\n" +plyr1+ "'s turn\n Enter the position to insert your sign [1 - 9]: ");
		int pos = sc.nextInt();
		int a = 0, b = 0;
		if(pos == 1)
		{
			a = 0; b = 0;
		}
		else if(pos == 2)
		{
			a = 0; b = 1;
		}
		else if(pos == 3)
		{
			a = 0; b = 2;
		}
		else if(pos == 4)
		{
			a = 1; b = 0;
		}
		else if(pos == 5)
		{
			a = 1; b = 1;
		}
		else if(pos == 6)
		{
			a = 1; b = 2;
		}
		else if(pos == 7)
		{
			a = 2; b = 0;
		}
		else if(pos == 8)
		{
			a = 2; b = 1;
		}
		else
		{
			a = 2; b = 2;
		}


		if(arr[a][b] != 0)
		{
			System.out.println("\nPosition is already filled. Try again!!");
			player1Turn();
		}
		else
		{
			arr[a][b] = 1;
			System.out.println("\n|-----------|");
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					System.out.print("| " + arr[i][j] + " ");	
				}
				System.out.println("|\n|-----------|");  
			}

			trial--;
		}
	}

	public static void player2Turn()
	{
		System.out.print("\n" +plyr2+ "'s turn\n Enter the position to insert your sign [1 - 9]:  ");
		int pos = sc.nextInt();
		int a = 0, b = 0;
		if(pos == 1)
		{
			a = 0; b = 0;
		}
		else if(pos == 2)
		{
			a = 0; b = 1;
		}
		else if(pos == 3)
		{
			a = 0; b = 2;
		}
		else if(pos == 4)
		{
			a = 1; b = 0;
		}
		else if(pos == 5)
		{
			a = 1; b = 1;
		}
		else if(pos == 6)
		{
			a = 1; b = 2;
		}
		else if(pos == 7)
		{
			a = 2; b = 0;
		}
		else if(pos == 8)
		{
			a = 2; b = 1;
		}
		else
		{
			a = 2; b = 2;
		}

		if(arr[a][b] != 0)
		{
			System.out.println("\nPosition is already filled. Try again!!");
			player2Turn();
		}
		else
		{
			arr[a][b] = 2;
			System.out.println("\n|-----------|");
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					System.out.print("| " + arr[i][j] + " ");	
				}
				System.out.println("|\n|-----------|");  
			}

			trial--;
		}
	}
}