public class chessController {
	
	String[][] board;
	
    //Idea is user will be prompted to pick a piece to move and we will take in the xy value
    //then user will input where they want to go and put in another xy value.
    //take these values and check if its possible.
    //the integer.parseint stuff just gives us the first number and second number so we can put in th array
    //to find the spot.
	public chessController(String[][] b) {
		this.board = b;
	}
    boolean validMove(String[][] theGameBoard, int FromColumn, int FromRow, int ToColumn, int ToRow, String theUserColor){
    	
    	//If the input or output row and column are out of bounds then return false
    	if(FromColumn > 8 || FromColumn < 1 || ToColumn > 8 || ToColumn < 1 ||
    			FromRow > 8 || FromRow <1 || ToRow > 8 || ToRow < 1) {
    		System.out.println("Out of Bounds !!");
    		return false;
    	}else if(FromColumn == ToColumn && FromRow == ToRow) // check if the same values are entered for to and from coordinates
    		return false;
    	
    	String FromPieceName = theGameBoard[FromRow-1][FromColumn-1];
    	String ToPieceName = theGameBoard[ToRow-1][ToColumn-1];
    	
    	if(FromPieceName == "") {// checks to see if you picked a piece to move
    		return false;
    	}
    	
    	System.out.println(FromPieceName +" From " + FromColumn + " " + FromRow);
    	System.out.println("       To " + ToColumn + " " + ToRow + " "+ ToPieceName);
    	
    	//System.out.println(FromRow - ToRow);
    	switch(FromPieceName) { // switch case to check movement based on piece name
    	case "BPawn": // CASE FOR BLACK PAWN MOVING
    		int MoveDistance = 1; // move distance of pawn
    		if(FromRow == 1) {
    			MoveDistance = 2;
    		}
    		if(ToColumn > FromColumn || ToColumn < FromColumn) { // checks to see if the pawn is switching columns
    			return false;
    		}else if(ToRow < FromRow) { // checks to see if the pawn is moving backwards (Black side)
    			return false;
    		}else if((ToRow - FromRow) > MoveDistance) { // checks to see if the pawn is moving greater than it should be
    			return false;
    		}
    		else
    			return true;
    	case "WPawn": // CASE FOR WHITE PAWN MOVING
    		MoveDistance = 1; // move distance of pawn
    		if(FromRow == 1) {
    			MoveDistance = 2;
    		}
    		if(ToColumn > FromColumn || ToColumn < FromColumn) { // checks to see if the pawn is switching columns
    			return false;
    		}else if(ToRow > FromRow) { // checks to see if the pawn is moving backwards (White side)
    			return false;
    		}else if((FromRow - ToRow) > MoveDistance) { // checks to see if the pawn is moving greater than it should be
    			return false;
    		}
    		else
    			return true;
    	case "BRook":
    		return RookValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "WRook":
    		return RookValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "BKnight":
    		return KnightValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "WKnight":
    		return KnightValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "BBishop":
    		return BishopValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "WBishop":
    		return BishopValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "BQueen":
    		return QueenValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "WQueen":
    		return QueenValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "BKing":
    		return KingValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "WKing":
    		return KingValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	}
    	
    	
        return false;
    }
    // METHOD FOR VALIDATING A ROOKS MOVE
    public Boolean RookValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow) { 
    	if(ToRow != FromRow && ToColumn != FromColumn) { // check to see if the rook is trying to move on both row and column
			return false;
		}
		if(ToRow != FromRow) { // check if rook is moving left on rows
			if(FromRow < ToRow) { // ROOK INCREASING ROW
				for(int i = FromRow+1; i < ToRow+1; i++) { //loop through and check if any pieces are in the way of rooks path 
					System.out.println(theGameBoard[i-1][FromColumn-1] + " Is in the way at " +FromColumn + " " +i);
					if(theGameBoard[i-1][FromColumn-1] != "" ) {
						return false;
					}
				}	
    		}else { // ROOK DECREASING ROW
    			for(int i = FromRow-1; i > ToRow-1; i--) { //loop through and check if any pieces are in the way of rooks path 
					System.out.println(theGameBoard[i-1][FromColumn-1] + " Is in the way at " +FromColumn + " " +i);
					if(theGameBoard[i-1][FromColumn-1] != "" ) {
						return false;
					}
				}
    		}
			
			return true;
		}
		else if(ToColumn != FromColumn) { // checks for pieces if rook is moving right
			if(FromColumn < ToColumn) { // ROOK INCREASING COLUMN
				for(int i = FromColumn+1; i < ToColumn+1; i++) { //loop through and check if any pieces are in the way of rooks path 
    				System.out.println(theGameBoard[FromRow-1][i-1] + " Is in the way at " + i + " " +FromRow);
    				if(theGameBoard[FromRow-1][i-1] != "" ) {
    					return false;
    				}
    			}
			}else { // ROOK DECREASING COLUMN
				for(int i = FromColumn-1; i > ToColumn-1; i--) { //loop through and check if any pieces are in the way of rooks path 
					System.out.println(theGameBoard[FromRow-1][i-1] + " Is in the way at " + i + " " + FromRow);
    				if(theGameBoard[FromRow-1][i-1] != "" ) {
    					return false;
    				}
    			}
			}
			return true;
		}
    	
    	return false;
    }
    // METHOD FOR VALIDATING A BISHOPS MOVE
    public boolean BishopValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow) { 
    	System.out.println("Not Done Yet");
    	return false;
    }
    // METHOD FOR VALIDATING A QUEENS MOVE
    public boolean QueenValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow) {
    	System.out.println("Not Done Yet");
    	return false;
    }
    // METHOD FOR VALIDATING A KINGS MOVE
    public boolean KingValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow) {
    	System.out.println("Not Done Yet");
    	return false;
    }
    // METHOD FOR VALIDATING A KNIGHTS MOVE
    public boolean KnightValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow) {
    	System.out.println("Not Done Yet");
    	return false;
    }
}
