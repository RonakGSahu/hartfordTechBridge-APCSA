import java.util.Scanner;
/**
 * Write a description of class HumanPlayer here.
 *
 * @author Eli Shattuck
 * @version 10/28/25
 */
public class HumanPlayer extends Player
{
    private Scanner input;
    public HumanPlayer(String n, char s)
    {
        super(n, new Piece(s));
        input = new Scanner(System.in);
        
        System.out.println(n + " enter your name: ");
        String pName = input.nextLine();
        
        name = pName;
    }
    public void makeMove(Board b)
    {
        boolean valid = false;
        while(!valid)
        {
            System.out.println(name + "(" + piece.getSymbol() + ") choose a column");
            int move = input.nextInt();
            if(move >= 0 && move < b.COLS)
            {
                valid = b.drop(piece, move);
            }
            else
            {
                System.out.println("Invalid move: " + move);
            }
        }
    }
}