public abstract class ChessPiece{
    private ChessNode myNode;
    private boolean isWhite;
    private int xcor, ycor;


    public ChessPiece(ChessBoard infoBoard, boolean isWhite, int xcor, int ycor){
	this.myNode = infoBoard;
	this.isWhite = isWhite;
	this.xcor = xcor;
	this.ycor = ycor;
    }


    public void removeSelfFromGame(){
	myNode.remove();
    }


    public boolean isWhite(){
	return isWhite;
    }


    public int getxcor(){
	return xcor;
    }


    public int getycor(){
	return ycor;
    }


    public boolean abstract move(int xcor, int ycor);
    public int abstract getValue();
}