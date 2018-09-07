import java.util.Scanner;
class Main
{
	static int getCycleCount(int n)
	{
		int count = 1;
		while(n != 1)
		{
			if (n % 2 == 0)
			{
				n = n/2;
				//System.out.println(n);
			}
			else
			{
				n = (3*n) + 1;
				//System.out.println(n);
			}
			count ++;					
		}
		return count;		
	}
	
	static int getMaxCount(int i, int j)
	{
		
		if (i > j)//This is to order them numerically 
		{
			int z;
			z = i;
			i = j;
			j = z;
		}
		int max = 0;
		for (int n = j; n >= i; n--)
		{
			if(getCycleCount(n) > max)
			{
				max = getCycleCount(n);
			}			
		}
		return max;		
	}

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		while(reader.hasNextInt())
		{
			int i = reader.nextInt();
			int j = reader.nextInt();
			System.out.println(i + " " + j + " " + getMaxCount(i, j));
		}
		reader.close();
		System.exit(0);
	}

}
