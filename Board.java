import wheels.users.*; 
import java.awt.Color;

public class Board {

    private int[][] gameboard; //0 is empty, 1 is x, 2 is 0
    private boolean isXTurn;
    private TicTacToeBot myBot;
    /* new 3 x 3 tictactoe board represented as an int[][] all empty */

    public Board() {
        gameboard = new int[3][3];
        isXTurn = true;
        myBot = new GeniusBot(this, 2);
    }
    
    public void makeBotMove(){
            myBot.makeNextMove();
    }
    
    public int[][] getIntArray(){
        int[][] temp = new int[3][3];
        for (int r = 0; r < 3; r++){
            for (int c = 0 ; c < 3; c++){
                temp[r][c] = gameboard[r][c];
            }
        }
        return temp;
    }
    
    /* @param x = xcor y = ycor n = 1 if x n = 2 if O
     * @return returns whether or not it can move
     */
    public boolean makeMove(int x, int y) {
        if (gameboard[x][y] == 0) {
            if (isXTurn) {
                gameboard[x][y] = 1;
            } else {
                gameboard[x][y] = 2;
            }
            switchTurn();
            return true;
        }
        return false;
    }
    
     /* returns true if the board is  filled*/
    public boolean isFilled(){
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                if (gameboard[r][c] == 0)
                    return false;
            }
        }
        return true;
    }
    
    /*returns true if it's x's turn false if it's o's*/
    public boolean getTurn(){
        return isXTurn;
    }
    
    /* switches turns*/
    public void switchTurn(){
        isXTurn = !isXTurn;
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
     * declares a winner if there is one.
     */

    public void declareWinner() {
        int ans = 0;
        if (diagonalWinner() || row2Winner() || vert2Winner())
            ans = gameboard[1][1];
        else if (row1Winner() || vert1Winner())
            ans = gameboard[0][0];
        else if (row3Winner() || vert3Winner())
            ans = gameboard[2][2];
        if (ans == 1)
            new ConversationBubble("X WINS!");
        else if (ans == 2)
            new ConversationBubble("O WINS!");
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
    /*clears the board*/
    public void clearBoard(){
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                gameboard[r][c] = 0;    
            }
        }
    }
    
    /*
     * @param x = xcor y = ycor
     * @return returns the num at (x,y) 0 if blank 1 if x 2 if O.
     */
    public int get(int x, int y){
        return gameboard[x][y];
    }
    
}
