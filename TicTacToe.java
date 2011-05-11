/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Will
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board gameboard = new Board();
        gameboard.makeMove(2, 1, 1);
        gameboard.makeMove(1, 1, 1);
        gameboard.makeMove(0, 1, 1);
        gameboard.printBoard();// TODO code application logic here
    }
}
