import java.io.IOException;
import java.util.Scanner;
//REFERENCE: https://github.com/Agetorp/UVA-solutions/blob/master/10245_The_Closest_Pair_Problem.java
//I developed my own algorithm that worked for finding the solution but my issue was time limit exceeded.
//I used a brute force algorithm to find the closest path.
//The referenced solution i found had almost the same algorithm as mine, except they used a 2 dimensional double array
//and I created my own Point class.
//No matter what i tried I kept getting time limit exceeded so I decided to just switch it over to the 2 dimensional array
public class Main
{

	public static void main(String[] args) throws IOException 
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();		
		while(true)
		{
			double[][] points = new double[n][2];
			//Pointss[] points = new Pointss[n];
			//input.nextLine();
			if(n == 0)
				break;
			for(int i = 0; i < n; i++)
			{
				points[i][0] = input.nextDouble();
				points[i][1] = input.nextDouble();	
			}			
			double min = minDistance(points);
			min = Math.round (min * 10000.0) / 10000.0;
            if(min <= 10000.0000)
                System.out.printf("%.4f%n", min);
            else
                System.out.println("INFINITY");
            n = input.nextInt();
			
		}
		
		input.close();
		System.exit(0);

	}
	
	static double distance(double[] a, double[] b)
	{
		double x = Math.abs(a[0] - b[0]);
		double y = Math.abs(a[1] - b[1]);
		//System.out.println(Math.sqrt((x*x) + (y*y)));
		return Math.sqrt((x*x) + (y*y));		
	}
	
	static double minDistance(double[][] P)
	{
		double min = Double.MAX_VALUE;
		for(int i = 0; i < P.length; i++)
			for(int k = i + 1; k < P.length; k++)
			{
				double d = distance(P[i], P[k]);
				if(d < min)
				{
					min = d;
				}
			}
		
		return min;		
	}
}

/*
class Pointss
{
	double x = 0.0;
	double y = 0.0;	
}
*/
