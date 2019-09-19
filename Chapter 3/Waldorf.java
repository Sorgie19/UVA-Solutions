import java.util.Scanner;

public class Waldorf
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		input.nextLine();

		for (int testCase = 0; testCase < testCases; testCase++)
		{
			int m = input.nextInt();
			int n = input.nextInt();
			input.nextLine();

			char[][] grid = new char[m][n];
			for (int i = 0; i < m; i++)
			{
				String line = input.nextLine().toLowerCase();
				grid[i] = line.toCharArray();
			}

			int numOfWords = input.nextInt();
			input.nextLine();
			for (int word = 0; word < numOfWords; word++)
			{
				String s = input.nextLine().toLowerCase();
				char[] searchWord = s.toCharArray();

				for (int i = 0; i < m; i++)
				{
					boolean breakLoop = false;
					for (int k = 0; k < n; k++)
					{
						if (searchWord[0] == grid[i][k])
						{
							if (searchUp(grid, searchWord, m, n, i, k) || searchDown(grid, searchWord, m, n, i, k)
									|| searchLeft(grid, searchWord, m, n, i, k)
									|| searchRight(grid, searchWord, m, n, i, k)
									|| searchDiagUpRight(grid, searchWord, m, n, i, k)
									|| searchDiagUpLeft(grid, searchWord, m, n, i, k)
									|| searchDiagDownLeft(grid, searchWord, m, n, i, k)
									|| searchDiagDownRight(grid, searchWord, m, n, i, k))
							{
								System.out.println((i + 1) + " " + (k + 1));
								breakLoop = true;
								break;
							}
						}
					}
					if (breakLoop)
						break;
				}
			}
			if (testCase != testCases - 1)
			{
				System.out.println();
				input.nextLine();
			}
		}

		input.close();
		System.exit(0);

	}

	public static boolean searchUp(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		if ((a + 1 - word.length) < 0)
			return false;

		for (int i = 0; i < word.length; i++)
		{
			if (word[i] == grid[a][b])
				a--;
			else
				return false;
		}
		return true;

	}

	public static boolean searchDown(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		if ((a + word.length) > m)
			return false;

		for (int i = 0; i < word.length; i++)
		{
			if (word[i] == grid[a][b])
				a++;
			else
				return false;
		}
		return true;

	}

	public static boolean searchLeft(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		if (((b + 1) - word.length) < 0)
			return false;

		for (int i = 0; i < word.length; i++)
		{
			if (word[i] == grid[a][b])
				b--;
			else
				return false;
		}
		return true;

	}

	public static boolean searchRight(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		if (((b + word.length) > n))
			return false;

		for (int i = 0; i < word.length; i++)
		{
			if (word[i] == grid[a][b])
				b++;
			else
				return false;
		}
		return true;

	}

	public static boolean searchDiagUpRight(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		if ((a + 1 - word.length) < 0 || ((b + word.length) > n))
			return false;

		for (int i = 0; i < word.length; i++)
		{
			if (word[i] == grid[a][b])
			{
				a--;
				b++;
			}
			else
				return false;
		}
		return true;

	}

	public static boolean searchDiagUpLeft(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		if ((a + 1 - word.length) < 0 || ((b + 1 - word.length) < 0))
			return false;

		for (int i = 0; i < word.length; i++)
		{
			if (word[i] == grid[a][b])
			{
				a--;
				b--;
			}
			else
				return false;
		}
		return true;

	}

	public static boolean searchDiagDownLeft(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		if ((a + word.length) > m || ((b + 1 - word.length) < 0))
			return false;

		for (int i = 0; i < word.length; i++)
		{
			if (word[i] == grid[a][b])
			{
				a++;
				b--;
			}
			else
				return false;
		}
		return true;

	}

	public static boolean searchDiagDownRight(char[][] grid, char[] word, int m, int n, int a, int b)
	{
		if ((a + word.length) > m || ((b + word.length) > n))
			return false;

		for (int i = 0; i < word.length; i++)
		{
			if (word[i] == grid[a][b])
			{
				a++;
				b++;
			}
			else
				return false;
		}
		return true;

	}

}
