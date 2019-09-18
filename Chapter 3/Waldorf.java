package Chapter2;

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
							if(searchUp(grid, searchWord, n, m, i, k) ||
							searchDown(grid, searchWord, n, m, i, k) ||
							searchLeft(grid, searchWord, n, m, i, k) ||
							searchRight(grid, searchWord, n, m, i, k) ||
							searchDiagUpRight(grid, searchWord, n, m, i, k) ||
							searchDiagUpLeft(grid, searchWord, n, m, i, k) ||
							searchDiagDownLeft(grid, searchWord, n, m, i, k) ||
							searchDiagDownRight(grid, searchWord, n, m, i, k))
							{
								System.out.println(i + " " + k);
							}
						}
					}
				}
			}
			
			
			
			//Printing board
			/*for(int i = 0; i < m; i++)
			{
				for(int k = 0; k < n; k++)
				{
					System.out.print(grid[i][k]);
				}
				System.out.println();
			}*/		
		}	

	}
	
	public static boolean searchUp(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		//if length of word is longer than search up
		return false;
		
		
	}
	
	public static boolean searchDown(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		//if length of word is longer than search up
		return false;
		
		
	}
	
	public static boolean searchLeft(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		//if length of word is longer than search up
		return false;
		
		
	}
	
	public static boolean searchRight(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		//if length of word is longer than search up
		return false;
		
		
	}
	
	public static boolean searchDiagUpRight(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		//if length of word is longer than search up
		return false;
		
		
	}
	
	public static boolean searchDiagUpLeft(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		//if length of word is longer than search up
		return false;
		
		
	}
	
	public static boolean searchDiagDownLeft(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		//if length of word is longer than search up
		return false;
		
		
	}
	
	public static boolean searchDiagDownRight(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		//if length of word is longer than search up
		return false;
		
		
	}

}
