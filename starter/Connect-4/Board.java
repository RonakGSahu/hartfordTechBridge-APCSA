
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
    /*
     * The constuctor for a board should save the number of rows and cols
     * in the ROWS and COLS variables, and correctly construct a new 2D Piece
     * array with the correct dimensions.
     */
    public Board(int r, int c)
    {
        ROWS = -1;
        COLS = -1;
        pieces = null;
    }
    /*
     * drop(p, col) drops the piece, p, into the column, col, 
     * and returns true if the column is not full
     * otherwise it does not modify the board, and returns false
     */
    public boolean drop(Piece p, int col)
    {
        return false;
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