import javax.swing.JFrame;

public class FallDown extends JFrame{
  
  public FallDown(){
    add(new FallDownBoard(25,15));
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(270, 450);
    setLocationRelativeTo(null);
    setTitle("Fall Down");
    
    setResizable(false);
    setVisible(true);
  }
  
  public static void main(String[] args){
    new FallDown();
  }
}