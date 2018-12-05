import java.util.*;

public class Main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int n;
		int c;
		int x;
		int y;
		n = input.nextInt();
		int size = n + n + 1;
		int[] p = new int[size];

		for (int i = 1; i <= size - 1; i++)
		{
			p[i] = i;
		}

		while (input.hasNext())
		{
			c = input.nextInt();
			x = input.nextInt();
			y = input.nextInt();
			if (c == 0 && x == 0 && y == 0)
				break;
			if (c == 1)
				setFriends(p, n, x, y);
			if (c == 2)
				setEnemies(p, n, x, y);
			if (c == 3)
				System.out.println(areFriends(p, x, y));
			if (c == 4)
				System.out.println(areEnemies(p, n, x, y));

		}

		input.close();
		System.exit(0);

	}

	public static int find(int[] p, int i)
	{
		if (p[i] == i)
			return i;
		else
			return p[i] = find(p, p[i]);
	}

	public static void setFriends(int[] p, int n, int x, int y)
	{
		if (find(p, x) == find(p, y + n) || find(p, y) == find(p, x + n))
			System.out.println("-1");
		else
		{
			p[find(p, y)] = find(p, x);
			p[find(p, y + n)] = find(p, x + n);
		}
	}

	public static int areFriends(int[] p, int x, int y)
	{
		if (find(p, x) == find(p, y))
			return 1;
		else
			return 0;

	}

	public static void setEnemies(int[] p, int n, int x, int y)
	{
		if (find(p, x) == find(p, y))
			System.out.println("-1");
		else
		{
			p[find(p, x + n)] = find(p, y);
			p[find(p, y + n)] = find(p, x);
		}
	}

	public static int areEnemies(int p[], int n, int x, int y)
	{
		if (find(p, x) == find(p, y + n) || find(p, y) == find(p, x + n))
			return 1;
		else
			return 0;
	}

}