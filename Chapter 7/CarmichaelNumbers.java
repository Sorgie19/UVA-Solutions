import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
		int[] carmichaelNumbers = new int[]{561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341, 41041, 46657, 52633, 62745, 63973, 75361};
		Scanner input = new Scanner(System.in);
		int n;
		while((n = input.nextInt()) != 0) 
		{
			boolean isCar = false;
			for(int i = 0; i < carmichaelNumbers.length; i++)
			{
				if(n == carmichaelNumbers[i])
				{
					isCar = true;
					break;
				}
			}
			if(isCar)
				System.out.println("The number " + n + " is a Carmichael number.");
			else 
				System.out.println(n + " is normal.");			
		}
		input.close();
		System.exit(0);
	}
}