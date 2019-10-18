package Chapter7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Factovisors
{

	// Returns Factorial of N
	public static BigInteger factorial(int N)
	{
		if (N == 0)
			return BigInteger.ONE;
		// Initialize result
		BigInteger f = new BigInteger("1"); // Or BigInteger.ONE

		// Multiply f with 2, 3, ...N
		for (int i = 2; i <= N; i++)
			f = f.multiply(BigInteger.valueOf(i));

		return f;
	}

	// Returns Factorial of N
	public static int intfactorial(int N)
	{
		if (N == 0)
			return 1;
		// Initialize result
		int f = 1; // Or BigInteger.ONE

		// Multiply f with 2, 3, ...N
		for (int i = 2; i <= N; i++)
			f *= i;

		return f;
	}

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		while (input.hasNext())
		{
			/*
			 * int n = input.nextInt(); int m = input.nextInt(); BigInteger factorial =
			 * factorial(n); BigInteger test = BigInteger.valueOf(m); BigInteger remainder =
			 * factorial.mod(test); if (remainder.signum() == 0) System.out.println(m +
			 * " divides " + n + "!"); else System.out.println(m + " does not divide " + n +
			 * "!");
			 */
			int n = input.nextInt();
			int m = input.nextInt();
			int factorial = intfactorial(n);
			ArrayList<Integer> mprimes = primeFactorization(m);
			// Create a new ArrayList
			ArrayList<Integer> newList = new ArrayList<Integer>();

			// Traverse through the first list
			for (Integer element : mprimes)
			{

				// If this element is not present in newList
				// then add it
				if (!newList.contains(element))
				{

					newList.add(element);
				}
			}

			HashMap<Integer, Integer> mPowerCount = countFrequencies(mprimes);
			boolean divisible = true;
			for (int i = 0; i < newList.size(); i++)
			{
				if (!divisible)
					break;
				if (!(getPowers(n, newList.get(i)) > mPowerCount.get(newList.get(i))))
				{
					divisible = false;
					break;
				}

			}

			if (divisible)
				System.out.println(m + " divides " + n + "!");
			else
				System.out.println(m + " does not divide " + n + "!");

		}

		input.close();
		System.exit(0);
	}

	public static ArrayList<Integer> primeFactorization(int n)
	{
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < n; i++)
		{
			while (n % i == 0)
			{

				primes.add(i);
				n = n / i;
			}
		}
		if (n > 2)
			primes.add(n);
		return primes;
	}

	public static int getPowers(int n, int p)
	{
		int res = 0;
		for (int power = p; power <= n; power *= p)
			res += n / power;
		return res;
	}

	public static HashMap<Integer, Integer> countFrequencies(ArrayList<Integer> list)
	{
		HashMap<Integer, Integer> powerPrimes = new HashMap<Integer, Integer>();
		// hash set is created and elements of
		// arraylist are insertd into it
		Set<Integer> st = new HashSet<Integer>(list);
		for (Integer s : st)
		{
			powerPrimes.put(s, Collections.frequency(list, s));
		}

		return powerPrimes;
	}
}
