import java.util.Random;
import java.util.*;
public class Homework4 
{
	static int linearProbeCount = 0;
	static int quadraticProbeCount = 0;
	static int doubleHashProbeCount = 0;
	public static void main(String[] args)
	{
		int tableSize = 1009;
		int initialKeys = 900;
		int c1 = 1;
		int c2 = 3;
		String[] linearTable = new String[tableSize];
		String[] quadraticTable = new String[tableSize];
		String[] doubleHashTable = new String[tableSize];
		Random rand = new Random();
		
		for(int i = 0; i < initialKeys; i++)
		{
			int key = rand.nextInt(1000);
			System.out.print(key + " ");
			linearTable[linearProbeInsert(key, tableSize, 0, linearTable, false)] = String.valueOf(key); 
			
			
			
		}
		
		System.out.println("");
		
		
		for(int i = 0; i < tableSize; i++)
		{
			if(linearTable[i] == null)
				System.out.print("null" + " ");
			else
				System.out.print(linearTable[i] + " ");
		}
		
		System.out.println("");
		for(int i = 0; i < tableSize; i++)
		{
			System.out.print(Integer.toString(i) + " ");
		}
		System.out.println("");
		
		for(int i = 0; i < 50; i++);
		{
			int key = rand.nextInt(1000);
			linearTable[linearProbeInsert(key, tableSize, 0, linearTable, true)] = String.valueOf(key); 
		}
		
		System.out.println("Total linear probes: " + linearProbeCount);
		
		
		
	}
	
	public static int linearProbeInsert(int k, int size, int i, String[] table, boolean countProbes)
	{
		if(countProbes) 
		{ 
			linearProbeCount++; 
		}
		if(table[((k + i) % size)] != null)
			return linearProbeInsert(k, size, i + 1, table, countProbes);
		else
			return ((k + i) % size);
			
	}
	
	public int quadraticProbe(int k, int size, int i, String[] table)
	{
		return 0;
	}
	
	public static int doubleHashing(int k, int size, int i, String[] table)
	{
		if(table[(k + (i*(1 + (k % (size - 1)))) % size)] != null)
			return doubleHashing(k, size, i + 1, table);
		else
			return (k + (i*(1 + (k % (size - 1)))) % size);
	}
	
	public void hashInsert(int[] table, int key)
	{
		
	}
	
}

