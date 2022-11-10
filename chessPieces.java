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
    String knight(int pieceColor, int positionX, int positionY){
        color = pieceColor;
        x = positionX;
        y = positionY;
        if (pieceColor == 0)
            name = "WKnight";
        else if (pieceColor == 1)
            name = "BKnight";

        return name;
    }
    String bishop(int pieceColor, int positionX, int positionY){
        color = pieceColor;
        x = positionX;
        y = positionY;
        if (pieceColor == 0)
            name = "WBishop";
        else if (pieceColor == 1)
            name = "BBishop";

        return name;
    }
    String queen(int pieceColor, int positionX, int positionY){
        color = pieceColor;
        x = positionX;
        y = positionY;
        if (pieceColor == 0)
            name = "WQueen";
        else if (pieceColor == 1)
            name = "BQueen";

        return name;
    }
    String king(int pieceColor, int positionX, int positionY){
        color = pieceColor;
        x = positionX;
        y = positionY;
        if (pieceColor == 0)
            name = "WKing";
        else if (pieceColor == 1)
            name = "BKing";

        return name;
    }

}
