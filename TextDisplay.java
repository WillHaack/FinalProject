import wheels.users.*;
import java.awt.Color;

public class TextDisplay extends ConversationBubble{
  
  public TextDisplay(String text){
    super(text);
    super.setWidth(103);
    super.setColor(Color.white);
  }
}