public class Board {

    private int[][] gameboard; //0 is empty, 1 is x, 2 is 0
    
    /* new 3 x 3 tictactoe board represented as an int[][] all empty */
    public Board() {
        gameboard = new int[3][3];
    }
    /* @param x = xcor y = ycor n = 1 if x n = 2 if O
     * @return returns whether or not it can move
     */
    public boolean makeMove(int x, int y, int n) {
        if (gameboard[x][y] == 0) {
            gameboard[x][y] = n;
            return true;
        }
        return false;
    }
    /*prints board to screen*/
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
    /* @return true if there is a winner on either diagonal*/
    private boolean diagonalWinner(){
        return ((gameboard[0][0] == gameboard[1][1] && gameboard[1][1] == gameboard[2][2]) || 
                (gameboard[2][0] == gameboard[1][1] && gameboard[1][1] == gameboard[0][2])) &&
                gameboard[1][1] != 0;
    }
    /*@return true if winner on row1*/
    private boolean row1Winner(){
        return gameboard[0][0] == gameboard[0][1] && gameboard[0][1] == gameboard[0][2] && gameboard[0][1] != 0;
    }
    
    /*@return true if winner on row2*/
    private boolean row2Winner(){
        return gameboard[1][0] == gameboard[1][1] && gameboard[1][1] == gameboard[1][2] && gameboard[1][1] != 0;
    }
    /*@return true if winner on row3*/
    private boolean row3Winner(){
        return gameboard[2][0] == gameboard[2][1] && gameboard[2][1] == gameboard[2][2] && gameboard[2][1] != 0;
    }
    
    /*@return true if winner on vert1*/
    private boolean vert1Winner(){
        return gameboard[0][0] == gameboard[1][0] && gameboard[1][0] == gameboard[2][0] && gameboard[1][0] != 0;
    }
    /*@return true if winner on vert2*/
    private boolean vert2Winner(){
        return gameboard[0][1] == gameboard[1][1] && gameboard[1][1] == gameboard[2][1] && gameboard[1][1] != 0;
    }
    /*@return true if winner on vert3*/
    private boolean vert3Winner(){
        return gameboard[0][2] == gameboard[1][2] && gameboard[1][2] == gameboard[2][2] && gameboard[1][2] != 0;
    }
    /*@param x = xcordinate (0, 1, 2) y = ycordinate (0, 1, 2)
     *@return true if spot is empty
     */
    public boolean canMove(int x, int y) {
        return gameboard[x][y] == 0;
    }
    
    public void clearBoard(){
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                gameboard[r][c] = 0;    
            }
        }
    }
}
