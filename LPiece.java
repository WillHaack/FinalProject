import java.awt.Color;
import wheels.users.*;

public class LPiece{
  
  private Rectangle r1, r2, r3, r4;
  
  public LPiece(int x, int y){
    r1 = new Rectangle(Color.blue);
    r2 = new Rectangle(Color.blue);
    r3 = new Rectangle(Color.blue);
    r4 = new Rectangle(Color.blue);
    r1.setFrameThickness(1);
    r2.setFrameThickness(1);
    r3.setFrameThickness(1);
    r4.setFrameThickness(1);
    r1.setFrameColor(Color.white);
    r2.setFrameColor(Color.white);
    r3.setFrameColor(Color.white);
    r4.setFrameColor(Color.white);
    r1.setSize(23,23);
    r2.setSize(23,23);
    r3.setSize(23,23);
    r4.setSize(23,23);
    r1.setLocation(x,y);
    r2.setLocation(x,y+23);
    r3.setLocation(x+23,y+23);
    r4.setLocation(x+46,y+23);
  }
}