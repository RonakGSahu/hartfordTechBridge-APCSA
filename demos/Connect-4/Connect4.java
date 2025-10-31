
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
        Board b = new Board(6, 7);
        
        Player[] players = new Player[] { 
            new HumanPlayer("Player 1", 'x'), 
            new RandomPlayer('o')
        };
        
        int turn = 0;
        boolean gameOver = false;
        while(!gameOver)
        {
            b.display();
            players[turn].makeMove(b);
            turn++;
            if(turn >= players.length) 
            {
                turn = 0;
            }
            Player winner = b.getWinner();
            if(winner != null)
            {
                gameOver = true;
                b.display();
                System.out.println("Congratulations, " + winner.getName() + " you win!");
            }
        }
    }
}