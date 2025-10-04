import java.util.*;
/**
 * AgeCheckerV1 is a simple class that checks if a user 
 * can legally drive or vote in the U.S.
 * 
 * It can only be used once and has no error handling
 * 
 * @author Eli Shattuck
 * @version 10/3/25
 */
public class AgeCheckerV1 extends AgeChecker
{   
    public AgeCheckerV1(Scanner sc)
    {
        super(sc);
    }
    public void check()
    {
        System.out.println("Enter your age: ");
        int age = sc.nextInt();

        if (age < 16) {
            System.out.println("You are too young to drive or vote!");
        } else if(age < 18) {
            System.out.println("You can drive but not vote!");
        } else {
            System.out.println("You can drive and vote!");
        }
    }
}