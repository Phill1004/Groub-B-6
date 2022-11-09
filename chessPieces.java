public class chessPieces {
    int color; // 0 is white, 1 is black
    int x, y;
    String name; 

    String pawn(int pieceColor, int positionX, int positionY){
        color = pieceColor;
        x = positionX;
        y = positionY;
        if (pieceColor == 0)
            name = "WPawn";
        else if (pieceColor == 1)
            name = "BPawn";
        
        return name; 
    }
    String rook(int pieceColor, int positionX, int positionY){
        color = pieceColor;
        x = positionX;
        y = positionY;
        if (pieceColor == 0)
            name = "WRook";
        else if (pieceColor == 1)
            name = "BRook";
        
        return name; 
    }
    void knight(int color, int positionX, int positionY){

    }
    void bishop(int color, int positionX, int positionY){

    }
    void queen(int color, int positionX, int positionY){

    }
    void king(int color, int positionX, int positionY){

    }

}
