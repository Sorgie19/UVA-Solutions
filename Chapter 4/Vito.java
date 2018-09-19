import java.util.*;
public class Vito
{
	public static void main(String []args)
	{
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		input.nextLine();
		String userInput = input.nextLine();
		String[] numbersArray = userInput.split(" ");
		
		int relatives = Integer.parseInt(numbersArray[0]);
		
		int[] streets = new int[numbersArray.length - 1];
		for (int i = 1; i < streets.length; i++)
		{
			streets[i] = Integer.parseInt(numbersArray[i]);
			System.out.println(streets[i]);
		}
		
		Arrays.sort(streets);
		
		double median;
		if (streets.length % 2 == 0)
		    median = ((double)streets[streets.length/2] + (double)streets[streets.length/2 - 1])/2;
		else
		    median = (double) streets[streets.length/2];
		int vitoHouse = (int)median;
		int sum = 0;
		
		for(int i = 0; i < relatives; i++)
		{
			sum += Math.abs(vitoHouse - streets[i]);
		}
		
		System.out.println(sum);
		
	}
	
}