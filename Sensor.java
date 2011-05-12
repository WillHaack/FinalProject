import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Sensor extends Rectangle{
 
  private Board _board;
  private int _x, _y;
  private int bX, bY;
  
  public Sensor(Board bor, int x, int y, int a, int b){
    super(Color.red);
    bX = a; //gives actual xcor
    bY = b; //gives actual ycor
    _x = x; //gives frame xcor
    _y = y; //gives frame ycor
    _board = bor;
    setSize(148,148);
    setLocation(x+1,y+1);
  }
  
  public void mousePressed (MouseEvent e){
    setColor(Color.blue);
    if (_board.getTurn() && _board.canMove(bX,bY)){
        Xpiece X = new Xpiece(_x,_y);
        _board.makeMove(bX,bY,1);
        setColor(Color.blue);
    }
      else if(_board.canMove(bX,bY)){ 
        Opiece O = new Opiece(_x,_y);
        _board.makeMove(bX,bY,2);
        setColor(Color.red);
      }
    }
  
  public void mouseRealesed(MouseEvent e){};
  
}