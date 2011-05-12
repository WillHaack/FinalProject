/* the dumb bot just guesses moves */
public class DumbBot implements TicTacToeBot{
    int next_move_xcor, next_move_ycor, team;
    Board gameBoard;
    GameBoard displayBoard;
    
    /* makes a new ai with access to the gameboard*/
    public DumbBot(Board newboard, int n, GameBoard display){
        gameBoard = newboard;
        displayBoard = display;
        team = n;
    }
    
    /* continues to guess a move until it gets a valid spot*/
    public void getNextMove(){
        next_move_xcor = (int)(Math.random() * 3);
        next_move_ycor = (int) (Math.random() * 3);
        while (!gameBoard.canMove(next_move_xcor, next_move_ycor)){
            next_move_xcor = (int)(Math.random() * 3);
            next_move_ycor = (int) (Math.random() * 3);
        }
    }
    /* calls getNextMove then makes the move*/
    public void makeNextMove(){
        getNextMove();
        gameBoard.makeMove(next_move_xcor, next_move_ycor);
        displayBoard.display();
    }
    
    
}
