import wheels.users.*;
import java.awt.Color;

public class Connect4Board {

    private int[][] grid; //0 is empty, 1 is x, 2 is 0
    private boolean isRedTurn;
    private Connect4GeniusBot myBot;
    /* new 3 x 3 tictactoe board represented as an int[][] all empty */

    public Connect4Board() {
        grid = new int[6][7];
        isRedTurn = true;
        myBot = new Connect4GeniusBot(this, 2);
    }
    
    public void makeBotMove(){
	myBot.makeMove();
    }
    
    
    
    public int[][] getIntArray(){
        int[][] temp = new int[6][7];
        for (int r = 0; r < 6; r++){
            for (int c = 0 ; c < 7; c++){
                temp[r][c] = grid[r][c];
            }
        }
        return temp;
    }
    
    /* @param x = xcor y = ycor n = 1 if x n = 2 if O
     * @return returns whether or not it can move
     */
    
    public boolean makeMove(int col) {
        for (int i = 5; i >= 0; i--) {
            if (grid[i][col] == 0) {
                if (isRedTurn) {
                    grid[i][col] = 1;
                } else {
                    grid[i][col] = 2;
                }
                switchTurn();
                return true;
            }
        }
            return false;
    }
    /* returns true if the board is filled*/
    public boolean isFilled(){
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < 7; c++){
                if (grid[r][c] == 0)
                    return false;
            }
        }
        return true;
    }
    
 
    public boolean getTurn(){
        return isRedTurn;
    }
    
    /* switches turns*/
    public void switchTurn(){
        isRedTurn = !isRedTurn;
    }
    /*prints board to screen*/
    public void printBoard() {
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                if (grid[r][c] == 0) {
                    System.out.print("e");
                } else if (grid[r][c] == 1) {
                    System.out.print("r");
                } else if (grid[r][c] == 2){
                    System.out.print("y");
                }
                else {
                    System.out.print("q");
                }
            }
            System.out.println();
        }
    }
   
    public boolean isWinner(int team){
	boolean ans = false;
	// check for a horizontal win
	for (int r=0; r<6; r++) {
	    for (int c=0; c<4; c++) {
		if (grid[r][c] == team &&
		    grid[r][c] == grid[r][c+1] &&
		    grid[r][c] == grid[r][c+2] &&
		    grid[r][c] == grid[r][c+3]) {
		    ans = true;
		}
	    }
	}
	// check for a vertical win
	for (int r=0; r<3; r++) {
	    for (int c=0; c<7; c++) {
		if (grid[r][c] == team &&
		    grid[r][c] == grid[r + 1][c] &&
		    grid[r][c] == grid[r + 2][c] &&
		    grid[r][c] == grid[r + 3][c]) {
		    ans = true;
		}
	    }
	}
	// check for a diagonal win (positive slope)
	for (int r=0; r<3; r++) {
	    for (int c=0; c<4; c++) {
		if (grid[r][c] == team &&
		    grid[r][c] == grid[r+1][c+1] &&
		    grid[r][c] == grid[r+2][c+2] &&
		    grid[r][c] == grid[r+3][c+3]) {
		    ans = true;
		}
	    }
	}
	// check for a diagonal win (negative slope)
	for (int r=3; r<6; r++) {
	    for (int c=0; c<4; c++) {
		if (grid[r][c] == team &&
		    grid[r][c] == grid[r-1][c+1] &&
		    grid[r][c] == grid[r-2][c+2] &&
		    grid[r][c] == grid[r-3][c+3]) {
		    ans = true;
		}
	    }
        }
            return ans;
    }

	public boolean canMove(int c) {
	    return grid[0][c] == 0;
	}
        
        
	/*clears the board*/
	public void clearBoard(){
	    for (int r = 0; r < 3; r++){
		for (int c = 0; c < 3; c++){
		    grid[r][c] = 0;
		}
	    }
	}
    
	/*
	 * @param x = xcor y = ycor
	 * @return returns the num at (x,y) 0 if blank 1 if x 2 if O.
	 */
	public int get(int x, int y){
	    return grid[x][y];
	}
        
        public void setMove(int x, int y, int team){
            grid[x][y] = team;
        }
        
        public static void main(String[] args){
            Connect4Board app = new Connect4Board();
            app.makeBotMove();
            app.printBoard();
        }
    
    }

