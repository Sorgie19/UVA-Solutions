import java.util.*;

public class PrimaryArithmetic 
{
	public static void main(String []args)
	{
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine())
		{
			String stInput = input.nextLine();	
			String[] split = stInput.split(" ");
			char[] chA = split[0].toCharArray();
			char[] chB = split[1].toCharArray();
			
			if(chA.length == 1 && chB.length == 1)
				if(chA[0] == '0' && chB[0] == '0')
					break;
			
			chA = reverseArray(chA);
			chB = reverseArray(chB);
			int arraySize = Math.max(chA.length, chB.length);
			
			int[] a = new int[arraySize];
			int[] b = new int[arraySize];
			
			if(a.length > b.length)
			{
				for(int i = 0; i < arraySize; i++)
					b[i] = 0;				
			}
			else
			{
				for(int i = 0; i < arraySize; i++)
					a[i] = 0;
			}
			
			for(int i = 0; i < chA.length; i++)
				a[i] = Integer.parseInt(String.valueOf(chA[i]));
			for(int i = 0; i < chB.length; i++)
				b[i] = Integer.parseInt(String.valueOf(chB[i]));
			
			boolean carry = false;
			int carryCounter = 0;
			if(a[0] + b[0] > 9)
			{
				carryCounter++;
				carry = true;
			}
			for(int i = 1; i < arraySize; i++)
			{	
				if(carry)
					a[i] += 1;
				if((a[i] + b[i]) > 9)
				{
					carryCounter++;
					carry = true;
				}
				else
					carry = false;
			}
			
			if(carryCounter == 0)
				System.out.println("No carry operation.");
			else if(carryCounter == 1)
				System.out.println("1 carry operation.");
			else
				System.out.println(carryCounter + " carry operations.");
		}
		
		input.close();
		System.exit(0);
	}
	
	static char[] reverseArray(char[] array)
	{
		for(int i=0; i<array.length/2; i++)
		{ 
			char temp = array[i]; 
			array[i] = array[array.length -i -1]; 
			array[array.length -i -1] = temp; 
		}
		
		return array;
		
	}
}
