import wheels.users.*; 
import java.awt.Color;

public class GameBoard extends Frame{
  
  private Line _top, _bottom, _left, _right;
  private Board infoBoard;
  private Sensor s1,s2,s3,s4,s5,s6,s7,s8,s9;
  
  public GameBoard(){
    infoBoard = new Board();
    s1 = new Sensor(infoBoard,125,25,0,0);
    s2 = new Sensor(infoBoard,275,25,0,1);
    s3 = new Sensor(infoBoard,425,25,0,2);
    s4 = new Sensor(infoBoard,125,175,1,0);
    s5 = new Sensor(infoBoard,275,175,1,1);
    s6 = new Sensor(infoBoard,425,175,1,2);
    s7 = new Sensor(infoBoard,125,325,2,0);
    s8 = new Sensor(infoBoard,275,325,2,1);
    s9 = new Sensor(infoBoard,425,325,2,2);
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
  
  public static void main(String[]args){
    GameBoard app = new GameBoard();
  }
}