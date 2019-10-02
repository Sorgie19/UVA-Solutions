import java.util.*;
class Main
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
				
		for(int i = 0; i < testCases; i++)
		{
			int num = input.nextInt();
			String palindrome = recursive(num, 0);
			System.out.println(palindrome);
			
		}
		
		input.close();
		System.exit(0);

	}
	
	static String recursive(long num, int count)
	{
		count++;
		long reversed = reverseInt(num);
		long sum = num + reversed;
		//System.out.println("num = " + num + " | " + "reversed = " + reversed);
		//System.out.println(sum);
		if(isPalindrome(sum))
			return (count + " " + sum);
		else
			return recursive(sum, count);			
	}
	
	
	static long reverseInt(long num) 
	{
	    int reversed = 0;
	    for (int i = (int) num; i !=0; i /= 10) 
	        reversed = reversed * 10 + i % 10;
	    return reversed;        
	}
	
	static boolean isPalindrome(long num)
	{
		char[] numArray = ("" + num).toCharArray();
		int midpoint = numArray.length / 2;
		int startIndex = 0;
		int endIndex = numArray.length - 1;
		
		while(startIndex < midpoint)
		{
			if(numArray[startIndex] != numArray[endIndex])
				return false;
			startIndex++;
			endIndex--;
		}
		return true;
	}

}
