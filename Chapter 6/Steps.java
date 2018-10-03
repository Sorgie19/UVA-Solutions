import java.util.Scanner;

public class Steps {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        
        for (int i = 0; i < testCases; i++) 
        {
            int a = input.nextInt();
            int b = input.nextInt();
            int steps;
            
            if ((b - a) == 0) 
            	steps = 0;
            else if ((int) Math.sqrt(b - a) * (int) Math.sqrt(b - a) + (int) Math.sqrt(b - a) < (b - a)) 
            	steps = (int) Math.sqrt(b - a) * 2 + 1;
            else if ((int) Math.sqrt(b - a) * (int) Math.sqrt(b - a) == (b - a)) 
            	steps = (int) Math.sqrt(b - a) * 2 - 1;
            else 
                steps = (int) Math.sqrt(b - a) * 2;
            System.out.println(steps);
            
    
        }
        input.close();
        System.exit(0);
    }
}