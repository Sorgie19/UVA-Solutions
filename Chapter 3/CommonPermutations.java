import java.util.*;
import java.util.stream.Collectors;
public class CommonPermutations 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine())
		{
			String stringA = input.nextLine();
			String stringB = input.nextLine();
			
			char[] a = stringA.toCharArray();
			char[] b = stringB.toCharArray();
			ArrayList<Character> p = new ArrayList<Character>();
			for(int i = 0; i < a.length; i++)
			{
				for(int k = 0; k < b.length; k++)
				{
					if(a[i] == b[k])
					{
						p.add(a[i]);
						b[k] = '0';
						break;
					}
				}
			}
			
			Collections.sort(p);
			String output = p.stream().map(Object::toString).collect(Collectors.joining(""));
			System.out.println(output);	
		}
		
		input.close();
		System.exit(0);
	}

}
