public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameBoard mygame = new GameBoard();
        DumbBot myBot = new DumbBot(mygame.getBoard(), 2, mygame);
     for (int i = 0; i < 8; i++)
         myBot.makeNextMove();
    }
}
