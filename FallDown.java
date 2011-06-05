import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import wheels.users.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class FallDown extends Frame{
  private int score, tick;
  private boolean isStart;
  private FallDownBoard board;
  
  Timer t = new Timer (100, new ActionListener(){
    public void actionPerformed(ActionEvent arg0){
      if (board.getBall().getRow() == 0 || board.getBall().getRow() == board.getBoard().length - 1)
        t.stop();
      tick++;
      score++;
      if(tick % 10 == 0){
        board.moveUpBoard();
        board.moveDown();
        board.display(210,20,18);
      }
      else{
        board.moveDown();
        board.display(210,20,18);
      }
    }
  });
  
  public FallDown(){
    isStart = false;
    FallBackground fb = new FallBackground();
    score = 0;
    tick = 0;
    board = fb.getBoard();
    t.start();
  }
  
  public static void main(String[] args){
    FallDown app = new FallDown();
  }
  public void keyPressed (KeyEvent ke) {
    switch (ke.getKeyCode()){
      case KeyEvent.VK_LEFT:
        board.moveLeft();
        break;
      case KeyEvent.VK_RIGHT:
        board.moveRight();
        break;
    }
    board.display(210,20,18);
  }
}