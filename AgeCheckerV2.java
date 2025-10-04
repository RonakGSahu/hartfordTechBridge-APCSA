import java.util.*;
/**
 * AgeCheckerV2 is a simple class that checks if multiple users 
 * can legally drive or vote in the U.S.
 * 
 * It can check multiple users but still has no error handling
 * 
 * @author Eli Shattuck
 * @version 10/3/25
 */
public class AgeCheckerV2 extends AgeChecker
{   
    public AgeCheckerV2(Scanner sc)
    {
        super(sc);
    }
    public void check()
    {
        String response = "yes";
        
        while(response.equalsIgnoreCase("yes"))
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
            System.out.println("Go again (yes/no)? ");
            response = sc.next();
        }
    }
}