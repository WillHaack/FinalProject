/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Will
 */
public class Board {

    private int[][] gameboard; //0 is empty, 1 is x, 2 is 0

    public Board() {
        gameboard = new int[3][3];
    }

    public boolean makeMove(int x, int y, int n) {
        if (gameboard[x][y] == 0) {
            gameboard[x][y] = n;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (gameboard[r][c] == 0) {
                    System.out.print("  ");
                } else if (gameboard[r][c] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
    /*
     * @return 0 if no winner 1 if x is winner 2 if O is winner
     */

    public int declareWinner() {
        int ans = 0;
        if (diagonalWinner() || row2Winner() || vert2Winner())
            ans = gameboard[1][1];
        else if (row1Winner() || vert1Winner())
            ans = gameboard[0][0];
        else if (row3Winner() || vert3Winner())
            ans = gameboard[2][2];
        return ans;
    }
    
    private boolean diagonalWinner(){
        return ((gameboard[0][0] == gameboard[1][1] && gameboard[1][1] == gameboard[2][2]) || 
                (gameboard[2][0] == gameboard[1][1] && gameboard[1][1] == gameboard[0][2])) &&
                gameboard[1][1] != 0;
    }
    
    private boolean row1Winner(){
        return gameboard[0][0] == gameboard[0][1] && gameboard[0][1] == gameboard[0][2] && gameboard[0][1] != 0;
    }
    
    private boolean row2Winner(){
        return gameboard[1][0] == gameboard[1][1] && gameboard[1][1] == gameboard[1][2] && gameboard[1][1] != 0;
    }
    
    private boolean row3Winner(){
        return gameboard[2][0] == gameboard[2][1] && gameboard[2][1] == gameboard[2][2] && gameboard[2][1] != 0;
    }
    
    private boolean vert1Winner(){
        return gameboard[0][0] == gameboard[1][0] && gameboard[1][0] == gameboard[2][0] && gameboard[1][0] != 0;
    }
    
    private boolean vert2Winner(){
        return gameboard[0][1] == gameboard[1][1] && gameboard[1][1] == gameboard[2][1] && gameboard[1][1] != 0;
    }
    private boolean vert3Winner(){
        return gameboard[0][2] == gameboard[1][2] && gameboard[1][2] == gameboard[2][2] && gameboard[1][2] != 0;
    }

    public boolean canMove(int x, int y) {
        return gameboard[x][y] == 0;
    }
}
