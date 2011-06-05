import java.util.*;
import wheels.users.*;

public class Connect4GeniusBot {
    private Connect4Board infoBoard;
    private int next_move, team;
    
    public Connect4GeniusBot(Connect4Board infoBoard, int team){
        this.infoBoard = infoBoard;
        this.team = team;
    }
    
    public void makeMove() {
        if (!infoBoard.isFilled()) {
            infoBoard.makeMove(this.getBestPossibleMove());
        }
    }
    
    private int[] getPossibleMoves(int[][] tempBoard){
        int size = 0;
        for (int c = 0; c < 7; c++){
            if (canMove(c, tempBoard))
                size++;
        }
        int[] ans = new int[size];
        int index = 0;
        for (int c = 0; c < 7; c++){
            if (canMove(c, tempBoard)){
                ans[index++] = c;
            }
        }
        return ans;
    }
    
    public boolean canMove(int c, int[][] tempBoard){
        return tempBoard[0][c] == 0;
    }
    
    public void printBoard(int[][] grid) {
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
        System.out.println();
    }
    
    private int getBestPossibleMove(){
        int[] next_possible_moves = getPossibleMoves(infoBoard.getIntArray());
        int[][] tempInfoBoard = infoBoard.getIntArray();
        int ans = -1;
        int highest_val = -1001;
        for (int c : next_possible_moves){
            this.makeMove(c, tempInfoBoard, team);
            if (this.isWinner(tempInfoBoard, team)){
                return c;              
            }
            int tempAns = getBestMoveHelper((team % 2) + 1, tempInfoBoard);
            if (tempAns > highest_val){
                ans = c;
                highest_val = tempAns;
            }
            this.makeMove(c, tempInfoBoard, 0);
        }
        return ans;
    }
    
    public boolean isWinner(int[][] grid, int team){
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
     
    public boolean makeMove(int col, int[][] grid, int team) {
        if (team == 0){
            for (int i = 0; i < 6; i++){
                if (grid[i][col] != 0){
                    grid[i][col] = 0;
                    return true;
            }
        }
        }
        
        for (int i = 5; i >= 0; i--) {
            if (grid[i][col] == 0) {
                grid[i][col] = team;
                return true;
            }
        }
            return false;
    }
    
    private int getBestMoveHelper(int player, int[][] tempBoard){
        int[] next_possible_moves = getPossibleMoves(tempBoard);
	if (next_possible_moves.length == 0)
            return 0;
        int bestValue = -1000;
        int other_player = (player % 2) + 1;
        for (int col : next_possible_moves){
            makeMove(col, tempBoard, player);
            if (isWinner(tempBoard, player)){
                makeMove(col, tempBoard, 0);
                return 1000;
            }
            bestValue = Math.max(bestValue, -getBestMoveHelper(other_player, tempBoard));
            makeMove(col, tempBoard, 0);
            if (bestValue == 1000)
                break;
        } 
        return bestValue;
    }
}
