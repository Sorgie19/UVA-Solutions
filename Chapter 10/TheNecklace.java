package Chapter10;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main
{
	static int testCase;
	static int traverse = 50;
	static int max = 100;
	static int MAX = 1000;
	static int[] edge = new int[MAX + 1];
	static int n;
	static int nextLine;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] adjcencyMatrix = new int[max][max];
	static int bead1 = 0;
	static boolean triggered;
	static int[] marked = new int[max];
	static int bead2 = 0;
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	static int[] outEdges = new int[max];
	
	public static void main(String[] args) throws Exception
	{
		testCase = Integer.valueOf(br.readLine());

		for (int i = 0; i < testCase; i++)
		{
			n = Integer.valueOf(br.readLine());
			for (int k = 0; k < max; k++)
			{
				for (int j = 0; j < max; j++)
				{
					adjcencyMatrix[k][j] = 0;
				}
				outEdges[k] = 0;
				marked[k] = 0;
			}

			for (int j = 0; j < n; j++)
			{
				String[] split = br.readLine().split(" ");
				editAdjacencyMatrix(split);
			}

			triggered = true;
			for (int j = 0; j <= traverse; j++)
			{
				if (!triggered)
					break;
				if (outEdges[j] % 2 == 1)
					triggered = false;
			}

			nextLine = 0;

			if (moreCases(i))
				System.out.println();

			if (triggered == true)
				dfsEdges();

			System.out.println("Case #" + (i + 1));
			boolean constructable = false;

			if (nextLine == n + 1)
				constructable = true;
			printNecklace(constructable);

		}

		pw.close();
		br.close();
		System.exit(0);
	}

	

	static int dfs(int source)
	{
		int visited = 0;
		for (int i = 1; i <= traverse; i++)
		{
			if (adjcencyMatrix[source][i] > 0)
			{
				adjcencyMatrix[source][i]--;
				adjcencyMatrix[i][source]--;
				visited += dfs(i) + 1;
			}
		}
		edge[nextLine++] = source;
		return visited;
	}

	static void dfsEdges()
	{
		for (int j = 0; j <= traverse; j++)
		{
			if (outEdges[j] > 0)
			{
				dfs(j);
				break;
			}
		}
	}

	static boolean moreCases(int i)
	{
		return i > 0;
	}

	static boolean constructable()
	{
		int c = n + 1;
		return (nextLine == c);
	}

	static void printNecklace(boolean constructable)
	{
		if (constructable)
		{
			for (int j = 0; j < nextLine - 1; j++)
			{
				System.out.println(edge[j] + " " + edge[j + 1]);
			}
		}
		else
			System.out.println("some beads may be lost");
	}

	static void editAdjacencyMatrix(String[] split)
	{
		adjcencyMatrix[Integer.valueOf(split[0])][Integer.valueOf(split[1])]++;
		outEdges[Integer.valueOf(split[0])]++;
		adjcencyMatrix[Integer.valueOf(split[1])][Integer.valueOf(split[0])]++;
		outEdges[Integer.valueOf(split[1])]++;
	}

}