import java.awt.Color;
import wheels.users.*;

public class TetrisDriver{

    private Block[][] board;
    private Block b1, b2, b3, b4;
    
    
    public TetrisDriver(){
      board = new Block[20][10]; 
      b1 = null;
      b2 = null;
      b3 = null;
      b4 = null;
    }
    
    public Block[][] getBoard(){
      return board;
    }

    public boolean rowComplete(int row){
      for (int i = 0; i < 10; i++){
        if (board[row][i] == null)
          return false;
      }
      return true;
    }

    public void clearRow(int row){
      for (int i = 0; i < 10; i++)
        board[row][i] = null;
    }
    
    public void addPiece(){
      int type = (int)(Math.random() * 7);
      if (type == 0){
        board[0][3] = new Block(0,3,"I",1);
        board[0][4] = new Block(0,4,"I",2);
        board[0][5] = new Block(0,5,"I",3);
        board[0][6] = new Block(0,6,"I",4);
      }
      else if (type == 1){
        board[0][3] = new Block(0,3,"J",1);
        board[1][3] = new Block(1,3,"J",2);
        board[1][4] = new Block(1,4,"J",3);
        board[1][5] = new Block(1,5,"J",4);
      }
      else if (type == 2){
        board[1][3] = new Block(1,3,"L",1);
        board[1][4] = new Block(1,4,"L",2);
        board[1][5] = new Block(1,5,"L",3);
        board[0][5] = new Block(0,5,"L",4);
      }
      else if (type == 3){
        board[0][4] = new Block(0,4,"O",1);
        board[0][5] = new Block(0,5,"O",2);
        board[1][4] = new Block(1,4,"O",3);
        board[1][5] = new Block(1,5,"O",4);
      }
      else if (type == 4){
        board[1][3] = new Block(1,3,"S",1);
        board[1][4] = new Block(1,4,"S",2);
        board[0][4] = new Block(0,4,"S",3);
        board[0][5] = new Block(0,5,"S",4);
      }
      else if (type == 5){
        board[1][3] = new Block(1,3,"T",1);
        board[1][4] = new Block(1,4,"T",2);
        board[0][4] = new Block(0,4,"T",3);
        board[1][5] = new Block(1,5,"T",4);
      }
      else{
        board[0][3] = new Block(0,3,"Z",1);
        board[0][4] = new Block(0,4,"Z",2);
        board[1][4] = new Block(1,4,"Z",3);
        board[1][5] = new Block(1,5,"Z",4);
      }
    }
    
    public void move(){
      for (int i = 19; i >= 0; i--){
        for (int j = 9; j >= 0; j--){
          if (board[i][j] != null && board[i][j].isFalling()){
            if (board[i+1][j] != null && i != 19){
            board[i+1][j] = board[i][j];
            board[i][j] = null;
            }
            else
              board[i][j].stop();
          }
        }
      }
    }
    
    public void print(){
      for (int i = 0; i < 20; i++){
        for (int j = 0; j < 10; j++){
          if (board[i][j] == null)
            System.out.print("_");
          else System.out.print("*");
        }
        System.out.println();
      }
    }
    
    public void display(){
      for (int i = 0; i < 20; i++){
        for (int j = 0; j < 10; j++){
          if (board[i][j] != null){
            Rectangle body = new Rectangle();
            String kind = board[i][j].getType();
            if(kind.equals("I"))
              body.setColor(Color.cyan);
            else if (kind.equals("J"))
              body.setColor(Color.blue);
            else if (kind.equals("L"))
              body.setColor(Color.orange);
            else if (kind.equals("O"))
              body.setColor(Color.yellow);
            else if (kind.equals("S"))
              body.setColor(Color.green);
            else if (kind.equals("T"))
              body.setColor(Color.magenta);
            else if (kind.equals("Z"))
              body.setColor(Color.red);
            body.setSize(23,23);
            body.setFrameThickness(1);
            body.setFrameColor(Color.white);
            body.setLocation(235 + (j * 23), 20 + (i * 23));
          }
        }
      }
    }
     
}