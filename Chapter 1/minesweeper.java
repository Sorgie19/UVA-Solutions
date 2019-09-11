import java.util.*;
class Main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in); //Declaring Scanner
		int row = input.nextInt(); //Amount of Rows in Minesweeper
		int col = input.nextInt(); //Amount of Cols in Minesweeper
		int gameNum = 1; // Amount of games played
		while(row > 0 && col > 0) //Play until valid input is entered
		{
			String[] gameBoard = new String[row]; //Single Array for Minesweeper field
			for(int i = 0; i < row; i++) //Get input for each row
			{
				gameBoard[i] = input.next();
			}
			if(gameNum > 1) //Print out empty line after first game
				System.out.println();
			System.out.println(String.format("Field #%d:", gameNum)); //Print formatted string
			printBoard(gameBoard, row, col); //Function that prints the output of board
			row = input.nextInt(); //Get new user input for ROW
			col = input.nextInt(); //Get new user input for COL
			gameNum++; //Increment game counter
		}	
		input.close(); //Close scanner
		System.exit(0); 
	}
	
	static void printBoard(String[] gameBoard, int row, int col) //Prints output of final board
	{
		for(int r = 0; r < row; r++) //Loops through rows
		{
			for(int c = 0; c < col; c++) //Loops through columns
			{
				if(gameBoard[r].charAt(c) == '*') //If character at this index is '*' print '*'
				{
					System.out.print('*');
				}
				else if(gameBoard[r].charAt(c) == '.') //Else if it's a '.' print number of bombs adjacent to it
				{
					System.out.print(countBombs(gameBoard, row, col, r, c));
				}
			}
			System.out.println();
		}
	}
	
	
	static int countBombs(String gameBoard[], int row, int col, int r, int c) //Returns number of bombs adjacent to the given point
	{ //Row = max row | Col = max col | r = current row | c= current col
		int count = 0;
		for(int i = r-1; i <= r+1; i++) //Check up and down rows
		{
			for(int k = c-1; k <= c+1; k++) //Check up and down cols
			{
				if(i >= 0 && i < row && k >= 0 && k < col) //If bomb is adjacent to '.' increment bomb counter
				{
					if(gameBoard[i].charAt(k) == '*')
					{
						count++;
					}
				}
			}
		}
		return count; //Return total count
	}

}
