import wheels.users.*;
import java.awt.Color;

public class Connect4Board {

    private int[][] grid; //0 is empty, 1 is x, 2 is 0
    private boolean isRedTurn;
    private Connect4Bot myBot;
    /* new 3 x 3 tictactoe board represented as an int[][] all empty */

    public Connect4Board() {
        grid = new int[6][7];
        isRedTurn = true;
        Connect4Bot = new GeniusBot(this, 2);
    }
    
    public void makeBotMove(){
	myBot.makeNextMove();
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
    public boolean makeMove(int x, int y) {
        if (gameboard[x][y] == 0) {
            if (isRedTurn) {
                grid[x][y] = 1;
            } else {
                grid[x][y] = 2;
            }
            switchTurn();
            return true;
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
    
    /*returns true if it's Red's turn false if it's Yellow's*/
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
                    System.out.print(" ");
                } else if (grid[r][c] == 1) {
                    System.out.print("Red ");
                } else {
                    System.out.print("Yellow ");
                }
            }
            System.out.println();
        }
    }
   
    public boolean hasWinner(){
	boolean status = false;
	// check for a horizontal win
	for (int row=0; row<6; row++) {
	    for (int column=0; column<4; column++) {
		if (grid[column][row] != 0 &&
		    grid[column][row] == grid[column+1][row] &&
		    grid[column][row] == grid[column+2][row] &&
		    grid[column][row] == grid[column+3][row]) {
		    status = true;
		}
	    }
	}
	// check for a vertical win
	for (int row=0; row<3; row++) {
	    for (int column=0; column<7; column++) {
		if (grid[column][row] != 0 &&
		    grid[column][row] == grid[column][row+1] &&
		    grid[column][row] == grid[column][row+2] &&
		    grid[column][row] == grid[column][row+3]) {
		    status = true;
		}
	    }
	}
	// check for a diagonal win (positive slope)
	for (int row=0; row<3; row++) {
	    for (int column=0; column<4; column++) {
		if (grid[column][row] != 0 &&
		    grid[column][row] == grid[column+1][row+1] &&
		    grid[column][row] == grid[column+2][row+2] &&
		    grid[column][row] == grid[column+3][row+3]) {
		    status = true;
		}
	    }
	}
	// check for a diagonal win (negative slope)
	for (int row=3; row<6; row++) {
	    for (int column=0; column<4; column++) {
		if (grid[column][row] != 0 &&
		    grid[column][row] == grid[column+1][row-1] &&
		    grid[column][row] == grid[column+2][row-2] &&
		    grid[column][row] == grid[column+3][row-3]) {
		    status = true;
		}
	    }
	}


	/*@param x = xcordinate (0, 1, 2) y = ycordinate (0, 1, 2)
	 *@return true if spot is empty
	 */
	public boolean canMove(int x, int y) {
	    return grid[x][y] == 0;
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
    
    }

