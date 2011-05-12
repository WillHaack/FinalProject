import wheels.users.*; 
import java.awt.Color;

public class GameBoard extends Frame{
  
  private Line _top, _bottom, _left, _right;
  private Ellipse check;
  
  public GameBoard(){
    _top = new Line();
    _bottom = new Line();
    _left = new Line();
    _right = new Line();
    _top.setColor(Color.black);
    _bottom.setColor(Color.black);
    _left.setColor(Color.black);
    _right.setColor(Color.black);
    _top.setPoints(125,175,575,175);
    _bottom.setPoints(125,325,575,325);
    _left.setPoints(275,25,275,475);
    _right.setPoints(425,25,425,475);
  }
  
  public static void main(String[]args){
    GameBoard app = new GameBoard();
  }
}