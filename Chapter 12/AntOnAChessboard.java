import java.util.Scanner;
class AntOnAChessboard 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLong()) 
        {
        	long x;
        	long y;
            long steps = input.nextLong();
            if (steps == 0)
                return;
            
            if ((steps - (((long)Math.floor(Math.sqrt(steps)) + 1) - 1)*(((long)Math.floor(Math.sqrt(steps)) + 1) - 1)) == 0) 
            {
                x = 1;
                y = ((long)Math.floor(Math.sqrt(steps)) + 1) - 1;
            } else if ((steps - (((long)Math.floor(Math.sqrt(steps)) + 1) - 1)*(((long)Math.floor(Math.sqrt(steps)) + 1) - 1)) <= ((long)Math.floor(Math.sqrt(steps)) + 1)) 
            {
                x = (steps - (((long)Math.floor(Math.sqrt(steps)) + 1) - 1)*(((long)Math.floor(Math.sqrt(steps)) + 1) - 1));
                y = ((long)Math.floor(Math.sqrt(steps)) + 1);
            } else 
            {
                x = ((long)Math.floor(Math.sqrt(steps)) + 1);
                y = 2 * ((long)Math.floor(Math.sqrt(steps)) + 1) - (steps - (((long)Math.floor(Math.sqrt(steps)) + 1) - 1)*(((long)Math.floor(Math.sqrt(steps)) + 1) - 1));
            }

            if (((long)Math.floor(Math.sqrt(steps)) + 1) % 2 == 1) 
            {
                long temp = x;
                x = y;
                y = temp;
            }
            System.out.println(x + " " + y);
            
            
        }
        
        input.close();
        System.exit(0);
    }
}