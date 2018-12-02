
import java.util.*;

public class Flapjacks 
{
	public static void main(String args[]) 
	{
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) 
		{
			ArrayList<Integer> pancakes = new ArrayList<Integer>();
			ArrayList<Integer> flips = new ArrayList<Integer>();
			String stack[] = input.nextLine().split(" ");
			int stackSize = stack.length;			
			for(int i = 0; i < stackSize; ++i) 
			{
				pancakes.add(Integer.parseInt(stack[i]));
			}			
			printStack(pancakes);
			System.out.println(pancakes.get(stackSize-1));
			
			ArrayList<Integer> newStack = (ArrayList<Integer>) pancakes.clone();
			Collections.sort(newStack);			
			flipStack(pancakes, newStack, flips);
			printFlips(flips);
			System.out.println(0);
		}
		
		input.close();
		System.exit(0);
	}
	
	public static void flip(ArrayList<Integer> pancakes, int flipIndex) 
	{
		ArrayList<Integer> stack = (ArrayList<Integer>)pancakes.clone();
		for(int i = 0; i <= flipIndex; ++i) 
		{
			pancakes.set(i, stack.get(flipIndex-i));
		}
	}
	
	public static void printStack(ArrayList<Integer> pancakes)
	{
		for(int i = 0; i < pancakes.size()-1; ++i)
		{
			System.out.print(pancakes.get(i) + " ");
		}
	}
	
	public static void printFlips(ArrayList<Integer> flips)
	{
		for(int i = 0; i < flips.size(); ++i)
		{
			System.out.print(flips.get(i)+ " ");
		}
	}
	
	public static void flipStack(ArrayList<Integer> pancakes, ArrayList<Integer> newStack, ArrayList<Integer> flips)
	{
		for(int n = newStack.size()-1; n > 0; n--) 
		{
			int flipIndex = pancakes.indexOf(newStack.get(n));
			if(flipIndex != 0) 
			{
				flip(pancakes, flipIndex);
				flips.add(pancakes.size() - flipIndex);
			}
			flip(pancakes, n);
			flips.add(pancakes.size() - n);
		}
	}
}