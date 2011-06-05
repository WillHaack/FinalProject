//using this one for the final

public class FallBall{
    private int whereRow, whereCol;

    public FallBall(int whereR, int whereC){
      whereRow = whereR;
      whereCol = whereC;
    }
    
    public boolean isFrontOpen(int[][] board){
      if(whereRow == board.length - 1)
        return false;
      else if(board[whereRow + 1][whereCol] == 1)
        return false;
      else return true;
    }
    
    public boolean isRightOpen(int [][] board){
      if(whereCol == board[0].length - 1)
        return false;
      else if(board[whereRow][whereCol + 1] == 1)
        return false;
      else return true;
    }
    
    public boolean isLeftOpen(int [][] board){
      if(whereCol == 0)
        return false;
      else if(board[whereRow][whereCol - 1] == 1)
        return false;
      else return true;
    }
    
    public int getRow(){
      return whereRow;
    }
    
    public int getCol(){
      return whereCol;
    }
    
    public void setRow(int r){
      whereRow = r;
    }

    public void setCol(int c){
      whereCol = c;
    }
}