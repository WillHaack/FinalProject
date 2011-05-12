import wheels.users.*; 
import java.awt.Color;

public class Xpiece implements gamepiece{
  
  private Line first, second;
  
  public Xpiece(int x, int y){
    first = new Line();
    second = new Line();
    first.setThickness(2);
    second.setThickness(2);
    first.setColor(Color.black);
    second.setColor(Color.black);
    first.setPoints(x+10,y+10,x+140,y+140);
    second.setPoints(x+140,y+10,x+10,y+140);
  }
}