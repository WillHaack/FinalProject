
public class SmartBot implements TicTacToeBot {
    int next_move_xcor, next_move_ycor, team;
    Board gameBoard;
    
    /* makes a new ai with access to the gameboard*/
    public SmartBot(Board newboard, int n){
        gameBoard = newboard;
        team = n;
    }
        
    public void getNextMove(){};
    public void makeNextMove(){};
}
