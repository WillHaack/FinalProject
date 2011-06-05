import java.awt.Color;
import wheels.users.*;

public class Block{
  
  private boolean isFalling;
  private String type;
  private int part, row, col, stage;
  private TetrisDriver board;
  
  public Block(int r, int c, String kind, int z){
    row = r;
    col = c;
    board = new TetrisDriver();
    type = kind;
    part = z;
    isFalling = true;
    stage = 1;
  }
  
  public boolean canMove(){
    return row != 19 && board.getBoard()[row+1][col] == null;
  }
  
  public void stop(){
    isFalling = false;
  }
  
  public void setPart(int x){
    part = x;
  }
  
  public int getStage(){
    return stage;
  }
  
  public void rotate(){
    if (type.equals("L") || type.equals("J") || type.equals("T")){
      stage++;
      if (stage >= 5)
        stage = 1;
    }
    else if (!type.equals("O")){
      stage++;
      if (stage >= 3)
        stage = 1;
    }
  }
  
  public void fall(){
    isFalling = true;
  }
  
  public int getPart(){
    return part;
  }
  
  public String getType(){
    return type;
  }
  
  public boolean isFalling(){
    return isFalling;
  }
  
  public void moveDown(){
    row++;
  }
  
  public void moveLeft(){
    col--;
  }
  
  public void moveRight(){
    col++;
  }
  
  public int getRow(){
    return row;
  }
  
  public int getCol(){
    return col;
  }
  
  public boolean canMoveLeft(){
    return col != 0;
  }
  
  public boolean canMoveRight(){
    return col!= 9;
  }
  
  public void setLocation(Block[][] board, int r, int c){
    board[row][col] = null;
    board[r][c] = this;
    row = r;
    col = c;
  }
  
  public boolean canMove(Block[][] board, int r, int c){
    return board[r][c] == null && r >= 0 && r <= 19 && c >= 0 && c <= 9;
  }
}