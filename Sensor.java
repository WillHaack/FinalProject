
import wheels.users.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class Sensor extends Rectangle {

    private Board _board;
    private int _x, _y;
    private int bX, bY;

    public Sensor(Board bor, int x, int y, int a, int b) {
        super(Color.white);
        bX = a; //gives actual xcor
        bY = b; //gives actual ycor
        _x = x; //gives frame xcor
        _y = y; //gives frame ycor
        _board = bor;
        setSize(148, 148);
        setLocation(x + 1, y + 1);
    }

    public void mousePressed(MouseEvent e) {
        setColor(Color.blue);
        _board.makeMove(bX, bY);
        addPiece();
    }

    public void addPiece() {
            if (_board.get(bX, bY) == 1) {
                new Xpiece(_x, _y);
                setColor(Color.blue);
            } else if (_board.get(bX, bY) == 2){
                new Opiece(_x, _y);
                setColor(Color.red);
            }
        }
    
}