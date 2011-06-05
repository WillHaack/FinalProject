import java.awt.Color;
import wheels.users.*;
import java.util.*;

public class TetrisDriver{
  
  private Block[][] board;
  private Block b1, b2, b3, b4;
  private Block[] piece;
  private boolean dropping, gameOver;
  private int score;
  
  public TetrisDriver(){
    board = new Block[20][10];
    piece = new Block[4];
    b1 = null;
    b2 = null;
    b3 = null;
    b4 = null;
    dropping = false;
  }
  
  public Block[][] getBoard(){
    return board;
  }
  
  public boolean isDropping(){
    return dropping;
  }
  
  public int getScore(){
    return score;
  }
  
  public boolean gameOver(){
    return gameOver;
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
    score += 100;
  }
  
  public void fallDown(int row){
    for (int i = row; i >= 0; i--){
      for (int j = 0; j < 10; j++){
        if (board[i][j] != null){
          board[i+1][j] = board[i][j];
          board[i][j] = null;
        }
      }
    }
  }
  
  public boolean isPart(Block x){
    for (int i = 0; i < 4; i++){
      if (piece[i] == x)
        return true;
    }
    return false;
  }
  
  public void addPiece(){
    int type = (int)(Math.random() * 7);
    if (type == 0){
      if (board[0][3] != null || board[0][4] != null 
            || board[0][5] != null || board[0][6] != null)
        gameOver = true;
      else{
        board[0][3] = new Block(0,3,"I",1);
        board[0][4] = new Block(0,4,"I",2);
        board[0][5] = new Block(0,5,"I",3);
        board[0][6] = new Block(0,6,"I",4);
      }
    }
    else if (type == 1){
      if (board[1][3] != null || board[1][4] != null 
            || board[1][5] != null || board[0][3] != null)
        gameOver = true;
      else{
        board[1][3] = new Block(1,3,"J",1);
        board[1][4] = new Block(1,4,"J",2);
        board[1][5] = new Block(1,5,"J",3);
        board[0][3] = new Block(0,3,"J",4);
      }
    }
    else if (type == 2){
      if (board[1][3] != null || board[1][4] != null 
            || board[1][5] != null || board[0][5] != null)
        gameOver = true;
      else{
        board[1][3] = new Block(1,3,"L",1);
        board[1][4] = new Block(1,4,"L",2);
        board[1][5] = new Block(1,5,"L",3);
        board[0][5] = new Block(0,5,"L",4);
      }
    }
    else if (type == 3){
      if (board[1][4] != null || board[1][5] != null 
            || board[0][4] != null || board[0][5] != null)
        gameOver = true;
      else{
        board[1][4] = new Block(1,4,"O",1);
        board[1][5] = new Block(1,5,"O",2);
        board[0][4] = new Block(0,4,"O",3);
        board[0][5] = new Block(0,5,"O",4);
      }
    }
    else if (type == 4){
      if (board[1][3] != null || board[1][4] != null 
            || board[0][4] != null || board[0][5] != null)
        gameOver = true;
      else{
        board[1][3] = new Block(1,3,"S",1);
        board[1][4] = new Block(1,4,"S",2);
        board[0][4] = new Block(0,4,"S",3);
        board[0][5] = new Block(0,5,"S",4);
      }
    }
    else if (type == 5){
      if (board[1][3] != null || board[1][4] != null 
            || board[1][5] != null || board[0][4] != null)
        gameOver = true;
      else{
        board[1][3] = new Block(1,3,"T",1);
        board[1][4] = new Block(1,4,"T",2);
        board[1][5] = new Block(1,5,"T",3);
        board[0][4] = new Block(0,4,"T",4);
      }
    }
    else{
      if (board[1][4] != null || board[1][5] != null 
            || board[0][3] != null || board[0][4] != null)
        gameOver = true;
      else{
        board[1][4] = new Block(1,4,"Z",1);
        board[1][5] = new Block(1,5,"Z",2);
        board[0][3] = new Block(0,3,"Z",3);
        board[0][4] = new Block(0,4,"Z",4);
      }
    }
    if (!gameOver){
      dropping = true;
      int at = 0;
      for (int i = 1; i >= 0; i--){
        for (int j = 3; j < 7; j++){
          if (board[i][j] != null && board[i][j].isFalling()){
            piece[at] = board[i][j];
            at++;
          }
        }
      }
    }
  }
  
  public void movePiece(){
    boolean canMove = true;
    for (int i = 0; i < 4; i++){
      if (piece[i].getRow() == 19 || 
          (board[piece[i].getRow()+1][piece[i].getCol()] != null
             && !isPart(board[piece[i].getRow()+1][piece[i].getCol()]))){
        canMove = false;
        break;
      }
    }
    if (canMove){
      for (int i = 0; i < 4; i++){
        piece[i].setLocation(board,piece[i].getRow()+1,piece[i].getCol());
      }
    }
    else{
      for (int i = 0; i < 4; i++){
        piece[i].stop();
        dropping = false;
      }
    }
  }
  
  public void align(){
    for (int i = 0; i < 4; i++)
      board[piece[i].getRow()][piece[i].getCol()] = piece[i];
  }
  
  public void movePieceRight(){
    boolean canMove = true;
    for (int i = 0; i < 4; i++){
      if (piece[i].getCol() == 9 || 
          (board[piece[i].getRow()][piece[i].getCol()+1] != null
             && !isPart(board[piece[i].getRow()][piece[i].getCol()+1]))){
        canMove = false;
        break;
      }
    }
    if (canMove){
      for (int i = 0; i < 4; i++){
        piece[i].setLocation(board,piece[i].getRow(),piece[i].getCol() + 1);
      }
    }
  }
  
  public void movePieceLeft(){
    boolean canMove = true;
    for (int i = 0; i < 4; i++){
      if (piece[i].getCol() == 0 || 
          (board[piece[i].getRow()][piece[i].getCol()-1] != null
             && !isPart(board[piece[i].getRow()][piece[i].getCol()-1]))){
        canMove = false;
        break;
      }
    }
    if (canMove){
      for (int i = 0; i < 4; i++){
        piece[i].setLocation(board,piece[i].getRow(),piece[i].getCol() - 1);
      }
    }
  }
  
  public void rotate(){
    if (canRotate())
      rotatePiece();
    else{ 
      movePieceRight();
      if (canRotate())
        rotatePiece();
      else{ 
        movePieceRight();
        if (canRotate())
          rotatePiece();
        else{
          for (int i = 0; i < 3; i++)
            movePieceLeft();
          if (canRotate())
            rotatePiece();
          else{
            movePieceLeft();
            if (canRotate())
              rotatePiece();
          }
        }
      }
    }
  }
  
  public void rotatePiece(){
    for (int i= 0; i< 4; i++){
      Block cur = piece[i];
      if (cur.getType().equals("S")){
        if (cur.getStage() == 1){
          if (cur.getPart()== 1)
            cur.setLocation(board,cur.getRow(),cur.getCol()+1);
          else if (cur.getPart()== 2)
            cur.setLocation(board,cur.getRow()-1,cur.getCol());
          else if (cur.getPart()== 3)
            cur.setLocation(board,cur.getRow(),cur.getCol() - 1);
          else cur.setLocation(board,cur.getRow()-1,cur.getCol() - 2);
        }
        else{
          if (cur.getPart()== 1)
            cur.setLocation(board,cur.getRow(),cur.getCol() - 1);
          else if (cur.getPart()== 2)
            cur.setLocation(board,cur.getRow()+1,cur.getCol());
          else if (cur.getPart()== 3)
            cur.setLocation(board,cur.getRow(),cur.getCol() + 1);
          else cur.setLocation(board,cur.getRow()+1,cur.getCol() + 2);
        }
      }
      else if (cur.getType().equals("Z")){
        if (cur.getStage() == 1){
          if (cur.getPart()== 1)
            cur.setLocation(board,cur.getRow(), cur.getCol());
          else if (cur.getPart()== 2)
            cur.setLocation(board,cur.getRow()-1, cur.getCol()-1);
          else if (cur.getPart()== 3)
            cur.setLocation(board,cur.getRow(), cur.getCol() + 2);
          else cur.setLocation(board,cur.getRow() - 1, cur.getCol() + 1);
        }
        else{
          if (cur.getPart()== 1)
            cur.setLocation(board,cur.getRow(),cur.getCol());
          else if (cur.getPart()== 2)
            cur.setLocation(board,cur.getRow()+1,cur.getCol()+1);
          else if (cur.getPart()== 3)
            cur.setLocation(board,cur.getRow(), cur.getCol() - 2);
          else cur.setLocation(board,cur.getRow()+1, cur.getCol() -1);
        }
      }
      else if (cur.getType().equals("I")){
        if (cur.getStage() == 1){
          if (cur.getPart()== 1)
            cur.setLocation(board,cur.getRow()+1,cur.getCol()+1);
          else if (cur.getPart()== 3)
            cur.setLocation(board,cur.getRow()-1,cur.getCol() - 1);
          else if (cur.getPart()== 4)
            cur.setLocation(board,cur.getRow() - 2, cur.getCol() - 2);
        }
        else{
          if (cur.getPart()== 1)
            cur.setLocation(board,cur.getRow()-1,cur.getCol()-1);
          else if (cur.getPart()== 3)
            cur.setLocation(board,cur.getRow() + 1, cur.getCol() + 1);
          else if (cur.getPart()== 4)
            cur.setLocation(board,cur.getRow() + 2, cur.getCol() + 2);
        }
      }
      else if (cur.getType().equals("T")){
        if (cur.getStage() == 1){
          if (cur.getPart() ==1)
            cur.setLocation(board,cur.getRow() + 1, cur.getCol() + 1);
        }
        else if (cur.getStage() == 2){
          if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow(), cur.getCol() - 2);
          else if (cur.getPart() == 4)
            cur.setLocation(board,cur.getRow() + 1, cur.getCol() + 1);
        }
        else if (cur.getStage() == 3){
          if (cur.getPart() == 4)
            cur.setLocation(board,cur.getRow() - 1, cur.getCol() - 1);
        }
        else{
          if (cur.getPart() == 1)
            cur.setLocation(board,cur.getRow() - 1, cur.getCol() - 1);
          else if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow(), cur.getCol() + 2);
        }
      }
      else if (cur.getType().equals("J")){
        if (cur.getStage() == 1){
          if (cur.getPart() == 1)
            cur.setLocation(board,cur.getRow(), cur.getCol() + 1);
          else if (cur.getPart() == 2)
            cur.setLocation(board,cur.getRow()-1,cur.getCol());
          else if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow()-2,cur.getCol() -1);
          else
            cur.setLocation(board,cur.getRow()-1,cur.getCol() + 2);
        }
        else if (cur.getStage() == 2){
          if (cur.getPart() == 1)
            cur.setLocation(board,cur.getRow(),cur.getCol() + 1);
          else if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow()+1,cur.getCol()-1);
          else if (cur.getPart() == 4)
            cur.setLocation(board,cur.getRow()+1,cur.getCol());
        }
        else if (cur.getStage() == 3){
          if (cur.getPart() == 1)
            cur.setLocation(board,cur.getRow(),cur.getCol() - 2);
          else if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow()+1,cur.getCol()+1);
          else if (cur.getPart() == 4)
            cur.setLocation(board,cur.getRow()-1,cur.getCol() - 1);
        }
        else{
          if (cur.getPart() == 1)
            cur.setLocation(board,cur.getRow(),cur.getCol());
          else if (cur.getPart() == 2)
            cur.setLocation(board,cur.getRow()+1,cur.getCol());
          else if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow(),cur.getCol() + 1);
          else
            cur.setLocation(board,cur.getRow()+1,cur.getCol() - 1);
        }
      }
      else if (cur.getType().equals("L")){
        if (cur.getStage() == 1){
          if (cur.getPart() == 1)
            cur.setLocation(board,cur.getRow(),cur.getCol() + 1);
          else if (cur.getPart() == 2)
            cur.setLocation(board,cur.getRow(),cur.getCol() + 1);
          else if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow()-1,cur.getCol() -1);
          else 
            cur.setLocation(board,cur.getRow()-1,cur.getCol()-1);
        }
        else if (cur.getStage() == 2){
          if (cur.getPart() == 1)
            cur.setLocation(board,cur.getRow(),cur.getCol()-1);
          else if (cur.getPart() == 2)
            cur.setLocation(board,cur.getRow()-1,cur.getCol()-1);
          else if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow(),cur.getCol() -1);
          else
            cur.setLocation(board,cur.getRow()+1,cur.getCol()+1);
        }
        else if (cur.getStage() == 3){
          if (cur.getPart() == 1)
            cur.setLocation(board,cur.getRow(),cur.getCol()+1);
          else if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow()-1,cur.getCol()+1);
          else if (cur.getPart() == 4)
            cur.setLocation(board,cur.getRow()-1,cur.getCol() - 2);
        }
        else{
          if (cur.getPart() == 1)
            cur.setLocation(board,cur.getRow(),cur.getCol() - 1);
          else if (cur.getPart() == 2)
            cur.setLocation(board,cur.getRow()+1,cur.getCol());
          else if (cur.getPart() == 3)
            cur.setLocation(board,cur.getRow()+2,cur.getCol() +1);
          else
            cur.setLocation(board,cur.getRow()+1,cur.getCol() + 2);
        }
      }
      cur.rotate();
    }
  }
  
  public boolean canRotate(){
    ArrayList<Boolean> good = new ArrayList<Boolean>();
    for (int i= 0; i< 4; i++){
      Block cur = piece[i];
      if (cur.getType().equals("S")){
        if (cur.getStage() == 1){
          if (cur.getPart()== 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol()+1));
          else if (cur.getPart()== 2)
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol()));
          else if (cur.getPart()== 3)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() - 1));
          else good.add(cur.canMove(board,cur.getRow()-1,cur.getCol() - 2));
        }
        else{
          if (cur.getPart()== 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() - 1));
          else if (cur.getPart()== 2)
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol()));
          else if (cur.getPart()== 3)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() + 1));
          else good.add(cur.canMove(board,cur.getRow()+1,cur.getCol() + 2));
        }
      }
      else if (cur.getType().equals("Z")){
        if (cur.getStage() == 1){
          if (cur.getPart()== 1)
            good.add(cur.canMove(board,cur.getRow(), cur.getCol()));
          else if (cur.getPart()== 2)
            good.add(cur.canMove(board,cur.getRow()-1, cur.getCol()-1));
          else if (cur.getPart()== 3)
            good.add(cur.canMove(board,cur.getRow(), cur.getCol() + 2));
          else good.add(cur.canMove(board,cur.getRow() - 1, cur.getCol() + 1));
        }
        else{
          if (cur.getPart()== 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol()));
          else if (cur.getPart()== 2)
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol()+1));
          else if (cur.getPart()== 3)
            good.add(cur.canMove(board,cur.getRow(), cur.getCol() - 2));
          else good.add(cur.canMove(board,cur.getRow()+1, cur.getCol() -1));
        }
      }
      else if (cur.getType().equals("I")){
        if (cur.getStage() == 1){
          if (cur.getPart()== 1)
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol()+1));
          else if (cur.getPart()== 3)
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol() - 1));
          else if (cur.getPart()== 4)
            good.add(cur.canMove(board,cur.getRow() - 2, cur.getCol() - 2));
        }
        else{
          if (cur.getPart()== 1)
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol()-1));
          else if (cur.getPart()== 3)
            good.add(cur.canMove(board,cur.getRow() + 1, cur.getCol() + 1));
          else if (cur.getPart()== 4)
            good.add(cur.canMove(board,cur.getRow() + 2, cur.getCol() + 2));
        }
      }
      else if (cur.getType().equals("T")){
        if (cur.getStage() == 1){
          if (cur.getPart() ==1)
            good.add(cur.canMove(board,cur.getRow() + 1, cur.getCol() + 1));
        }
        else if (cur.getStage() == 2){
          if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow(), cur.getCol() - 2));
          else if (cur.getPart() == 4)
            good.add(cur.canMove(board,cur.getRow() + 1, cur.getCol() + 1));
        }
        else if (cur.getStage() == 3){
          if (cur.getPart() == 4)
            good.add(cur.canMove(board,cur.getRow() - 1, cur.getCol() - 1));
        }
        else{
          if (cur.getPart() == 1)
            good.add(cur.canMove(board,cur.getRow() - 1, cur.getCol() - 1));
          else if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow(), cur.getCol() + 2));
        }
      }
      else if (cur.getType().equals("J")){
        if (cur.getStage() == 1){
          if (cur.getPart() == 1)
            good.add(cur.canMove(board,cur.getRow(), cur.getCol() + 1));
          else if (cur.getPart() == 2)
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol()));
          else if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow()-2,cur.getCol() -1));
          else
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol() + 2));
        }
        else if (cur.getStage() == 2){
          if (cur.getPart() == 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() + 1));
          else if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol()-1));
          else if (cur.getPart() == 4)
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol()));
        }
        else if (cur.getStage() == 3){
          if (cur.getPart() == 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() - 2));
          else if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol()+1));
          else if (cur.getPart() == 4)
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol() - 1));
        }
        else{
          if (cur.getPart() == 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol()));
          else if (cur.getPart() == 2)
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol()));
          else if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() + 1));
          else
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol() - 1));
        }
      }
      else if (cur.getType().equals("L")){
        if (cur.getStage() == 1){
          if (cur.getPart() == 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() + 1));
          else if (cur.getPart() == 2)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() + 1));
          else if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol() -1));
          else 
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol()-1));
        }
        else if (cur.getStage() == 2){
          if (cur.getPart() == 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol()-1));
          else if (cur.getPart() == 2)
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol()-1));
          else if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() -1));
          else
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol()+1));
        }
        else if (cur.getStage() == 3){
          if (cur.getPart() == 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol()+1));
          else if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol()+1));
          else if (cur.getPart() == 4)
            good.add(cur.canMove(board,cur.getRow()-1,cur.getCol() - 2));
        }
        else{
          if (cur.getPart() == 1)
            good.add(cur.canMove(board,cur.getRow(),cur.getCol() - 1));
          else if (cur.getPart() == 2)
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol()));
          else if (cur.getPart() == 3)
            good.add(cur.canMove(board,cur.getRow()+2,cur.getCol() +1));
          else
            good.add(cur.canMove(board,cur.getRow()+1,cur.getCol() + 2));
        }
      }
    }
    for (int i = 0; i < 4; i++){
      if (good.get(i) == false)
        return false;
    }
    return true;
  }
  
  
  public void print(){
    for (int i = 0; i < 20; i++){
      for (int j = 0; j < 10; j++){
        if (board[i][j] == null)
          System.out.print("_ ");
        else System.out.print(board[i][j].getPart() + " " + i + "," + j + " ");
      }
      System.out.println();
    }
  }
  
  public void printPiece(){
    for (int i = 0; i < 4; i++)
      System.out.println(piece[i].getPart() + " ");
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
        else{
          Rectangle body = new Rectangle(Color.black);
          body.setSize(23,23);
          body.setFrameThickness(1);
          body.setFrameColor(Color.white);
          body.setLocation(235 + (j * 23), 20 + (i * 23));
        }
      }
    }
  }
}