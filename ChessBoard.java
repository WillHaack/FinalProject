public class ChessBoard {
    
    private ChessNode[][] my_board;


    public ChessBoard(){
	newGame();
    }
    
    public void newGame(){
        my_board = new ChessNode[8][8];
        for (int r = 0; r < 8; r++){
            for (int c = 0; c < 8; c++){
                my_board[r][c] = new ChessNode();
            }
        }
        newGameBlack(); //sets up black pieces
        newGameWhite(); //sets up white pieces
    }
    //Sets up the top portion of the board (rows 0 and 1) to black pieces.
    private newGameBlack(){
        my_board[0][0] = my_board[0][8] = new Rook(black);
        my_board[0][1] = my_board[0][7] = new Knight(black);
        my_board[0][2] = my_board[0][6] = new Bishop(black);
        my_board[0][3] = new 
    }


}