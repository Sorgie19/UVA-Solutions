import java.math.BigInteger;
import java.util.Scanner;
 
class Main
{
    public static void main(String[] args) throws Exception 
    {
    	Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        input.nextLine();
        for(int t = testCase; t > 0; t--)
        {
            String a = input.nextLine();
            String b = input.nextLine();
            char[] A = a.toCharArray();
            char[] B = b.toCharArray();
            int newA = A.length + 1;
            int newB = B.length + 1;
            BigInteger[][] result = new BigInteger[newA][newB];
            for (int i = 0; i < newA; i++) 
            {
                for (int j = 0; j < newB - 1; j++)
                {
                    result[i][j] = BigInteger.ZERO;
                }
                result[i][b.length()] = BigInteger.ONE;
            }
            for (int i = A.length - 1; i >= 0; i--)
            {
                for (int j = B.length - 1; j >= 0; j--) 
                {
                    result[i][j] = result[i + 1][j];
                    if (A[i] == B[j])
                    {
                        result[i][j] = result[i][j].add(result[i + 1][j + 1]);
                    }
                }
            }
            BigInteger answer = result[0][0];
            System.out.println(answer);
            
        }
        input.close();
        System.exit(0);
    }
}
