import java.text.DecimalFormat;
import java.util.Scanner;

class Main
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int totalCosts = input.nextInt();

		while (totalCosts != 0)
		{
			double[] costs = new double[totalCosts + 1];
			double average = 0;
			
			for (int i = 0; i < totalCosts; i++)
			{
				costs[i] = input.nextDouble();
				average += costs[i];
			}

			average = average / totalCosts;
			
			double positive = 0;
			double negative = 0;
			
			for (int i = 0; i < totalCosts; i++)
			{
				double v = (long) ((costs[i] - average) * 100.0) / 100.0;
				if (v > 0)
					positive += v;
				else
					negative += v;
			}
			
			
			negative = -negative;
			DecimalFormat df = new DecimalFormat();
			df.applyPattern("##0.00");
			double answer;
			if(negative > positive)
				answer = negative;
			else
				answer = positive;
			System.out.println("$" + df.format(answer));
			totalCosts = input.nextInt();
		}

		input.close();
		System.exit(0);
	}

}
