import java.util.*;
import java.util.HashMap;
public class WERTYU 
{
	public static void main(String args[])
	{
		HashMap<Character, Character> map = mapKeys();
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine())
		{
			String message = input.nextLine();
			char[] array = new char[message.length()];
			
			for(int i = 0; i < message.length(); i++)
				array[i] = message.charAt(i);
			
			for(int i = 0; i < message.length(); i++)
				if(map.containsKey(array[i]))
					array[i] = map.get(array[i]);
			
			String newMessage = new String(array);
			System.out.println(newMessage);			
		}
		
		input.close();
		System.exit(0);
	}
	
	static HashMap<Character, Character> mapKeys()
	{
		HashMap<Character, Character> map = new HashMap<>();
		map.put('B' , 'V');
		map.put('C' , 'X');
		map.put('D' , 'S');
		map.put('E' , 'W');
		map.put('F' , 'D');
		map.put('G' , 'F');
		map.put('H' , 'G');
		map.put('I' , 'U');
		map.put('J' , 'H');
		map.put('K' , 'J');
		map.put('L' , 'K');
		map.put('M' , 'N');
		map.put('N' , 'B');
		map.put('O' , 'I');
		map.put('P' , 'O');
		map.put('R' , 'E');
		map.put('S' , 'A');
		map.put('T' , 'R');
		map.put('U' , 'Y');
		map.put('V' , 'C');
		map.put('W' , 'Q');
		map.put('X' , 'Z');
		map.put('Y' , 'T');
		map.put('[' , 'P');
		map.put(']' , '[');
		map.put('\\' , ']');
		map.put(',' , 'M');
		map.put('.' , ',');
		map.put(';' , 'L');
		map.put('=' , '-');
		map.put('-' , '0');
		map.put('0' , '9');
		map.put('9' , '8');
		map.put('8' , '7');
		map.put('7' , '6');
		map.put('6' , '5');
		map.put('5' , '4');
		map.put('4' , '3');
		map.put('3' , '2');
		map.put('2' , '1');
		map.put('1' , '`');
		map.put(' ' , ' ');
		map.put('/' , '.');
		map.put('\'', ';');
		
		return map;
	}
}
