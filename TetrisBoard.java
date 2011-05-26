import java.awt.Color;
import wheels.users.*;

public class TetrisBoard extends Frame{
  
  private Rectangle background;
  private Line v1, v2, v3, v4, v5, v6, v7, v8, v9, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18, h19;
  
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
    h1 = new Line();
    h1.setColor(Color.white);
    h2 = new Line();
    h2.setColor(Color.white);
    h3 = new Line();
    h3.setColor(Color.white);
    h4 = new Line();
    h4.setColor(Color.white);
    h5 = new Line();
    h5.setColor(Color.white);
    h6 = new Line();
    h6.setColor(Color.white);
    h7 = new Line();
    h7.setColor(Color.white);
    h8 = new Line();
    h8.setColor(Color.white);
    h9 = new Line();
    h9.setColor(Color.white);
    h10 = new Line();
    h10.setColor(Color.white);
    h11 = new Line();
    h11.setColor(Color.white);
    h12 = new Line();
    h12.setColor(Color.white);
    h13 = new Line();
    h13.setColor(Color.white);
    h14 = new Line();
    h14.setColor(Color.white);
    h15 = new Line();
    h15.setColor(Color.white);
    h16 = new Line();
    h16.setColor(Color.white);
    h17 = new Line();
    h17.setColor(Color.white);
    h18 = new Line();
    h18.setColor(Color.white);
    h19 = new Line();
    h19.setColor(Color.white);
    h1.setPoints(235,43,465,43);
    h2.setPoints(235,66,465,66);
    h3.setPoints(235,89,465,89);
    h4.setPoints(235,112,465,112);
    h5.setPoints(235,135,465,135);
    h6.setPoints(235,158,465,158);
    h7.setPoints(235,181,465,181);
    h8.setPoints(235,204,465,204);
    h9.setPoints(235,227,465,227);
    h10.setPoints(235,250,465,250);
    h11.setPoints(235,273,465,273);
    h12.setPoints(235,296,465,296);
    h13.setPoints(235,319,465,319);
    h14.setPoints(235,342,465,342);
    h15.setPoints(235,365,465,365);
    h16.setPoints(235,388,465,388);
    h17.setPoints(235,411,465,411);
    h18.setPoints(235,434,465,434);
    h19.setPoints(235,457,465,457);    
    TetrisDriver x = new TetrisDriver();
    x.addPiece();
    x.print();
    System.out.println();
    //xx.display();
    //Wait.wait(500);
    x.move();
    x.print();
    x.display();
  }
  
  public static void main(String[]args){
    TetrisBoard app = new TetrisBoard();
  }
}
  
  