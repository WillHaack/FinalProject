import wheels.users.*;
import java.awt.Color;
import java.util.*;
import java.util.ArrayList;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FallDownBoard{
    private int[][] _spaces;
    private ArrayList<String> _patterns;
    private FallBall ball;
    private int _botSpace;
    private boolean hasStart;

    
    //0 is empty, 1 is platform, 2 is ball
    public FallDownBoard(int r, int c){
      hasStart = false;
      _spaces = new int[r][c];
      _botSpace = 0;
      _patterns = new ArrayList<String>();
      _patterns.add("001111111111111");
      _patterns.add("100111111001111");
      _patterns.add("110011100111101");
      _patterns.add("111001111001100");
      _patterns.add("111110001111101");
      _patterns.add("100011111111001");
      _patterns.add("111111100111100");
      _patterns.add("111001110011001");
      _patterns.add("111100110110001");
      _patterns.add("100100011111110");
      _patterns.add("111111111111100");
      _patterns.add("111111001111111");
      _patterns.add("000011111111111");
      _patterns.add("111100111110011");
      _patterns.add("001111101111100");
      ball = new FallBall(1, c/2);
      _spaces[1][c/2] = 2;
    }
    
    //freq is every how many rows there should be a platform, this function fills the board with platforms initially
    public void fillPlats(int freq){
      for(int i = 6; i < _spaces.length; i+= freq){
        int which = (int) (Math.random() * _patterns.size());
        for(int x = 0; x < _spaces[i].length; x++){
          _spaces[i][x] =Integer.parseInt(_patterns.get(which).substring(x, x+1));
        }
      }
    }
    
    public boolean hasStarted(){
      return hasStart;
    }
    
    public boolean start(){
      return !hasStart;
    }
    
    //scrolls the board up a row, and if there have been 2 blank lines updated, it'll add a new platform
    public void moveUpBoard(){
      int[][] update = new int[_spaces.length][_spaces[0].length];
      int whereUpdate = 0;
      ball.setRow(ball.getRow() - 1);
      for(int r = 1; r < _spaces.length; r++){
        for(int c = 0; c < _spaces[0].length; c++){
          update[whereUpdate][c] = _spaces[r][c];
        }
        whereUpdate++;
      }
      _botSpace++;
      if(_botSpace % 3 == 0){
        int which = (int) (Math.random() * _patterns.size());
        for(int x = 0; x < _spaces[0].length; x++){
          update[_spaces.length - 1][x] =Integer.parseInt(_patterns.get(which).substring(x, x+1));
        }
      }
      _spaces = update;
    }
    
    //moves the ball left
    public void moveLeft(){
      if (ball.isLeftOpen(_spaces)){
        _spaces[ball.getRow()][ball.getCol()] = 0;
        ball.setCol(ball.getCol() - 1);
        _spaces[ball.getRow()][ball.getCol()] = 2;
      }
    }
    
    //moves the ball right
    public void moveRight(){
      if (ball.isRightOpen(_spaces)){
        _spaces[ball.getRow()][ball.getCol()] = 0;
        ball.setCol(ball.getCol() + 1);
        _spaces[ball.getRow()][ball.getCol()] = 2;
      }
    }
    
    //moves the ball down
    public void moveDown(){
      if(ball.isFrontOpen(_spaces)){
        _spaces[ball.getRow()][ball.getCol()] = 0;
        ball.setRow(ball.getRow() + 1);
        _spaces[ball.getRow()][ball.getCol()] = 2;
      }
    }
    
    public void printBoard(){
      for(int r = 0; r < _spaces.length; r++){
        for(int c = 0; c < _spaces[r].length; c++)
          System.out.print( _spaces[r][c]);
        System.out.println();
      }
    }
    
    public int[][] getBoard(){
      return _spaces;
    }
    
    public FallBall getBall(){
      return ball;
    }
    
    //Tells whether the ball is still alive
    public boolean isLive(){
      Boolean ans = true;
      if(ball.getRow() == 0 || ball.getRow() == _spaces.length)
        ans = false;
      return ans;
    }
    
    //x, and y are the starting positions, size denotes 1 side of the square pixel
    public void display(int x, int y, int size){
      Rectangle background = new Rectangle(Color.black);
      background.setLocation(210,20);
      background.setSize(270,450); 
      for (int r = 0; r < _spaces.length; r++){
        for(int c = 0; c < _spaces[0].length; c++){
          if(_spaces[r][c] == 1){
            Rectangle plat = new Rectangle(x + size * c,y + size * r);
            plat.setColor(Color.green);
            plat.setSize(size,size);
          }
          else if(_spaces[r][c] == 2){
            Ellipse circ = new Ellipse(x + size * c,y + size * r);
            circ.setSize(size,size);
            circ.setColor(Color.red);
            circ.setFrameColor(Color.black);
          }
        }
      }
    }
    
    public void keyPressed (KeyEvent ke) {
      switch (ke.getKeyCode()){
        case KeyEvent.VK_LEFT:
          moveLeft();
          break;
        case KeyEvent.VK_RIGHT:
          moveRight();
          break;
      }
    }
    
    public static void main(String args[]){
      FallDownBoard q = new FallDownBoard(25,15);
      q.fillPlats(3);
      q.printBoard();
      System.out.println();
      q.moveUpBoard();
      q.printBoard();
      System.out.println();
      q.moveUpBoard();
      q.printBoard();
      System.out.println();
      q.moveUpBoard();
      q.printBoard();
    }
}
    