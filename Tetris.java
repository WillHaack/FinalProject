import java.awt.Color;
import wheels.users.*;
import java.awt.event.KeyEvent; // VK_DOWN, VK_UP, VK_LEFT, VK_RIGHT
import java.util.ArrayList;
import javax.swing.*;

public class Tetris extends Frame{

    public Tetris() throws java.lang.InterruptedException{
      Rectangle scoreBox = new Rectangle(Color.white);
      scoreBox.setFrameThickness(1);
      scoreBox.setFrameColor(Color.black);
      scoreBox.setLocation(70,30);
      scoreBox.setSize(150,200);
      TextDisplay header = new TextDisplay("Score:");
      header.setLocation(100,50);
      TextDisplay score = new TextDisplay("0");
      score.setLocation(102,100);
      TetrisDriver d = new TetrisDriver();
      TetrisBoard b = new TetrisBoard();
      while(!d.gameOver()){
        d.addPiece();
        d.align();
        d.display();
        for (int i = 0; i < 5; i++){
          Thread.sleep(300);
          d.movePiece();
          d.align();
          d.display();
        }
        int x = (int)(Math.random() * 4);
        for (int i = 0; i < x; i++){
          Thread.sleep(300);
          d.rotate();
          d.align();
          d.display();
        }
        int y = (int)(Math.random() * 2);
        if (y == 0){
          for (int i = 0; i < x; i++){
            Thread.sleep(300);
            d.movePieceLeft();
            d.align();
            d.display();
          }
        }
        else{
          for (int i = 0; i < x; i++){
            Thread.sleep(300);
            d.movePieceRight();
            d.align();
            d.display();
          }
        }
        while(d.isDropping()){
          Thread.sleep(300);
          d.movePiece();
          d.align();
          d.display();
        }
        ArrayList<Integer> moveDown = new ArrayList<Integer>();
        for (int i = 19; i >= 0; i--){
          if (d.rowComplete(i)){
            Thread.sleep(300);
            d.clearRow(i);
            d.display();
            moveDown.add(i);
          }
        }
        for (int i = 0; i < moveDown.size(); i++){
          Thread.sleep(300);
          d.fallDown(moveDown.get(i));
          d.display();
        }
      }
    }
    
    public static void main(String[]args) throws java.lang.InterruptedException{
      Tetris app = new Tetris();
    }
}