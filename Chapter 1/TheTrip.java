import java.text.DecimalFormat;
import java.util.*;
class TheTrip 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int totalCosts = input.nextInt();
		while(totalCosts != 0)
		{
			double[] cost = new double[totalCosts];
			
			for(int i = 0; i < totalCosts; i++)
			{
				cost[i] = input.nextDouble();
			}
			
			DecimalFormat df = new DecimalFormat();
			df.applyPattern("##0.00");
			System.out.println("$" + df.format(payToAverage(cost, totalCosts)));
			totalCosts = input.nextInt();
		}
		
		input.close();
		System.exit(0);
		
	}
	
	static double average(double[] cost, int totalCosts)
	{
		double total = 0;
		for(int i = 0; i < totalCosts; i++)
		{
			total += cost[i];
		}
		//double average = Math.round((total/totalCosts) * 100.000) / 100.000;
		double average = total/totalCosts;
		return average;
	}
	
	static double remainder(double[] cost, int totalCosts)
	{
		double total = 0;
		for(int i = 0; i < totalCosts; i++)
		{
			total += cost[i];
		}
		
		return total % totalCosts;
	}
	static double payToAverage(double[] cost, int totalCosts)
	{
		double a = 0;
		double b = 0;
		double average = average(cost, totalCosts);	
		double rem = remainder(cost, totalCosts);
		for(int i = 0; i < totalCosts; i++)
		{
			if(cost[i] > average)
			{
				a += cost[i] - average;
				b++;
			}
		}
		System.out.println (a + " " + b);
		double test = a - (Math.min(b, rem));
		return test;
	}

}
