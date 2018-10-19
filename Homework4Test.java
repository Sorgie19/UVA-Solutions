import java.util.Random;
public class Homework4Test 
{	
	
	public static void main(String[] args)
	{
		Random rand = new Random();
		HashTable linear = new HashTable(1009);
		HashTable quadratic = new HashTable(1009);
		HashTable doubleHash = new HashTable(1009);
		int initialKeys = 900;
		for(int i = 0; i < initialKeys; i++)
		{
			int key = rand.nextInt(1000);
			String value = Integer.toString(key);
			linear.insert(key, val);
		}
		
		
	}
	
	
	
	
}

/** Class HashTable **/
class HashTable
{
	private int currentSize;
	private int maxSize;
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