import java.util.Arrays;
import java.util.Scanner;
public class PokerHand
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		while(input.hasNextLine())
		{
			String[] bothHands = userInput.split(" ");
			String[] blackHand = new String[5];
			String[] whiteHand = new String[5];
			
			for(int i = 0; i < 5; i++)
				blackHand[i] = bothHands[i];
			for(int i = 5; i < 10; i++)
				whiteHand[i-5] = bothHands[i];
			
			
			//Breakdown face cards into values		
			int[] blackValue = getCardValues(blackHand);
			String[] blackSuit = getSuit(blackHand);
			int[] whiteValue = getCardValues(whiteHand);
			String[] whiteSuit = getSuit(whiteHand);
			Arrays.sort(blackValue);
			Arrays.sort(whiteValue);
			
			int blackRank = evaluateHand(blackValue, blackSuit); //1 best 9 is worst
			int whiteRank = evaluateHand(whiteValue, whiteSuit);
			
			//System.out.println("Black Rank: " + blackRank);
			//System.out.println("White Rank: " + whiteRank);
			
			if(blackRank > whiteRank)
				System.out.println("White wins.");
			else if(whiteRank > blackRank)
				System.out.println("Black wins.");
			else
			{
				System.out.println(handDeterminer(blackRank, blackValue, whiteValue));
			}
			
			
			
			
			
			
			
			
			userInput = input.nextLine();
			
		}
	}
	
	static int[] getCardValues(String[] hand)
	{
		int[] cardValue = new int[5];
		String[] stringValue = new String[5];
		for(int i = 0; i < 5; i++)
		{
			stringValue[i] = Character.toString(hand[i].charAt(0));
			//System.out.println(stringValue[i]);
		}
		
		for(int i = 0; i < 5; i++)
		{
			if(stringValue[i].equals("K"))
				stringValue[i] = "13";
			else if(stringValue[i].equals("Q"))
				stringValue[i] = "12";
			else if(stringValue[i].equals("J"))
				stringValue[i] = "11";
			else if(stringValue[i].equals("A"))
				stringValue[i] = "14";
			else if(stringValue[i].equals("T"))
				stringValue[i] = "10";
		}
		for(int i = 0; i < 5; i++)
			cardValue[i] = Integer.parseInt(stringValue[i]); 
		return cardValue;
	}
	
	static String[] getSuit(String[] hand)
	{
		String[] stringValue = new String[5];
		for(int i = 0; i < 5; i++)
			stringValue[i] = Character.toString(hand[i].charAt(1));
		return stringValue;		
	}
	
	static int highCard(int[] hand)
	{
		Arrays.sort(hand); //Sorts
		return hand[4];
	}
	
	static int evaluateHand(int[] value, String[] suit)
	{
		Arrays.sort(value);
		int valueCount = 1; 
		int suitCount = 1;
		
		//Royal Flush
		for(int i = 1; i < 5; i++)
		{
			if(value[i-1] == value[i] - 1)
				valueCount++;
			if(suit[0].equals(suit[i]))
				suitCount++;
		}
		if(valueCount == 5 && suitCount == 5)
			return 1; // 1 = Royal Flush
		else if(valueCount == 5 && suitCount != 5)
			return 5; // 5 = Straight
		else if(suitCount == 5 && valueCount != 5)
			return 4; // 4 = Flush
		else
		{
			valueCount = 1;
			suitCount = 1;
		}
		
		//Pairs
		int count = 0;
		for(int i = 0; i < 5; i++)
			for(int k = 0; k < 5; k++)
				if((value[i] == value[k]) && (i != k))
					count++;
		//System.out.println(count);
		if(count == 2)
			return 8; //8 = A Pair
		else if(count == 4)
			return 7; //7 = 2 Pair
		else if(count == 6)
			return 6; //6 = 3 of a Kind
		else if(count == 8)
			return 3; //3 = Full House
		else if(count == 12)
			return 2; //2 = 4 of a Kind
		
		return 9;
	}
	
	static String getHigh(int[] blackHand, int[] whiteHand)
    {
	    for(int i = 4; i >= 0; i--)
	    {
	        if(blackHand[i] > whiteHand[i])
	            return "Black wins.";
	        else if(whiteHand[i] > blackHand[i])
	            return "White wins.";
	    }
	    
	    return "Tie";
    }
	
	static String handDeterminer(int rank, int[] blackHand, int[] whiteHand)
	{
	    String black = "Black wins.";
	    String white = "White wins.";
	    String tie = "Tie.";    
	    
	    
	    if(rank == 9) //High Card
	        return getHigh(blackHand, whiteHand);
	    
	    else if(rank == 8)//A Pair
	    {
	       int blackPair = mostFrequent(blackHand, false);
	       int whitePair = mostFrequent(whiteHand, false);
	       if(blackPair > whitePair)
	    	   return black;
	       else if(whitePair > blackPair)
	    	   return white;
	       else
	       {
		       for(int i= 0; i < 5; i++)
		       {
		            if(blackHand[i] == blackPair)
		                blackHand[i] = 0;
		            if(whiteHand[i] == whitePair)
		                whiteHand[i] = 0;
		       }
		       Arrays.sort(blackHand);
		       Arrays.sort(whiteHand);
		            
		       return getHigh(blackHand, whiteHand);
	       }
	    }
	    
	    else if(rank == 7) //Two Pairs
	    {
	    	int[] bPairs = new int[3];
	    	int[] wPairs = new int[3];
	    	
	    	int bIndex = 0;
	    	int wIndex = 0;
	    	for(int i = 3; i >= 0; i--)
	    	{
	    		if(blackHand[i] == blackHand[i+1])
	    		{
	    			bPairs[bIndex] = blackHand[i];
	    			blackHand[i] = 0;
	    			blackHand[i+1] = 0;
	    			bIndex++;
	    		}
	    		if(whiteHand[i] == whiteHand[i+1])
	    		{
	    			wPairs[wIndex] = whiteHand[i];
	    			whiteHand[i] = 0;
	    			whiteHand[i+1] = 0;
	    			wIndex++;
	    		}	    		
	    	}
	    	
	    	Arrays.sort(blackHand);
    		Arrays.sort(whiteHand);
    		bPairs[2] = blackHand[4];
    		wPairs[2] = whiteHand[4];
    		
    		for(int i = 0; i < 3; i++)
    		{
    			if(bPairs[i] > wPairs[i])
    				return black;
    			else if(wPairs[i] > bPairs[i])
    				return white;
    		}
	    
		    return tie;		    
	    }
	    
	    
	    
	    
	    return "";
			
	}
	
	static int mostFrequent(int value[], boolean secondPair)
    {
         
        // Sort the array
        Arrays.sort(value);
         
        // find the max frequency using linear
        // traversal
        int max_count = 1, res = value[0];
        int curr_count = 1;
         
        for (int i = 1; i < value.length; i++)
        {
            if (value[i] == value[i - 1])
                curr_count++;
            else
            {
            	if(secondPair == false)
            	{
	                if (curr_count >= max_count)
	                {
	                    max_count = curr_count;
	                    res = value[i - 1];
	                }
	                curr_count = 1;
            	}
            	else
            	{
            		if (curr_count > max_count)
	                {
	                    max_count = curr_count;
	                    res = value[i - 1];
	                }
	                curr_count = 1;
            	}
            }
        }
     
        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = value[value.length - 1];
        }
     
        return res;
    }
	
	
	static int[] findPairs(int[] value, boolean secondHand)
	{
		int index = 0;
		int[] pairs = new int[2];
		for (int i = 0; i < value.length-1; i++)
        {
            for (int j = i+1; j < value.length; j++)
            {
                if ((value[i] == value[j]) && (i != j))
                {
                    //System.out.println("Duplicate Element : "+ value[j]);
                    pairs[index++] = value[j];
                }
            }
        }
		Arrays.sort(pairs);
		return pairs;
		
	}
}