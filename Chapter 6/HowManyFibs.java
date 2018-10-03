import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
class Main
{
	
	public static void main(String[] args)
	{
	    ArrayList<BigInteger> fibList = new ArrayList<BigInteger>(); //Create list to hold fib sequence
	    fibList.add(BigInteger.ONE); //Add 1 to list
		fibList.add(new BigInteger("2")); //Add 2 to list
		for(int i = 2; i <= 500; i++) //Get Fibonacci Sequence up to 10^100
		{
			BigInteger nextFib = new BigInteger(fibList.get(i - 2).toString()).add(fibList.get(i - 1));
			fibList.add(nextFib);
		}
		
		Scanner input = new Scanner(System.in); //Declaring scanner object
		BigInteger a = input.nextBigInteger(); //Get int a
		BigInteger b = input.nextBigInteger(); //Get int b
		while(!(a.compareTo(BigInteger.ZERO) == 0 && b.compareTo(BigInteger.ZERO) == 0)) //While inputs aren't 0
		{
			System.out.println(getFibCount(fibList, a, b)); //Print out the fib count in between the ranges of a and b
			a = input.nextBigInteger();//get next a input
			b = input.nextBigInteger();//get next b input
		} 		
		
		input.close(); //Close scanner object
		System.exit(0); //Exit program successfully
	}
	
	static int getFibCount(ArrayList<BigInteger> fibList, BigInteger a, BigInteger b) //Function to count the fibonacci numbers inbetween a and b
	{
	    int index = 0; //Index variable
		int count = 0; //Counter for fib values in between a and b
		while(fibList.get(index).compareTo(b) <= 0)
		{
			if(fibList.get(index).compareTo(a) >= 0)
			    count++;
			index++;
		}
		return count;
	}	
}