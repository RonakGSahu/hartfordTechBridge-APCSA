import java.util.*;
/**
 * Checks if a user can drive or vote legally in the U.S.
 *
 * @author Eli Shattuck
 * @version 10/3/25
 */
public abstract class AgeChecker
{
    protected Scanner sc;
    public AgeChecker(Scanner sc) 
    {
        this.sc = sc;
    }
    
    public abstract void check();
}