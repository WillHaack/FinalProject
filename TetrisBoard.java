import java.awt.Color;
import wheels.users.*;

public class TetrisBoard extends Frame{
  
  private Rectangle background;
  private Line v1, v2, v3, v4, v5, v6, v7, v8, v9;
  
  public TetrisBoard(){
    background = new Rectangle(Color.black);
    background.setLocation(235,20);
    background.setSize(230,460);
    v1 = new Line();
    v1.setColor(Color.white);
    v2 = new Line();
    v2.setColor(Color.white);
    v3 = new Line();
    v3.setColor(Color.white);
    v4 = new Line();
    v4.setColor(Color.white);
    v5 = new Line();
    v5.setColor(Color.white);
    v6 = new Line();
    v6.setColor(Color.white);
    v7 = new Line();
    v7.setColor(Color.white);
    v8 = new Line();
    v8.setColor(Color.white);
    v9 = new Line();
    v9.setColor(Color.white);
    v1.setPoints(258,20,258,480);
    v2.setPoints(281,20,281,480);
    v3.setPoints(304,20,304,480);
    v4.setPoints(327,20,327,480);
    v5.setPoints(350,20,350,480);
    v6.setPoints(373,20,373,480);
    v7.setPoints(396,20,396,480);
    v8.setPoints(419,20,419,480);
    v9.setPoints(442,20,442,480);
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
  
  