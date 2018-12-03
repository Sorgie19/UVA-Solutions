import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		while(n != 0)
		{	
			if(Math.pow((long)Math.sqrt(n), 2) == n)
				System.out.println("yes");
			else
				System.out.println("no");
			n = input.nextLong();
		}		
		input.close();
		System.exit(0);
	}
}