public class ChessNode {
    private ChessPiece myPiece;
    private boolean isEmpty;
    private String myColor;
    private ChessBoard myBoard;
    public ChessNode(ChessBoard newBoard, String newColor){
        myBoard = newBoard;
        myColor = newColor;
        myPiece = null;
        isEmpty = false;
    }
    
    private ChessPiece getPiece(){
        return myPiece;
    }
    
    private void setPiece(ChessPiece newPiece){
        myPiece = newPiece;
    }
    
    
}
