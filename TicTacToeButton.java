import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class TicTacToeButton extends Rectangle{
  
  public TicTacToeButton(int x, int y){
    setSize(100,100);
    setLocation(x,y);
    setColor(Color.black);
  }
  
  public void mouseClicked(MouseEvent e) {
    TicTacToeGame app = new TicTacToeGame();
  }
  
}