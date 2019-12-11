import java.util.Scanner;

public class Main
{
	public static boolean factoviser(int n, int prime, int count)
	{
		int p = prime;
		while ((n / p) != 0 && count > 0)
		{
			count -= n / p;
			p *= prime;
		}
		return count <= 0;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine())
		{			
			String line = input.nextLine();
			if (line.isEmpty())
				break;
			String[] digits = line.split(" ");			
			int numerator = Integer.valueOf(digits[0]);
			int divisor = Integer.valueOf(digits[1]);
			int temp = divisor;
			boolean isDivisor = true;
			for (int i = 2; i * i <= divisor && isDivisor; ++i)
			{
				int count = 0;
				while (divisor % i == 0)
				{
					divisor /= i;
					++count;
				}

				if (count > 0)
					isDivisor = factoviser(numerator, i, count);
			}

			if (divisor > 1 && isDivisor)
				isDivisor = factoviser(numerator, divisor, 1);
			
			if (isDivisor == true)
				System.out.println(temp + " divides " + numerator + "!");
			else
				System.out.println(temp + " does not divide " + numerator + "!");
		}

		input.close();
		System.exit(0);
	}
}