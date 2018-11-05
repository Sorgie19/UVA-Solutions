import java.util.*;
//Ryan Sorge
class Main
{
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Node node = new Node();
		ArrayList<String> solution = new ArrayList<>();
		
		while (true) 
		{
			node.length = input.nextInt();
			if (node.length == 0) 
			{
				break;
			}
			node.cuts = input.nextInt();
			node.array = new int[node.cuts + 2];
			node.m = new int[node.cuts + 2][node.cuts + 2];
			node.array[0] = 0;
			node.array[node.cuts + 1] = node.length;
						
			for (int i = 1; i <= node.cuts; i++)
			{
				node.array[i] = input.nextInt();
			}			
			for (int[] row : node.m)
			{
				Arrays.fill(row, -1);
			}
			
			int answer = recurrance(0, node.cuts + 1, node);
			String s = ("The minimum cutting is " + answer + ".");
			solution.add(s);
			
		}

		String[] answer = solution.toArray(new String[solution.size()]);
		for(int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
		input.close();
		System.exit(0);
	}
	
	public static int recurrance(int left, int right, Node node) 
	{
		int result = MAX;
		if (node.m[left][right] != -1) 
		{
			return node.m[left][right];
		}
		if (left + 1 == right) 
		{
			return 0;
		}		
		for (int i = left + 1; i < right; i++) 
		{
			result = Math.min(result, recurrance(left, i, node) + recurrance(i, right, node) + node.array[right] - node.array[left]);
		}
		return node.m[left][right] = result;
	} 
	
}

class Node
{
	int[][] m;
	int[] array;
	int length;
	int cuts;	
}