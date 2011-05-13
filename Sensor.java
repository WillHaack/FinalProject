
import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Sensor extends Rectangle {

    private Board _board;
    private int _x, _y;
    private int bX, bY;
    private GameBoard displayBoard;

    public Sensor(Board bor, int x, int y, int a, int b, GameBoard display) {
        super(Color.white);
        displayBoard = display;
        bX = a; //gives infoboard xcor
        bY = b; //gives infoboard ycor
        _x = x; //gives frame xcor
        _y = y; //gives frame ycor
        _board = bor;
        setSize(148, 148);
        setLocation(x + 1, y + 1);
    }

    public void mousePressed(MouseEvent e) {
        if (_board.canMove(bX, bY)){
        _board.makeMove(bX, bY);
        _board.declareWinner();
        _board.makeBotMove();
        _board.declareWinner();
        displayBoard.display();
        }
    }

    public void addPiece() {
            if (_board.get(bX, bY) == 1) {
                new Xpiece(_x, _y);
            } else if (_board.get(bX, bY) == 2){
                new Opiece(_x, _y);
            }
        }
}