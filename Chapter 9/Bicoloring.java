import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
	public static boolean DepthFirstSearch(Graph G, int v, boolean[] seen, boolean[] color) //Returns true if Bicolorable
	 {
	     for (int vertex : G.adjacencyList.get(v))
	     {
	    	 if (seen[vertex] == false)
	         {
	             seen[vertex] = true;
	             color[vertex] = !color[v];
	             if (DepthFirstSearch(G, vertex, seen, color) != true)
	                 return false;
	         }
	         else if (color[v] == color[vertex]) 
	         {
	             return false;
	         }
	     }
	     return true;
	 }
	
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int V = input.nextInt();
		while(V != 0)
		{
			int e = input.nextInt();
			List<Edge> E = new ArrayList<>();
			for(int i = 0; i < e; i++)
			{
				int v1 = input.nextInt();
				int v2 = input.nextInt();
				E.add(new Edge(v1, v2));			
			}
			Graph graph = new Graph(E, V);
			boolean[] seen = new boolean[V];
			boolean[] color = new boolean[V];
			color[0] = false;
			seen[0] = true;
	        
	        if (DepthFirstSearch(graph, 0, seen, color))
	            System.out.println("BICOLORABLE.");
	        else
	            System.out.println("NOT BICOLORABLE.");
	        V=input.nextInt();			
		}
		input.close();
		System.exit(0);		
	}	
}

//Data structure to store graph edges
class Edge
{
	int v1;
	int v2;
	public Edge(int v1, int v2) 
	{
		this.v1 = v1;
		this.v2 = v2;
	}
};

//Class to represent a graph object
class Graph
{
	//adjacency list
	List<List<Integer>> adjacencyList = null;

	// Constructor
	Graph(List<Edge> edges, int N)
	{
		adjacencyList = new ArrayList<>(N);

		for (int i = 0; i < N; i++) 
		{
			adjacencyList.add(i, new ArrayList<>());
		}

		// add edges to the undirected graph
		for (int i = 0; i < edges.size(); i++)
		{
			int v1 = edges.get(i).v1;
			int v2 = edges.get(i).v2;
			adjacencyList.get(v1).add(v2);
			adjacencyList.get(v2).add(v1);
		}
	}
}