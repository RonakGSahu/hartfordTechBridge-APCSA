import java.util.*;
/**
 * A program that checks if a user can legally drive or vote in the US.
 *
 * @author Eli Shattuck
 * @version 10/3/25
 */
public class MainV2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        AgeCheckerV2 checker = new AgeCheckerV2(sc);
        
        checker.check();
        
        sc.close();
    }
}