import java.util.*;
class Main
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);		
		int testCase = input.nextInt();
		while(testCase-- > 0)
		{
			HashMap<String, Integer> shortestPath = new HashMap<String, Integer>();			
			HashSet<String> forbidden = new HashSet<String>();
			HashSet<String> seen = new HashSet<String>();
			Queue<String> Q = new LinkedList<String>();
			String initial = getInputs(input);			
			String target = getInputs(input);			
			int forbiddenCombinations = input.nextInt();			
			addForbiddenCombinations(forbiddenCombinations, input, forbidden);			
			BredthFirstSearch(Q, forbidden, seen, shortestPath, initial);			
			printPossibility(target, shortestPath);
		}
		
		input.close();
		System.exit(0);
	}
	
	static void printPossibility(String target, HashMap<String, Integer> distance)
	{
		if (distance.containsKey(target))
			System.out.println(distance.get(target));
		else
			System.out.println(-1);
	}
	
	static void BredthFirstSearch(Queue<String> queue, HashSet<String> forbidden, HashSet<String> visited, HashMap<String, Integer> distance, String initial)
	{
		visited.add(initial);
		distance.put(initial, 0);
		queue.offer(initial);
		while (!queue.isEmpty()) 
		{
			String v = queue.poll();

			for (int i = 0; i < 4; i++) 
			{
				char[] c = v.toCharArray();
				if(c[i] > '0')
					c[i] = (char)(c[i] - 1);
				else
					c[i] = '9';
					
				String w = String.valueOf(c);
				
				if (!visited.contains(w) && !forbidden.contains(w)) 
				{
					int dist = distance.get(v) + 1;
					visited.add(w);
					distance.put(w, dist);
					queue.offer(w);
				}
				
				c = v.toCharArray();				
				if(c[i] < '9')
					c[i] = (char)(c[i] + 1);
				else
					c[i] = '0';
				
				w = String.valueOf(c);
				
				if(!forbidden.contains(w) && !visited.contains(w)) 
				{
					int dist = distance.get(v) + 1;
					visited.add(w);						
					distance.put(w, dist);
					queue.offer(w);
				}
			}
		}
	}
	
	static String getInputs(Scanner input)
	{
		String S = input.next() 
				+ input.next() 
				+ input.next() 
				+ input.next();
		return S;
	}
	
	static void addForbiddenCombinations(int forbiddenCombinations, Scanner input, HashSet<String> forbidden)
	{
		//Gets N amount of forbidden combinations and adds it to the 
		for (int i = 0; i < forbiddenCombinations; ++i)
		{
			forbidden.add(getInputs(input));
		}
	}
}