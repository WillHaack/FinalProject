import java.awt.Color;
import wheels.users.*;
import java.awt.event.KeyEvent; // VK_DOWN, VK_UP, VK_LEFT, VK_RIGHT
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tetris extends Frame{
  
  private TetrisDriver d;
  
  private Timer t = new Timer (300, new ActionListener(){
   public void actionPerformed(ActionEvent ae) {
     d.movePiece();
   }
   });
  
  public Tetris(){
    d = new TetrisDriver();
    TetrisSensorRot rot = new TetrisSensorRot(d);
    TetrisSensorDown down = new TetrisSensorDown(d);
    TetrisSensorLeft left = new TetrisSensorLeft(d);
    TetrisSensorRight right = new TetrisSensorRight(d);
    Rectangle scoreBox = new Rectangle(Color.white);
    scoreBox.setFrameThickness(1);
    scoreBox.setFrameColor(Color.black);
    scoreBox.setLocation(70,30);
    scoreBox.setSize(150,200);
    TetrisTextDisplay header = new TetrisTextDisplay("Score:");
    header.setLocation(100,50);
    TetrisTextDisplay score = new TetrisTextDisplay("0");
    score.setLocation(102,100);
    TetrisBoard b = new TetrisBoard();
    ArrayList<Integer> moveDown = new ArrayList<Integer>();
    t.start();
    while(!d.gameOver()){
      d.addPiece();
      while(d.isDropping()){
        d.align();
        d.display();
      }
      for (int i = 19; i >= 0; i--){
        if (d.rowComplete(i)){
          d.clearRow(i);
          moveDown.add(i);
        }
      }
      d.display();
      for (int i = 0; i < moveDown.size(); i++){
        d.fallDown(moveDown.get(i));
      }
      d.display();
      score.setText("" + d.getScore());
    }
  }
  
    public static void main(String[]args){
      Tetris app = new Tetris();
    }
  }