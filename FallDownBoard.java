import java.awt.Color;
import java.util.*;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FallDownBoard extends JPanel implements ActionListener{
    private int[][] _spaces;
    private ArrayList<String> _patterns;
    private FallBall ball;
    private int _botSpace, score, tick, moveFactor;
    private boolean hasStart, displayGameOver;

    private Image player;
    private Image platform;
    private Image clear;
    private Image splash;
    private Timer t;    
    
    //0 is empty, 1 is platform, 2 is ball
    public FallDownBoard(int r, int c){
      addKeyListener(new TAdapter());
      ImageIcon iib = new ImageIcon(this.getClass().getResource("ball.png"));
      player = iib.getImage();
      ImageIcon iip = new ImageIcon(this.getClass().getResource("platform.png"));
      platform = iip.getImage();
      ImageIcon iic = new ImageIcon(this.getClass().getResource("clear.png"));
      clear = iic.getImage();
      ImageIcon iis = new ImageIcon(this.getClass().getResource("splashscreen.png"));
      splash = iis.getImage();
      setBackground(Color.black);
      setFocusable(true);
      t = new Timer(100, this);
      score = 0;
      tick = 0;
      moveFactor = 0;
      hasStart = false;
      displayGameOver = false;
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
      fillPlats(3);
      ball = new FallBall(1, c/2);
      _spaces[1][c/2] = 2;
      t.start();
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
    
    //moves the ball
    public void tryMove(){
      if(moveFactor == -1){
        if (ball.isLeftOpen(_spaces)){
          _spaces[ball.getRow()][ball.getCol()] = 0;
          ball.setCol(ball.getCol() - 1);
          _spaces[ball.getRow()][ball.getCol()] = 2;
          moveFactor = 0;
          repaint();
        }
      }
      else if(moveFactor == 1){
        if (ball.isRightOpen(_spaces)){
          _spaces[ball.getRow()][ball.getCol()] = 0;
          ball.setCol(ball.getCol() + 1);
          _spaces[ball.getRow()][ball.getCol()] = 2;
          moveFactor = 0;
          repaint();
        }
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
    
    //Tells whether the ball is still alive
    public boolean isLive(){
      Boolean ans = true;
      if(ball.getRow() == 0 || ball.getRow() == _spaces.length)
        ans = false;
      return ans;
    }
    
    //x, and y are the starting positions, size denotes 1 side of the square pixel
    public void paint(Graphics g){
      super.paint(g);
      g.drawImage(clear, 0, 0, this);
      if(hasStart){
        for (int r = 0; r < _spaces.length; r++){
          for(int c = 0; c < _spaces[0].length; c++){
            if(_spaces[r][c] == 1){
              g.drawImage(platform, c * 18, r * 18, this);
            }
            else if(_spaces[r][c] == 2){
              g.drawImage(player, c * 18, r * 18, this);
            }
          }
        }
      }
      else if(displayGameOver == true){
        gameOver(g);
      }
      else{
        intro(g);
      }
    }
    
    public void intro(Graphics g){
      g.drawImage(splash, 0, 0, this);
    }
    
    public void gameOver(Graphics g){
      g.drawImage(clear, 0, 0, this);
      String msg = "GAME OVER: Your score was: " + score;
      Font small = new Font("Helvetica", Font.BOLD, 14);
      FontMetrics metr = this.getFontMetrics(small);
      g.setColor(Color.white);
      g.setFont(small);
      g.drawString(msg, (270 - metr.stringWidth(msg)) / 2, 225);
    }
      
    public void actionPerformed(ActionEvent arg0){
      if (ball.getRow() == 0 || ball.getRow() == _spaces.length - 1){
        hasStart = false;
        displayGameOver = true;
        repaint();
        t.stop();
      }
      if(hasStart){
        tick++;
        score++;
        if(tick % 5 == 0){
          tryMove();
          moveUpBoard();
          moveDown();
          repaint();
        }
        else{
          tryMove();
          moveDown();
          repaint();
        }
      }
    }
    
    private class TAdapter extends KeyAdapter{
      public void keyPressed(KeyEvent e){
        int keycode = e.getKeyCode();
        if(hasStart == false){
          if(keycode == KeyEvent.VK_LEFT)
            hasStart = true;
          if(keycode == KeyEvent.VK_RIGHT)
            hasStart = true;
        }
        if(keycode == KeyEvent.VK_LEFT)
          moveFactor = -1;
        if(keycode == KeyEvent.VK_RIGHT)
          moveFactor = 1;
        }
      }
    
    
}