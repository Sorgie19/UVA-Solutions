import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) 
		{
			long x = 0, y = 1, x2 = 1, y2 = 0;
			long A = input.nextInt(), B = input.nextInt();
	    	while (B != 0) 
			{
				long q = A/B, t = B, x3 = x2 - q * x, y3 = y2 - q * y;
				B = A%B; 
				A = t;//Temp			
				x2 = x;
				x = x3;     
				y2 = y;
				y = y3;     
			}
			System.out.println(x2 + " " + y2 + " "  + A);
		}
		input.close();
		System.exit(0);
  	} 
}