import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); // Declaring scanner object
		int testCase = input.nextInt(); // Get # of testcases
		for (int t = 0; t < testCase; t++) // Iterate through testcases
		{
			PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
			int freckles = input.nextInt();
			input.nextLine();
			Point[] point = new Point[freckles];
			boolean[] visited = new boolean[freckles];
			double total = 0;
			boolean f = false;
			ArrayList<Edge> tempList = new ArrayList<Edge>();
			for (int i = 0; i < freckles; i++)
			{
				String[] coordinates = input.nextLine().split("[ ]");
				point[i] = new Point(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
			}

			for (int i = 0; i < freckles; i++)
			{
				for (int j = i + 1; j < freckles; j++)
				{
					Edge edge = new Edge(i, j, point[i].getX(), point[i].getY(), point[j].getX(), point[j].getY());// Create
																													// edge
																													// with
																													// points
					queue.add(edge); // Add edge to the priority queue
				}
			}

			Edge test = queue.poll();
			visited[test.getV()] = true;
			visited[test.getW()] = true;
			total += test.getLength();

			while (!f && !queue.isEmpty())
			{
				f = true;
				for (int i = 0; i < freckles; i++)
				{
					if (!visited[i])
					{
						f = false;
					}
				}
				if (!f)
				{
					Edge edge = queue.poll();
					if (!visited[edge.getV()] && !visited[edge.getW()])
					{
						tempList.add(edge);
					}
					else if ((visited[edge.getV()] && !visited[edge.getW()])
							|| (!visited[edge.getV()] && visited[edge.getW()]))
					{

						visited[edge.getV()] = true;
						visited[edge.getW()] = true;
						total += edge.getLength();
						queue.addAll(tempList);
						tempList.clear();

					}
				}
			}

			System.out.printf("%.2f\n", total);

			if (t < testCase - 1)
			{
				System.out.println();
			}
		}

		input.close();
		System.exit(0);
	}
}

class Edge implements Comparable<Edge>
{

	int v;
	int w;
	double x1;
	double x2;
	double y1;
	double y2;

	public Edge(int v, int w, double x1, double y1, double x2, double y2)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.v = v;
		this.w = w;

	}

	public void setNode1(int n)
	{
		this.v = n;
	}

	public void setNode2(int n)
	{
		this.w = n;
	}

	public int getV()
	{
		return this.v;
	}

	public int getW()
	{
		return this.w;
	}

	public void setX1(double x)
	{
		this.x1 = x;
	}

	public void setX2(double x)
	{
		this.x2 = x;
	}

	public void setY1(double y)
	{
		this.y1 = y;
	}

	public void setY2(double y)
	{
		this.y2 = y;
	}

	public double getX1()
	{
		return this.x1;
	}

	public double getX2()
	{
		return this.x2;
	}

	public double getY1()
	{
		return this.y1;
	}

	public double getY2()
	{
		return this.y2;
	}

	public double getLength()
	{
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	public int compareTo(Edge e)
	{
		if (getLength() < e.getLength())
		{
			return -1;
		}
		return 1;
	}
}

class Point
{
	double x;
	double y;

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(double y)
	{
		this.y = x;
	}

	public double getX()
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}

}
