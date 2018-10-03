import java.util.Scanner;
import java.math.BigInteger;

class Main
{
  public static void main(String[] args)
  {
	  Scanner input = new Scanner(System.in); //Declaring Scanner Object for user input
	  BigInteger[] intPartitions = new BigInteger[1010]; //Array of BigInt max 1000
	  intPartitions[0] = BigInteger.ONE; //We know the first 4 elements of partition are 1, 2, 5, 13
	  intPartitions[1] = new BigInteger("2");
	  intPartitions[2] = new BigInteger("5");
	  intPartitions[3] = new BigInteger("13");
    
	  for(int i = 4; i < intPartitions.length; i++) //Using recurrence
	  {
		  BigInteger a = intPartitions[i-1]; // (n-1)
		  BigInteger b = intPartitions[i-2]; // (n-2)
		  BigInteger c = intPartitions[i-3]; // (n-3)
		  intPartitions[i] = a.add(a).add(b).add(c); //T(n) = T(n-1) + T(n-1) + t(n-2) + T(n-3)
	  }
	  
	  while(input.hasNextInt())
		  System.out.println(intPartitions[input.nextInt()]);
	  
	  input.close();
	  System.exit(0);
  }
}