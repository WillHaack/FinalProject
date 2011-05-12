/* the genius bot always wins or ties */
public class GeniusBot implements TicTacToeBot{
    int next_move_xcor, next_move_ycor, team;
    Board infoBoard;
    
    /* makes a new ai with access to the gameboard*/
    public GeniusBot(Board newboard, int n){
        infoBoard = newboard;
        team = n;
    }
    
    /*gets best possible move*/
    public void getNextMove(){
        int[][] potential_moves = new int[3][3]; //the value of each move is stored in the int array.
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                potential_moves[r][c] = evaluate(r, c);
            }
        }
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                if (potential_moves[next_move_xcor][next_move_ycor] < potential_moves[r][c]){
                    next_move_xcor = r;
                    next_move_ycor = c;
                }
            }
        }
    }
    
    public int evaluate(int x, int y){
        int ans = 0;
        if (!infoBoard.canMove(x, y))
            return -100;
        if (isWinner(x, y))
            ans += 500;
        if (isBlocker(x, y))
            ans += 250;
        if (isCenter(x, y))
            ans += 100;
        if (isCorner(x, y))
            ans += 25;
        return ans + (int)(Math.random() * 10);
    }
    
    private boolean isCenter(int x,int y){
        return x == 1 && y == 1;
    }
    
    private boolean isCorner(int x, int y){
        boolean ans = false;
        if (x == 0 && (y == 0 || y == 2))
            ans = true;
        if (x == 2 && (y == 0 || y == 2))
            ans = true;
        return ans;
    }
    
    private boolean isWinner(int x,int y){
        int[][] tempinfoBoard = infoBoard.getIntArray();
        tempinfoBoard[x][y] = team;
        return diagonalWinner(tempinfoBoard) ||
               row1Winner(tempinfoBoard) || row2Winner(tempinfoBoard) || row3Winner(tempinfoBoard) || 
                vert1Winner(tempinfoBoard) || vert2Winner(tempinfoBoard) || vert3Winner(tempinfoBoard);
    }
    
    private boolean isBlocker(int x, int y) {
        int newteam = 1;
        if (team == 1) 
            newteam = 2;
        int[][] tempinfoBoard = infoBoard.getIntArray();
        tempinfoBoard[x][y] = newteam;
        return diagonalWinner(tempinfoBoard)
                || row1Winner(tempinfoBoard) || row2Winner(tempinfoBoard) || row3Winner(tempinfoBoard)
                || vert1Winner(tempinfoBoard) || vert2Winner(tempinfoBoard) || vert3Winner(tempinfoBoard);
    }
    
    private boolean diagonalWinner(int[][] tempinfoBoard){
        return ((tempinfoBoard[0][0] == tempinfoBoard[1][1] && tempinfoBoard[1][1] == tempinfoBoard[2][2]) || 
                (tempinfoBoard[2][0] == tempinfoBoard[1][1] && tempinfoBoard[1][1] == tempinfoBoard[0][2])) &&
                tempinfoBoard[1][1] != 0;
    }
    /*@return true if winner on row1*/
    private boolean row1Winner(int[][] tempinfoBoard){
        return tempinfoBoard[0][0] == tempinfoBoard[0][1] && tempinfoBoard[0][1] == tempinfoBoard[0][2] && tempinfoBoard[0][1] != 0;
    }
    
    /*@return true if winner on row2*/
    private boolean row2Winner(int[][] tempinfoBoard){
        return tempinfoBoard[1][0] == tempinfoBoard[1][1] && tempinfoBoard[1][1] == tempinfoBoard[1][2] && tempinfoBoard[1][1] != 0;
    }
    /*@return true if winner on row3*/
    private boolean row3Winner(int[][] tempinfoBoard){
        return tempinfoBoard[2][0] == tempinfoBoard[2][1] && tempinfoBoard[2][1] == tempinfoBoard[2][2] && tempinfoBoard[2][1] != 0;
    }
    
    /*@return true if winner on vert1*/
    private boolean vert1Winner(int[][] tempinfoBoard){
        return tempinfoBoard[0][0] == tempinfoBoard[1][0] && tempinfoBoard[1][0] == tempinfoBoard[2][0] && tempinfoBoard[1][0] != 0;
    }
    /*@return true if winner on vert2*/
    private boolean vert2Winner(int[][] tempinfoBoard){
        return tempinfoBoard[0][1] == tempinfoBoard[1][1] && tempinfoBoard[1][1] == tempinfoBoard[2][1] && tempinfoBoard[1][1] != 0;
    }
    /*@return true if winner on vert3*/
    private boolean vert3Winner(int[][] tempinfoBoard){
        return tempinfoBoard[0][2] == tempinfoBoard[1][2] && tempinfoBoard[1][2] == tempinfoBoard[2][2] && tempinfoBoard[1][2] != 0;
    }
    
    
    
    /* calls getNextMove then makes the move*/
    public void makeNextMove(){
        if (!infoBoard.isFilled()){
        getNextMove();
        infoBoard.makeMove(next_move_xcor, next_move_ycor);
        }
    }
    
}