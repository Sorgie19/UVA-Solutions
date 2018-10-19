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
	
	/** Class HashTable **/
	class HashTable
	{
		private int currentSize, maxSize;
		private String[] keys;
		private String[] vals;   
	
		/** Constructor **/
		public HashTable(int capacity)
		{
			currentSize = 0;
			maxSize = capacity;
			keys = new String[maxSize];
			vals = new String[maxSize];
		}  
	
		/** Function to clear hash table **/
		public void makeEmpty()
		{
			currentSize = 0;
			keys = new String[maxSize];
			vals = new String[maxSize];
		}
	
		/** Function to get size of hash table **/
		public int getSize()
		{
			return currentSize;
		}
	
		/** Function to check if hash table is full **/
		public boolean isFull()
		{
			return currentSize == maxSize;
		}
	
		/** Function to check if hash table is empty **/
		public boolean isEmpty()
		{
			return getSize() == 0;
		}
	
		/** Function to check if hash table contains a key **/
		public boolean contains(String key)
		{
			return get(key) != null;
		}
	
		/** Function to get hash code of a given key **/
		private int hash(String key)
		{
			return key.hashCode() % maxSize;
		}   
	
		/** Function to insert key-value pair **/
		public void insert(String key, String val)
		{   
			int tmp = hash(key);
			int i = tmp;
			do
			{
				if (keys[i] == null)
				{
					keys[i] = key;
					vals[i] = val;
					currentSize++;
					return;
				}
				if (keys[i].equals(key))
				{
					vals[i] = val;
					return;
				}   
				i = (i + 1) % maxSize;   
			} while (i != tmp);
		}
	
		/** Function to get value for a given key **/
		public String get(String key)
		{
			int i = hash(key);
			while (keys[i] != null)
			{
				if (keys[i].equals(key))
					return vals[i];
				i = (i + 1) % maxSize;
			}   
			return null;
		}
	
		/** Function to remove key and its value **/
		public void remove(String key)
		{
			if (!contains(key))
				return;
	
			/** find position key and delete **/
			int i = hash(key);
			while (!key.equals(keys[i]))
				i = (i + 1) % maxSize;   
			keys[i] = vals[i] = null;
	
			/** rehash all keys **/   
			for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize)
			{
				String tmp1 = keys[i], tmp2 = vals[i];
				keys[i] = vals[i] = null;
				currentSize--;  
				insert(tmp1, tmp2);   
			}
			currentSize--;   
		}
	
		/** Function to print HashTable **/
		public void printHashTable()
		{
			System.out.println("\nHash Table: ");
			for (int i = 0; i < maxSize; i++)
				if (keys[i] != null)
					System.out.println(keys[i] +" "+ vals[i]);
			System.out.println();
		}
	}
	
	
}

