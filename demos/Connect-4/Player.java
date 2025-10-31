
/**
 * A class to hold information about a connect-4 player
 *
 * @author Eli Shattuck
 * @version 10/28/25
 */
public abstract class Player
{
    protected Piece piece;
    protected String name;
    public Player(String n, Piece p)
    {
        piece = p;
        name = n;
        piece.setOwner(this);
    }
    public Piece getPiece() { return piece; }
    public String getName() { return name; }
    public abstract void makeMove(Board b);
}