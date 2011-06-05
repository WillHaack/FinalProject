import java.awt.Color;
import wheels.users.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FallBackground{
  private Rectangle background;
  FallDownBoard f;
  
  public FallBackground(){
    background = new Rectangle(Color.black);
    f = new FallDownBoard(25,15);    
    background.setLocation(210,20);
    background.setSize(270,450);   
    f.fillPlats(3);
    f.display(210,20,18);
  }
  
  public FallDownBoard getBoard(){
    return f;
  }
  
  public static void main(String[] args){
    FallBackground app = new FallBackground();
  }
  
  public void keyPressed (KeyEvent ke) {
    switch (ke.getKeyCode()){
    case KeyEvent.VK_LEFT:
     f.moveLeft();
    break;
    case KeyEvent.VK_RIGHT:
     f.moveRight();
     break;
    case KeyEvent.VK_ENTER:
      f.start();
      break;
  }
 }
}