import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Sensor{
 
  private Board _board;
  private Rectangle _body;
  private int _x, _y;
  private int bX, bY;
  
  public Sensor(Board bor, int x, int y, int a, int b){
    bX = a;
    bY = b;
    _x = x;
    _y = y;
    _board = bor;
    _body = new Rectangle(Color.white);
    _body.setSize(148,148);
    _body.setLocation(x+1,y+1);
  }
  
  public void mousePressed (MouseEvent e){
    if (_board.getTurn() && _board.canMove(bX,bY)){
        Xpiece X = new Xpiece(_x,_y);
        _board.makeMove(bX,bY,1);
    }
      else if(_board.canMove(bX,bY)){ 
        Opiece O = new Opiece(_x,_y);
        _board.makeMove(bX,bY,2);
      }
    }
  
}