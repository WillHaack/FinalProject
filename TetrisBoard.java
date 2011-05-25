import java.awt.Color;
import wheels.users.*;

public class TetrisBoard extends Frame{
  
  private Rectangle background;
  
  public TetrisBoard(){
    background = new Rectangle(Color.black);
    background.setLocation(235,20);
    background.setSize(230,460);
    SPiece r = new SPiece(350,204);
    TPiece t = new TPiece(260,210);
    SquarePiece s = new SquarePiece(300,400);
    revSPiece rs = new revSPiece(240,50);
    revLPiece rl = new revLPiece(360,70);
    LinePiece l = new LinePiece(400,300);
    LPiece lp = new LPiece(300,300);
  }
  
  public static void main(String[]args){
    TetrisBoard app = new TetrisBoard();
  }
}
  
  