import java.util.*;

public class TicTacToeWithAI 
{
	private static char[][] board = new char[3][3];
	private static int currentPlayer = 0; // 0 for X, 1 for O
	private static int moves = 0;	
	
	public static void main(String[] args) 
	{
        	initializeBoard();

	        System.out.println("Tic Tac Toe with AI");
        	System.out.println("You: X || AI: O");
	
        	while (!isBoardFull()) 
		{
            		printBoard();
			
			if (currentPlayer == 0) 
			{		
				System.out.print("\nMark your position [1-9]: ");
		                Scanner scanner = new Scanner(System.in);
                		int move = scanner.nextInt();

		                int row = (move - 1) / 3;
                		int col = (move - 1) % 3;

		                if (move >= 1 && move <= 9 && board[row][col] == ' ') 
				{
					board[row][col] = 'X';
					currentPlayer = 1;
					moves++;
                		} 
				else 
                    			System.out.println("Invalid move. Try again.");
            		} 
			else 	
			{
		                findBestMove();
                		currentPlayer = 0;
		                moves++;
            		}
	
			if(moves > 4)
			{
				if (checkWinner('X')) 
				{
                			printBoard();
	                		System.out.println("You won!!");
			                break;
            			} 
				else if (checkWinner('O')) 
				{
        	        		printBoard();
			                System.out.println("AI Won!!");
                			break;
				}
        	    		
				if (moves == 3 * 3) 
				{
                			printBoard();
		        	        System.out.println("It's a draw!");
                			break;
	            		}
			}	

            		
        	}
    	}

    	private static void initializeBoard() 
	{
        	for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 3; j++) 
                		board[i][j] = ' ';
        	}
    	}
	
	private static boolean isBoardFull() 
	{
        	for (int i = 0; i < 3; i++) 
		{	
			for (int j = 0; j < 3; j++) 
			{
                		if (board[i][j] == ' ')
                    			return false; // not full
            		}
        	}
        	return true; // full
	}

	private static boolean checkWinner(char player) 
	{
        	// Check rows and columns
        	for (int i = 0; i < 3; i++) 
		{
			if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                		return true;
        	}

	        // Check diagonals
        	if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player))
            		return true;
	
		return false; // No winner
	}

    	private static int minimax(boolean isMaximizing) 
	{
        	if (checkWinner('X')) return -10;
	        if (checkWinner('O')) return 10;
        	if (isBoardFull()) return 0;

	        if (isMaximizing) 
		{
			int bestScore = Integer.MIN_VALUE;
            		for (int i = 0; i < 3; i++) 
			{
		                for (int j = 0; j < 3; j++) 
				{
					if (board[i][j] == ' ') 
					{
			                        board[i][j] = 'O';
                        			int score = minimax(false);
			                        board[i][j] = ' '; // Undo the move
                        			bestScore = Math.max(score, bestScore);
			                    }
		                }
			}
            		return bestScore;
        	} 
		else 
		{ 
			int bestScore = Integer.MAX_VALUE; 
            		for (int i = 0; i < 3; i++) 
			{
	                	for (int j = 0; j < 3; j++) 
				{
                    			if (board[i][j] == ' ') 
					{
			                        board[i][j] = 'X';
                        			int score = minimax(true);
			                        board[i][j] = ' '; // Undo the move
                        			bestScore = Math.min(score, bestScore);
					}
                		}
            		}
            		return bestScore;
		}
    	}

    	private static void findBestMove() 
	{
        	int bestMoveScore = Integer.MIN_VALUE;
	        int bestMoveRow = -1;
        	int bestMoveCol = -1;

	        for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
		                if (board[i][j] == ' ') 
				{
					board[i][j] = 'O';
			                int moveScore = minimax(false);
					board[i][j] = ' '; // Undo the move

                    			if (moveScore > bestMoveScore) 
					{
			                        bestMoveScore = moveScore;
                        			bestMoveRow = i;
			                        bestMoveCol = j;
					}
                		}
            		}
        	}

		int bestMove = (bestMoveRow * 3) + bestMoveCol + 1;
	        System.out.println("\nAI's move: " + bestMove);
        	board[bestMoveRow][bestMoveCol] = 'O';
    	}

    	private static void printBoard() 
	{
        	System.out.println("-------------");
	        for (int i = 0; i < 3; i++) 
		{
			System.out.println("| " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " |");
            		System.out.println("-------------");
        	}
    	}
}