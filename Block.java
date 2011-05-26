import java.awt.Color;
import wheels.users.*;

public class Block{

  private boolean isFalling;
  private String type;
  private int part, row, col;
  private TetrisDriver board;
  
  public Block(int r, int c, String kind, int z){
    row = r;
    col = c;
    board = new TetrisDriver();
    type = kind;
    part = z;
    isFalling = true;
  }
  
  public boolean canMove(){
    return row != 19 && board.getBoard()[row+1][col] == null;
  }
  
  public void stop(){
    isFalling = false;
  }
  
  public void fall(){
    isFalling = true;
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
  
}
      