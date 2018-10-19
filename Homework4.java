import java.util.Random;

public class Homework4 
{
	
	public static void main(String[] args)
	{
		Random rand = new Random();	
		int tableSize = 1009;
		int initialKeys = 900;
		HashTable linearTable = new HashTable(tableSize);
		HashTable quadraticTable = new HashTable(tableSize);
		HashTable doubleHashTable = new HashTable(tableSize);
		
		//int[] test = new int[]{10,22,31,4,15,28,17,88,59}; 
		
		for(int i = 0; i < initialKeys; i++)
		{
			//int key = test[i];
			int key = rand.nextInt(5000);
			String value = String.valueOf(key);
			//System.out.println("Test " + key + " " + value);
			linearTable.insert(key, value, 1, false);
			quadraticTable.insert(key, value, 2, false);
			doubleHashTable.insert(key, value, 3, false);
			
		}
		
		//linearTable.printHashTable();
		//System.out.println("");
		//quadraticTable.printHashTable();
		//System.out.println();
		//doubleHashTable.printHashTable();
		for(int i = 0; i < 50; i++)
		{
			int key = rand.nextInt(5000);
			String value = String.valueOf(key);
			//System.out.println("Test " + key + " " + value);
			linearTable.insert(key, value, 1, true);
			quadraticTable.insert(key, value, 2, true);
			doubleHashTable.insert(key, value, 3, true);
		}
		
		System.out.println("Liner probe count: " + linearTable.linearProbeCount);
		System.out.println("Quadratic probe count: " + quadraticTable.quadraticProbeCount);
		System.out.println("Double hash probe count: " + doubleHashTable.doubleHashProbeCount);
	}
	
	
	
}

/** Class HashTable **/
class HashTable
{
	private int currentSize;
	private int maxSize;
	private String[] keys;
	private String[] values; 
	public int linearProbeCount;
	public int quadraticProbeCount;
	public int doubleHashProbeCount;

	/** Constructor **/
	public HashTable(int capacity)
	{
		currentSize = 0;
		maxSize = capacity;
		keys = new String[maxSize];
		values = new String[maxSize];
	}
	
	/** Function to get size of hash table **/
	public int getSize()
	{
		return currentSize;
	}
	
	/** Function to get max size of hash table **/
	public int getMaxSize()
	{
		return maxSize;
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
	
	/** Function to get value for a given key **/
	public String get(String key)
	{
		int i = Integer.parseInt(key);
		while (keys[i] != null)
		{
			if (keys[i].equals(key))
				return values[i];
			i = (i + 1) % maxSize;
		}   
		return null;
	}
	
	public int linearHash(int key, int i, boolean count)
	{
		if(count)
			this.linearProbeCount++;
		int hash = ((key + i) % maxSize);
		if(this.contains(String.valueOf(hash)))
			return linearHash(key, i + 1, count);
		else
			return hash;
	}
	
	public int quadraticHash(int key, int i, int c1, int c2, boolean count)
	{
		if(count)
			this.quadraticProbeCount++;
		int hash = ((key + (c1*i) + (c2*i*i)) % maxSize);
		if(this.contains(String.valueOf(hash)))
			return quadraticHash(key, i + 1, c1, c2, count);
		else
			return hash;
	}
	
	public int doubleHash(int key, int i, boolean count)
	{
		if(count)
			this.doubleHashProbeCount++;
		int hash = ((key + (i*(1 + (key % (maxSize - 1))))) % maxSize);
		if(this.contains(String.valueOf(hash)))
			return doubleHash(key, i + 1, count);
		else
			return hash;
	}
	
	/** Function to insert key-value pair **/
	public void insert(int key, String value, int probeType, boolean count)
	{   
		int i = 0;
		if(probeType == 1)
			i = linearHash(key, 0, count);
		else if(probeType == 2)
			i = quadraticHash(key, 0, 1, 3, count);
		else if(probeType == 3)
			i = doubleHash(key, 0, count);
		
		if (keys[i] == null) //If index is empty
		{
			keys[i] = String.valueOf(i); 
			values[i] = value;
			currentSize++;				
		}
			
	}
	
	/** Function to print HashTable **/
	public void printHashTable()
	{
		System.out.println("\nHash Table: ");
		for (int i = 0; i < maxSize; i++)
		{
			if (keys[i] != null)
				System.out.println(keys[i] +" "+ values[i]);
			if(keys[i] == null)
				System.out.println("null");
		}
		System.out.println();
	}
}


