
/**
 * A class to maintain a connect 4 board
 *
 * @author Eli Shattuck
 * @version 10/28/25
 */
public class Board
{
    public final int ROWS;
    public final int COLS;
    private Piece[][] pieces;
    public Board(int r, int c)
    {
        ROWS = r;
        COLS = c;
        pieces = new Piece[ROWS][COLS];
    }
    /*
     * drop(p, col) drops the piece, p, into the column, col, 
     * and returns true if the column is not full
     * otherwise it does not modify the board, and returns false
     */
    public boolean drop(Piece p, int col)
    {
        int row = ROWS-1;
        while(row >= 0 && pieces[row][col] != null) 
        {
            row--;
        }
        if(row >= 0)
        {
            pieces[row][col] = p;
            return true;
        }
        else
        {
            return false;
        }
    }
    /*
     * getWinner, checks if there is a 4-in-a-row in the current board state
     * If there is it returns the Player who won.
     *      Note: each piece has a method piece.getOwner() that returns 
     *      the player associated with that piece
     *      
     * If there is no winner, return null;
     */
    public Player getWinner()
    {
        // Check horizontal
        for(int r = 0; r < ROWS; r++)
        {
            for(int c = 0; c <= COLS - 4; c++)
            {
                if(pieces[r][c] != null &&
                   pieces[r][c].equals(pieces[r][c+1]) &&
                   pieces[r][c].equals(pieces[r][c+2]) &&
                   pieces[r][c].equals(pieces[r][c+3]))
                {
                    return pieces[r][c].getOwner();
                }
            }
        }
        // Check vertical
        for(int r = 0; r <= ROWS - 4; r++)
        {
            for(int c = 0; c < COLS; c++)
            {
                if(pieces[r][c] != null &&
                   pieces[r][c].equals(pieces[r+1][c]) &&
                   pieces[r][c].equals(pieces[r+2][c]) &&
                   pieces[r][c].equals(pieces[r+3][c]))
                {
                    return pieces[r][c].getOwner();
                }
            }
        }
        // Check diagonal (down-right)
        for(int r = 0; r <= ROWS - 4; r++)
        {
            for(int c = 0; c <= COLS - 4; c++)
            {
                if(pieces[r][c] != null &&
                   pieces[r][c].equals(pieces[r+1][c+1]) &&
                   pieces[r][c].equals(pieces[r+2][c+2]) &&
                   pieces[r][c].equals(pieces[r+3][c+3]))
                {
                    return pieces[r][c].getOwner();
                }
            }
        }
        // Check diagonal (down-left)
        for(int r = 0; r <= ROWS - 4; r++)
        {
            for(int c = 3; c < COLS; c++)
            {
                if(pieces[r][c] != null &&
                   pieces[r][c].equals(pieces[r+1][c-1]) &&
                   pieces[r][c].equals(pieces[r+2][c-2]) &&
                   pieces[r][c].equals(pieces[r+3][c-3]))
                {
                    return pieces[r][c].getOwner();
                }
            }
        }
        return null;
    }
    public void display()
    {
        for(int c = 0; c < COLS; c++) System.out.print("(" + c + ")");
        System.out.println();
        for(int r = 0; r < ROWS; r++)
        {
            for(int c = 0; c < COLS; c++)
            {
                Piece currentPiece = pieces[r][c];
                char symbol = ' ';
                if(currentPiece != null)
                {
                    symbol = currentPiece.getSymbol();
                }
                System.out.print("[" + symbol  + "]");
            }
            System.out.println();
        }
    }
}