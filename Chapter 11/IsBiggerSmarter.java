import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{	
	public static void main(String[] args)  throws IOException 
	{
		int max = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));		
		ArrayList<Elephant> elephants = addElephants(input);		
		Elephant[] elephantArray = elephants.toArray(new Elephant[elephants.size()]);
		Arrays.sort(elephantArray);		
		int[] array = new int [elephantArray.length];
		array[0] = 1;
		for (int i = 1; i < array.length; i++) 
		{
			array[i] = max(array[i], 1);
			for (int k = 0; k < i; k++) 
			{
				if (elephantArray[i].getIq() < elephantArray[k].getIq() && elephantArray[i].getWeight() > elephantArray[k].getWeight()) 
				{
					array[i]= max(array[i], array[k] + 1);
				}
			}
		}		
		
		for (int i = 0; i < array.length; i++) 
		{
			max = max(array[i], max);
		}
		
		System.out.println(max);
		boolean bool = true;
		int last = 0;
		int[] elephantFinal = new int[max];
		
		for (int i = array.length - 1; i >= 0 && max > 0; i--) 
		{
			if (array[i] == max && (bool || last < elephantArray[i].getIq())) 
			{
				last = elephantArray[i].getIq();
				elephantFinal[--max] = elephantArray[i].getId();
				bool = false;
			}
		}
		
		for (int i = 0; i < elephantFinal.length; i++) 
		{
			System.out.println(elephantFinal[i]);
		}
	}
	
	public static int max(int a, int b)
	{
		if(a > b)
			return a;
		else
			return b;
	}
	
	public static ArrayList<Elephant> addElephants(BufferedReader input) throws IOException
	{
		int id = 1;		
		String userInput;
		
		ArrayList<Elephant> elephants = new ArrayList<>();
		while(true) 
		{
			Elephant e = new Elephant();
			e.setId(id++);
			userInput = input.readLine();
			if (userInput == null || userInput.equals("")) 
			{
				break;
			}
			StringTokenizer tokenizer = new StringTokenizer(userInput);			
			e.setWeight(Integer.parseInt(tokenizer.nextToken()));
			e.setIq(Integer.parseInt(tokenizer.nextToken()));			
			elephants.add(e);
		}
		return elephants;
	}
}

class Elephant implements Comparable<Elephant> 
{
	private int weight;
	private int iq;
	private int id;
	
	public int compareTo(Elephant e) 
	{
		return this.weight - e.weight;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public int getIq()
	{
		return this.iq;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setIq(int iq)
	{
		this.iq = iq;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}	
}
