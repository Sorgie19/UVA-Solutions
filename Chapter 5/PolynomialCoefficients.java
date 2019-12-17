import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{	
		Scanner input = new Scanner(System.in);
		final int[] factorial = getFactorialArray(13);//Factorial array containing first 13 factorials
		while (input.hasNextLine())
		{			
			String line = input.nextLine(); //Gets first pair of input
			if (line.isEmpty()) //Used to check if there are any more inputs
				break;
			String[] digits = line.split(" "); //Splits the string into an array splitting by " "	
			int n = Integer.valueOf(digits[0]); //First int
			int k = Integer.valueOf(digits[1]); //Second int
			line = input.nextLine(); //Gets the second String of the pair of input 
			digits = line.split(" "); //Splits into an array splitting by " "
			int total = 1; 
			for(int i = 0; i < k; i++) //For each element in array
				total *= factorial[Integer.valueOf(digits[i])]; //Multiply the product by the factorial array at the current index of the digits array.
			int coefficient = factorial[n] / total; //(n! / (n1! * n2! * n3! * n4! * n5!...)
			System.out.println(coefficient); //Print answer 
		}
		
		input.close(); //Close input
		System.exit(0); 		
	}	
	
	public static int[] getFactorialArray(int n) //Returns an array with the n factorials
	{
		int[] factorial = new int[n];
		factorial[0] = 1;
		factorial[1] = 1;
		for (int i = 2; i < n; ++i)
			factorial[i] = i * factorial[i - 1];		
		return factorial;		
	}
}
