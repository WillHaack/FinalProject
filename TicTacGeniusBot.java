/* the genius bot always wins or ties */
public class TicTacGeniusBot implements TicTacToeBot{
    int next_move_xcor, next_move_ycor, team, numcalcs;
    TicTacBoard infoBoard;
    
    /* makes a new ai with access to the gameboard*/
    public TicTacGeniusBot(TicTacBoard newboard, int n){
        infoBoard = newboard;
        team = n;
    }
    
    /*gets best possible move*/
    public void getNextMove(){
     int[] next_move_array = nextBestMove();
     next_move_xcor = next_move_array[0];
     next_move_ycor = next_move_array[1];
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
            ans += 10;
        if (catchCornerTrap(x, y))
            ans += 50;
        return ans + (int)(Math.random() * 5); //same valued moves don't get repeated.
    }
    
    private boolean catchCornerTrap(int x,int y){
        boolean isSide = !isCorner(x, y) && !isCenter(x, y);
        int opp_team = 1;
        if (team == 1)
            opp_team = 2;
        int[][] tempinfoBoard = infoBoard.getIntArray();
        boolean gotCorners = (tempinfoBoard[0][0] == opp_team && tempinfoBoard[2][2] == opp_team) || 
                           (tempinfoBoard[2][0] == opp_team && tempinfoBoard[0][2] == opp_team);
        return isSide && gotCorners;
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

    private boolean isWinner(int x,int y, int[][] tempinfoBoard){
        tempinfoBoard[x][y] = team;
        return diagonalWinner(tempinfoBoard) ||
               row1Winner(tempinfoBoard) || row2Winner(tempinfoBoard) || row3Winner(tempinfoBoard) || 
                vert1Winner(tempinfoBoard) || vert2Winner(tempinfoBoard) || vert3Winner(tempinfoBoard);
    }
    
     private boolean isWinner(int[][] tempinfoBoard, int player){
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

/* generates a list of possible moves */
    public int[][] getPossibleMoves(int[][] tempInfoBoard) {
        int num_moves = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (tempInfoBoard[r][c] == 0) {
                    num_moves++;
                }
            }
        }
        int[][] ans = new int[num_moves][2];
        int temp = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (tempInfoBoard[r][c] == 0) {
                    ans[temp][0] = r;
                    ans[temp++][1] = c;
                }
            }
        }
        return ans;
    }
    
    
    /* returns the max of 2 moves. move1[0] = r position move1[1] = c position move1[2] = value */
    

    private int max(int move1, int move2){
        if (move1 > move2) {
            return move1;
        }
        return move2;
    }

    private int[] nextBestMove(){
       int[][] next_possible_moves = getPossibleMoves(infoBoard.getIntArray());
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int bestValue = -1000;
        int other_player = (team % 2 ) + 1;
        for (int[] move : next_possible_moves){
            int[][] tempInfoBoard = infoBoard.getIntArray();;
            tempInfoBoard[move[0]][move[1]] = team;
            if (isWinner(tempInfoBoard, team)){
                ans = move;
                break;
            }
            if (0 - nextBestMoveHelper(other_player, tempInfoBoard) >= bestValue){
                bestValue = 0 - nextBestMoveHelper(other_player, tempInfoBoard);
                ans = move;
            }
        } 
        return ans;
    }
    
    public int[][] getCopy(int[][] original){
        int[][] ans = new int[original.length][original.length];
        for (int r = 0; r < original.length; r++){
            for (int c = 0 ; c < original.length; c++){
                ans[r][c] = original[r][c];
        }   
        }
        return ans;
    }
    
    private int nextBestMoveHelper(int player, int[][] tempBoard){
        numcalcs++;
        int[][] next_possible_moves = getPossibleMoves(tempBoard);
	if (next_possible_moves.length == 0)
            return 0;
        int bestValue = -1000;
        int other_player = (player % 2) + 1;
        for (int[] move : next_possible_moves){
            int[][] tempInfoBoard = getCopy(tempBoard);
            tempInfoBoard[move[0]][move[1]] = player;
            if (isWinner(tempInfoBoard, player)){
                return 1000;
            }
            bestValue = max(bestValue, 0 - nextBestMoveHelper(other_player, tempInfoBoard));
        }
        return bestValue;
    }



		
    
}