import java.util.Scanner;

public class Waldorf
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		
		for(int testCase = 0; testCase < testCases; testCase++)
		{
			input.nextLine();
			input.nextLine();	
			
			int m = input.nextInt();
			int n = input.nextInt();
			input.nextLine();
			
			char[][] grid = new char[m][n];
			for(int i = 0; i < m; i++)
			{
				String line = input.nextLine().toLowerCase();
				grid[i] = line.toCharArray();
			}
			
			int numOfWords = input.nextInt();
			String[] words = new String[numOfWords];
			input.nextLine();
			for(int word = 0; word < numOfWords; word++)
			{
				String s = input.nextLine();
				char[] searchWord = s.toCharArray();
				
				for(int i = 0; i < m; i++)
				{
					for(int k = 0; k < n; k++)
					{
						if(searchWord[0] == grid[i][k])
						{
							//search up
							//search down
							//search left
							//search right
							//search up right diag
							//search up left diag
							//search down right diag
							//search down left diag
						}
					}
				}
			}
			
			
			
			//Printing board
			for(int i = 0; i < m; i++)
			{
				for(int k = 0; k < n; k++)
				{
					System.out.print(grid[i][k]);
				}
				System.out.println();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		

	}	

}
