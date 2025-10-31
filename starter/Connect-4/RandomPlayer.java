import java.util.Random;
/**
 * A connect-4 player that plays randomly
 *
 * @author Eli Shattuck
 * @version 10/28/25
 */
public class RandomPlayer extends Player
{
    protected Random rng;
    public RandomPlayer(char piece)
    {
        super("Random Player", new Piece(piece));
        rng = new Random();
    }
    public void makeMove(Board b)
    {
        int randCol = rng.nextInt(0, b.COLS);
        while(!b.drop(piece, randCol)) { randCol = rng.nextInt(0, b.COLS); }
        System.out.println(name + " plays in column: " + randCol);
    }
}