
/**
 * A class to store a connect4 Piece
 *
 * @author Eli Shattuck
 * @version 10/28/25
 */
public class Piece
{
    private char symbol;
    private Player owner;
    public Piece(char s)
    {
        symbol = s;
    }
    public void setOwner(Player o) { owner = o; }
    public Player getOwner() { return owner; }
    public char getSymbol()
    {
        return symbol;
    }
    public void setSymbol(char s)
    {
        symbol = s;
    }
    public boolean equals(Object other)
    {
        if(!(other instanceof Piece)) return false;
        return owner == ((Piece)other).owner;
    }
}