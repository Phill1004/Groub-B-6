public class gameBoard {
    String[][] board = new String[8][8];

    gameBoard() {
        chessPieces pieces = new chessPieces();

        //sets black pieces
        board[0][0] = pieces.rook(1, 0, 0);
        board[0][1] = pieces.knight(1, 0, 1);
        board[0][2] = pieces.bishop(1, 0, 2);
        board[0][3] = pieces.queen(1, 0, 3);
        board[0][4] = pieces.king(1, 0, 4);
        board[0][5] = pieces.bishop(1, 0, 5);
        board[0][6] = pieces.knight(1, 0, 6);
        board[0][7] = pieces.rook(1, 0, 7);
        for(int i = 0; i < 8; i++){
            board[1][i] = pieces.pawn(1, 1, i);
        }
        //sets white pieces
        board[7][0] = pieces.rook(0, 7, 0);
        board[7][1] = pieces.knight(0, 7, 1);
        board[7][2] = pieces.bishop(0, 7, 2);
        board[7][3] = pieces.queen(0, 7, 3);
        board[7][4] = pieces.king(0, 7, 4);
        board[7][5] = pieces.bishop(0, 7, 5);
        board[7][6] = pieces.knight(0, 7, 6);
        board[7][7] = pieces.rook(0, 7, 7);
        for(int i = 0; i < 8; i++){
            board[6][i] = pieces.pawn(0, 6, i);
        }
        //sets empty spaces
        for(int row = 2; row < 6; row++){
            for(int col = 0; col < 8; col++){
                board[row][col] = " ";
            }
        }

    }

    void printBoard(){
        for(int row = 0; row < 8; row++){
            System.out.println();
            for(int col = 0; col < 8; col++){
                System.out.print(board[row][col]);
            }
        }
    }

    String[][] getBoard(){

        return board;
    }
}
