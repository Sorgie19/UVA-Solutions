import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for(int i = 0; i < n; i++) 
		{
			int m = input.nextInt();
			input.nextLine();
			ArrayList<String> originalOrder = new ArrayList<String>();
			ArrayList<String> finalOrder = new ArrayList<String>();
			
			for(int j = 0; j < m; j++) 
			{
				String name = input.nextLine();
				originalOrder.add(name);
			}
			for(int j = 0; j < m; j++) 
			{
				String name = input.nextLine();
				finalOrder.add(name);
			}
			
			ArrayList<String> shellSort = new ArrayList<String>();
			for(int k = finalOrder.size() - 1; k > 0; k--) 
			{
				int bigI = originalOrder.indexOf(finalOrder.get(k));
				int biggerI = originalOrder.indexOf(finalOrder.get(k-1));
				
				if(biggerI > bigI) 
				{
					shellSort.add(originalOrder.get(biggerI));
					originalOrder.add(0, originalOrder.remove(biggerI));
				}
			}
			
			for(int b = 0; b < shellSort.size(); b++)
			{
				System.out.println(shellSort.get(b));
			}
			System.out.println();
		}
	}
}