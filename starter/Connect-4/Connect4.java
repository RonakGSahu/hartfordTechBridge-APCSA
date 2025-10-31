
/**
 * A main class to run the connect-4 game.
 *
 * @author Eli Shattuck
 * @version 10/28/25
 */
public class Connect4
{
    public static void main(String[] args)
    {
        Board board = new Board(6, 7);
        
        Player[] players = new Player[] { 
            new HumanPlayer("Player 1", 'x'), 
            new RandomPlayer('o')
        };
        
        int turn = 0;
        boolean gameOver = false;
        while(!gameOver)
        {
            board.display();
            
            players[turn].makeMove(board);
            
            turn++;
            if(turn >= players.length) 
            {
                turn = 0;
            }
            
            Player winner = board.getWinner();
            if(winner != null)
            {
                gameOver = true;
                board.display();
                System.out.println("Congratulations, " + winner.getName() + " you win!");
            }
        }
    }
}