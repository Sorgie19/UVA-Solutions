import java.util.Scanner;
public class Main 
{	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) 
		{
			int n = input.nextInt();
			int s = 10;
			int ones = 1;
			while((s %= 9*n) !=1)
			{
				s = s * 10;
				ones++;			
			}
			System.out.println(ones);			
		}		
		input.close();
		System.exit(0);
	}
}