import wheels.users.*; 
import java.awt.Color;

public class GameBoard extends Frame{
  
  private Line _top, _bottom, _left, _right;
  private Board infoBoard;
  private Sensor s1,s2,s3,s4,s5,s6,s7,s8,s9;
  
  public GameBoard(){
    infoBoard = new Board();
    s1 = new Sensor(infoBoard,125,25,0,0, this);
    s2 = new Sensor(infoBoard,275,25,0,1, this);
    s3 = new Sensor(infoBoard,425,25,0,2, this);
    s4 = new Sensor(infoBoard,125,175,1,0, this);
    s5 = new Sensor(infoBoard,275,175,1,1, this);
    s6 = new Sensor(infoBoard,425,175,1,2, this);
    s7 = new Sensor(infoBoard,125,325,2,0, this);
    s8 = new Sensor(infoBoard,275,325,2,1, this);
    s9 = new Sensor(infoBoard,425,325,2,2, this);
    _top = new Line();
    _bottom = new Line();
    _left = new Line();
    _right = new Line();
    _top.setThickness(2);
    _bottom.setThickness(2);
    _left.setThickness(2);
    _right.setThickness(2);
    _top.setColor(Color.black);
    _bottom.setColor(Color.black);
    _left.setColor(Color.black);
    _right.setColor(Color.black);
    _top.setPoints(125,175,575,175);
    _bottom.setPoints(125,325,575,325);
    _left.setPoints(275,25,275,475);
    _right.setPoints(425,25,425,475);
  }
  
  public Board getBoard(){
      return infoBoard;
  }
  
  public void addPiece(int x, int y){
      if (x == 0 && y == 0)
          s1.addPiece();
      if (x == 0 && y == 1)
          s2.addPiece();
      if (x == 0 && y == 2)
          s3.addPiece();
      if (x == 1 && y == 0)
          s4.addPiece();
      if (x == 1 && y == 1)
          s5.addPiece();
      if (x == 1 && y == 2)
          s6.addPiece();
      if (x == 2 && y == 0)
          s7.addPiece();
      if (x == 2 && y == 1)
          s8.addPiece();
      if (x == 2 && y == 2)
          s9.addPiece();
  }
  
  public void display(){
      for (int r = 0; r < 3; r++){
          for (int c = 0; c < 3; c++){
              addPiece(r, c);
          }
      }
  }
  
  public static void main(String[]args){
    GameBoard app = new GameBoard();
  }
}