import wheels.users.*; 
import java.awt.Color;

public class TicTacOpiece implements gamepiece{
  
  private Ellipse piece;
  
  public TicTacOpiece(int x, int y){
    piece = new Ellipse(Color.white);
    piece.setFrameThickness(2);
    piece.setFrameColor(Color.black);
    piece.setSize(130,130);
    piece.setLocation(x+10,y+10);
  }
  
  
}