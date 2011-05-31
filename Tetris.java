import java.awt.Color;
import wheels.users.*;

public class Tetris extends Frame{

    public Tetris() throws java.lang.InterruptedException{
      TetrisDriver d = new TetrisDriver();
      TetrisBoard b = new TetrisBoard();
      d.addPiece(6);
      d.display();
      for (int i = 0; i < 10; i++){
        Thread.sleep(300);
        d.movePiece();
        d.display();
      }
      d.print();
      System.out.println();
      d.rotate();
      d.align();
      d.display();
      Thread.sleep(300);
      /*d.print();
      Thread.sleep(500);*/
      d.movePiece();
      d.display();
      d.print();
      Thread.sleep(500);
      d.rotate();
      d.align();
      d.display();
      System.out.println();
      d.print();
      Thread.sleep(2000);
      for (int i = 0; i < 10; i++){
        Thread.sleep(300);
        d.movePiece();
        d.display();
      }
      d.printPiece();
    }
    
    public static void main(String[]args) throws java.lang.InterruptedException{
      Tetris app = new Tetris();
    }
}