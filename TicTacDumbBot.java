/* the dumb bot just guesses moves */
public class TicTacDumbBot implements TicTacToeBot{
    int next_move_xcor, next_move_ycor, team;
    TicTacBoard gameBoard;
    
    /* makes a new ai with access to the gameboard*/
    public TicTacDumbBot(TicTacBoard newboard, int n){
        gameBoard = newboard;
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
        if (!gameBoard.isFilled()){
        getNextMove();
        gameBoard.makeMove(next_move_xcor, next_move_ycor);
        }
    }
    
}
