public class gameBoard {

    public gameBoard() {
        chessPieces pieces = new chessPieces(); 

        String[][] board = new String[8][8];
        board[0][0] = pieces.rook(1, 0, 0);
    }
}
