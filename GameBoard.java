import wheels.users.*; 
import java.awt.Color;

public class GameBoard extends Frame{
  
  private Line _top, _bottom, _left, _right;
  private Ellipse check;
  private Xpiece test1;
  private Opiece test2;
  private Board infoBoard;
  
  public GameBoard(){
    infoBoard = new Board();
    test1 = new Xpiece(425,175);
    test2 = new Opiece(275,25);
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