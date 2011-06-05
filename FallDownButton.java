import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class FallDownButton extends Rectangle{
  
  public FallDownButton(int x, int y){
    setSize(100,100);
    setLocation(x,y);
    setColor(Color.black);
  }
  
  public void mouseClicked(MouseEvent e) {
    FallDown app = new FallDown();
  }
  
}