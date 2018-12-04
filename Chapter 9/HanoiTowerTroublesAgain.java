import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		int[] tower = new int[51];
		tower[0] = -1;
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		for (int i = 1; i <= 50; i += 2)
		{
			int add = i + tower[i - 1] + 1;
			tower[i] = add;
			add = tower[i] + i + 1;
			tower[i + 1] = add;
		}

		while (testCase-- > 0)
		{
			int N = input.nextInt();
			System.out.println(tower[N]);
		}

		input.close();
		System.exit(0);
	}
}