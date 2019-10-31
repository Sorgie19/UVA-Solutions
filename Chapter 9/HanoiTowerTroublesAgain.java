import java.util.*;
class Main
{
	public static void main(String[] args) 
	{
		int[] tower = new int[51];
		tower[0] = -1;
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		//Generates all the the solutions for up to 50 pegs
		//http://www.questtosolve.com/search.php (search for 10276)
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
