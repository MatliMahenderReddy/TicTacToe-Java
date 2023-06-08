import java.util.Scanner;

public class TicTacToe {
	
	//Draw the Board
		private static void drawBoard(char[][] board) {
			// TODO Auto-generated method stub
			
			for(int i=0;i<board.length;i++)
			{
				for(int j=0;j<board.length;j++)
				{
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			
		}	
		// check the who are win
	private static char playerHasWon(char[][] board) {
		// TODO Auto-generated method stub
		
		       char value='-';
				
					do {
						 //check the column wise
						for(int j=0;j<=2;j++)
						{
							if(board[0][j]==board[1][j]&&board[1][j]==board[2][j])
							{
								value=board[0][j];
								break;
							}
						}
						// check the Row wise
						for(int i=0;i<=2;i++)
						{
							if(board[i][0]==board[i][1]&&board[i][1]==board[i][2])
							{
								value=board[i][0];
								break;
							}
						}
//			check the Dialgonals wise
						
						if(board[0][0]==board[1][1]&&board[1][1]==board[2][2])
						{
							value =board[0][0];
							break;
						}
						else if( board[0][2]==board[1][1]&&board[1][1]==board[2][0])
						{
							value =board[0][2];
							break;
						}
					}while(false);
					
		return value;	
	}
	// check board is full are not
	private static boolean boardIsFull(char[][] board) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++) 
			{
			   if(board[i][j] == '-') 
			  {  
			      return false;
			  }
			}
		}
			return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner sc=new Scanner(System.in);
		int n=3;
		char board[][]=new char[n][n];
		char A='A';
		char X='X';
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j]='-';
			}
		}
		boolean player=true;
		boolean gameStart=true;
		while(gameStart)
		{
			drawBoard(board);
			if(player)
			{
				System.out.println(A+" turn");
			}
			else
			{
				System.out.println(X+" turn");	
			}
			char c='-';
			if(player)
			{
				c=A;
			}
			else
			{
				c=X;
			}
			int row=0;
			int col=0;
			while(true)
			{
				System.out.println("Enter the row");
				row=sc.nextInt();
				System.out.println("Enter the col");
				col=sc.nextInt();
				
				if( row >= n || col >= n)
				{
					System.out.println("This position is out of the board");
				}
				else if(board[row][col] != '-') 
				{
					System.out.println("Someone has already is there");
				}
				else
				{
					break;
				}

			}
			//passed the value in board
			board[row][col] = c;
			if(playerHasWon(board) == 'A')
			{
				
				System.out.println("Player "+A + " has won!");
				gameStart=false;
			}
			else if(playerHasWon(board) == 'X')
			{
				System.out.println("Player "+X + " has won!");
				gameStart = false;
			}
			else
			{
				if(boardIsFull(board))
				{
					System.out.println("It's a Draw");
					gameStart = false;
				}
				else
				{
				  player = !player;
				}
			}
		}
		
		drawBoard(board);	
	}
}
