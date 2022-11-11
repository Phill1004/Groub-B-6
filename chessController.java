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
        
    	String FromPieceName = theGameBoard[FromRow-1][FromColumn-1];
    	String ToPieceName = theGameBoard[ToRow-1][ToColumn-1];
    	
    	System.out.println(FromPieceName +" From " + FromColumn + " " + FromRow);
    	System.out.println(" To " + ToColumn + " " + ToRow + " "+ ToPieceName);
    	
    	//If the input or output row and column are out of bounds then return false
    	if(FromColumn > 8 || FromColumn < 1 || ToColumn > 8 || ToColumn < 1 ||
    			FromRow > 8 || FromRow <1 || ToRow > 8 || ToRow < 1)
    		return false;
    	else if(ToPieceName == "") { // if the space is empty then its valid
    		return true;
    	}
    	else if(FromPieceName == "") {// checks to see if you picked a piece to move
    		return false;
    	}
    	
    	switch(FromPieceName) { // switch case to check movement based on piece name
    	case "BPawn":
    		if(ToColumn > FromColumn || ToColumn < FromColumn) { // checks to see if the pawn is switching columns
    			return false;
    		}else if(ToRow < FromRow) { // checks to see if the pawn is moving backwards (Black side)
    			return false;
    		}
    		else
    			return true;
    	case "WPawn":
    		if(ToColumn > FromColumn || ToColumn < FromColumn) { // checks to see if the pawn is switching columns
    			return false;
    		}else if(ToRow > FromRow) { // checks to see if the pawn is moving backwards (White side)
    			return false;
    		}
    		else
    			return true;
    	case "BRook":
    		break;
    	case "WRook":
    		break;
    	case "BKnight":
    		break;
    	case "WKnight":
    		break;
    	case "BBishop":
    		break;
    	case "WBishop":
    		break;
    	case "BQueen":
    		break;
    	case "WQueen":
    		break;
    	case "BKing":
    		break;
    	case "WKing":
    		break;
    	}
    	
    	
        return false;
    }
}
