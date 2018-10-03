import java.util.*;
class Main //Does not work
{
	public static void main(String []args)
	{
		Scanner input = new Scanner(System.in);
		int numOfSolutions = input.nextInt();
		int caseCounter = 1;
		while(numOfSolutions > 0)
		{
			input.nextLine();
			String[] solutions = new String[numOfSolutions];
			for(int i = 0; i < numOfSolutions; i++)
				solutions[i] = input.nextLine();
						
			int numOfAnswers = input.nextInt();
			input.nextLine();
			String[] answers = new String[numOfAnswers];
			for(int i = 0; i < numOfAnswers; i++)
				answers[i] = input.nextLine();
			
			//if(numOfSolutions != numOfAnswers)
				//System.out.println("Run #" + caseCounter + ": Wrong answer");					
			if(accepted(solutions, answers))
				System.out.println("Run #" + caseCounter + ": Accepted");
			else if(presentationError(solutions, answers))
				System.out.println("Run #" + caseCounter + ": Presentation Error");
			else
				System.out.println("Run #" + caseCounter + ": Wrong Answer");
			
			caseCounter++;	
			numOfSolutions = input.nextInt();
		}
		
		
		
	}
	
	static boolean accepted(String[] solution, String[] answer)
	{
		return Arrays.equals(solution, answer);
	}
	
	static boolean presentationError(String[] solution, String[] answer)
	{
		for(int i = 0; i < solution.length; i++)
		{
			solution[i] = solution[i].replaceAll("[^-?0-9]+", "");
			System.out.println(solution[i]);
			
		}
		for(int i = 0; i < answer.length; i++)
		{
			answer[i] = answer[i].replaceAll("[^-?0-9]+", "");
			System.out.println(answer[i]);
		}
		
		int[] test = new int[solution.length];
		for(int i = 0; i < solution.length; i++)
		{
			test[i] = Integer.parseInt(solution[i]);
		}
		
		int[] test2 = new int[answer.length];
		for(int i = 0; i < answer.length; i++)
		{
			test2[i] = Integer.parseInt(answer[i]);
		}
		
		return Arrays.equals(test, test2);
		
		//return Arrays.equals(solution,  answer);
		
	}
}
