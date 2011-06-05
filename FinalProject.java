import wheels.users.*;

public class FinalProject extends Frame{
  
  public FinalProject(){
    TextDisplay tet = new TextDisplay("Tetris");
    tet.setLocation(0,0);
    TextDisplay tic = new TextDisplay("TicTacToe");
    tic.setLocation(150,0);
    TextDisplay con4 = new TextDisplay("Connect4");
    con4.setLocation(340,0);
    TextDisplay bship = new TextDisplay("BattleShip");
    bship.setLocation(530,0);
    TextDisplay bubble = new TextDisplay("BubblePop");
    bship.setLocation(0,250);
    TextDisplay fall = new TextDisplay("FallDown");
    fall.setLocation(150,250);
    TextDisplay khet = new TextDisplay("Khet");
    khet.setLocation(340,250);
    TextDisplay poke = new TextDisplay("Pok?mon");
    poke.setLocation(530,250);
    TetrisButton tetris = new TetrisButton(10,50);
    TicTacToeButton tictac = new TicTacToeButton(160,50);
    FallDownButton falldown = new FallDownButton(150,300);
  }

    public static void main(String[] args) {
      FinalProject app = new FinalProject();
    }
    
}