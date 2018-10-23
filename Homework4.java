import java.util.Random;
public class Homework4 
{
	public static void main(String[] args)
	{
		Random rand = new Random(); //Declaring random object to get random ints
		int tableSize = 1009; //Size of HashTable
		int initialKeys = 900; //Insert 900 initial keys
		HashTable linearTable = new HashTable(tableSize); //HashTable for linear probing
		HashTable quadraticTable = new HashTable(tableSize); //HashTable for quadratic probing
		HashTable doubleHashTable = new HashTable(tableSize); //HashTable for double hashing
						
		for(int i = 0; i < initialKeys; i++) //insert 900 keys into the 3 hashtables with different
		{									 //Open addressing techniques
			int key = rand.nextInt(5000); //Random integer up to 5000
			String value = String.valueOf(key); //Value = Key
			linearTable.insert(key, value, 1, false); //Insert into linear table
			quadraticTable.insert(key, value, 2, false); //Insert into quadratic table
			doubleHashTable.insert(key, value, 3, false); //Insert into doublehash table
		}
		
		for(int i = 0; i < 50; i++) //Insert the additional 50 keys
		{
			int key = rand.nextInt(5000); //Key = random integer up to 5000
			String value = String.valueOf(key); //Key = Value
			linearTable.insert(key, value, 1, true); //Insert into linear table
			quadraticTable.insert(key, value, 2, true); //Insert into quadratic table
			doubleHashTable.insert(key, value, 3, true); //Insert into doublehash table
		}
		
		System.out.println("Liner probe count: " + linearTable.getLinearProbeCount()); //Output the linear probe counter
		System.out.println("Quadratic probe count: " + quadraticTable.getQuadraticProbeCount()); //Output the quadratic probe counter
		System.out.println("Double hash probe count: " + doubleHashTable.getDoubleHashProbeCount()); //Output the double has probe counter
		
	}	
}

//Class Hashtable
class HashTable
{
	private int currentSize; //Holds the current size of the hashtable
	private int maxSize; //Size of the hashtable
	private String[] keys; //Array to hold keys
	private String[] values; //Array to hold the values
	private int linearProbeCount; //Linear Probe Count
	private int quadraticProbeCount; //Quadratic Probe Count
	private int doubleHashProbeCount; //Double Hash Probe Count

	//Constructor
	public HashTable(int capacity)
	{
		currentSize = 0;
		maxSize = capacity;
		keys = new String[maxSize];
		values = new String[maxSize];
	}
	
	//Gets current size of hashtable
	public int getSize()
	{
		return currentSize;
	}
	
	//Gets the linear probe count
	public int getLinearProbeCount()
	{
		return linearProbeCount;
	}
	
	//Gets the quadratic probe count
	public int getQuadraticProbeCount()
	{
		return quadraticProbeCount;
	}
	
	//Gets the double has probe count
	public int getDoubleHashProbeCount()
	{
		return doubleHashProbeCount;
	}
	
	//Gets the size of the hashtable
	public int getMaxSize()
	{
		return maxSize;
	}
	
	//Checks if hashtable contains a key
	public boolean contains(String key)
	{
		return get(key) != null;
	}
	
	//Gets value from hashtable given a key
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
	
	//linear probe hash method
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
	
	//quadratic probe hash method
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
	
	//Double hash probe hash method
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
	
	//Inserts key-value pair into hashtable
	public void insert(int key, String value, int probeType, boolean count)
	{   
		int i = 0;
		if(probeType == 1) //linear hash
			i = linearHash(key, 0, count);
		else if(probeType == 2)//quadratic hash
			i = quadraticHash(key, 0, 1, 3, count);
		else if(probeType == 3)// double hash
			i = doubleHash(key, 0, count);
		
		if (keys[i] == null) //insert if index is null
		{
			keys[i] = String.valueOf(i); 
			values[i] = value;
			currentSize++;				
		}
			
	}
	
	//Prints hashtable
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


