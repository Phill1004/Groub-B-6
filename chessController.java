import java.util.ArrayList;

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
    	
    	
    	String OtherColor = "White"; // variable for storing the Enemy piece color
    	if(theUserColor.equals("White"))
    		OtherColor = "Black";
    	
    	//System.out.println(OtherColor);
    	
    	
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
    	
    	if(FromPieceName.charAt(0) != theUserColor.charAt(0)) {
    		return false; // if the piece being moved is not the users then return false
    	}
    	
    	
    	
    	System.out.println(FromPieceName +" From " + FromColumn + " " + FromRow);
    	System.out.println("       To " + ToColumn + " " + ToRow + " "+ ToPieceName);
    	
    	boolean taking = false;
    	
    	//System.out.println(FromRow - ToRow);
    	switch(FromPieceName) { // switch case to check movement based on piece name
    	case "BPawn": // CASE FOR BLACK PAWN MOVING
    		int MoveDistance = 1; // move distance of pawn
    		if(FromRow == 2) {
    			MoveDistance = 2;
    		}
    		if(ToRow - FromRow == 1 && Math.abs(FromColumn - ToColumn) == 1) {//black pawn trying to capture
    			if(ToPieceName.charAt(0) == OtherColor.charAt(0)) {
    				taking = true;
    			}
    		}
    		if(taking) {
    			taking = false;
    			return true;
    		}else if(ToColumn > FromColumn || ToColumn < FromColumn) { // checks to see if the pawn is switching columns
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
    		if(FromRow == 7) {
    			MoveDistance = 2;
    		}
    		if(FromRow - ToRow == 1 && Math.abs(FromColumn - ToColumn) == 1) {//white pawn trying to capture
    			if(ToPieceName.charAt(0) == OtherColor.charAt(0)) {
    				taking = true;
    			}
    		}
    		if(taking) {
    			taking = false;
    			return true;
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
    		return RookValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow, theUserColor, OtherColor);
    	case "WRook":
    		return RookValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow, theUserColor, OtherColor);
    	case "BKnight":
    		return KnightValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "WKnight":
    		return KnightValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow);
    	case "BBishop":
    		return BishopValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow, theUserColor, OtherColor);
    	case "WBishop":
    		return BishopValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow, theUserColor, OtherColor);
    	case "BQueen":
    		return QueenValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow, theUserColor, OtherColor);
    	case "WQueen":
    		return QueenValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow, theUserColor, OtherColor);
    	case "BKing":
    		return KingValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow, theUserColor, OtherColor);
    	case "WKing":
    		return KingValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow, theUserColor, OtherColor);
    	}
    	
    	
        return false;
    }
    // METHOD FOR VALIDATING A ROOKS MOVE
    public Boolean RookValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow, String UserColor, String OtherColor) {
    	ArrayList<String> path = new ArrayList<String>(); // stores the path that the rook takes
    	path.clear();
    	if(ToRow != FromRow && ToColumn != FromColumn) { // check to see if the rook is trying to move on both row and column
			return false;
		}
		if(ToRow != FromRow) { // check if rook is moving left on rows
			if(FromRow < ToRow) { // ROOK INCREASING ROW
				for(int i = FromRow+1; i < ToRow+1; i++) { //loop through and check if any pieces are in the way of rooks path
					path.add(theGameBoard[i-1][FromColumn-1]);
					//System.out.println(theGameBoard[i-1][FromColumn-1] + " Is at " +FromColumn + " " +i);
				}	
    		}else { // ROOK DECREASING ROW
    			for(int i = FromRow-1; i > ToRow-1; i--) { //loop through and check if any pieces are in the way of rooks path 
    				path.add(theGameBoard[i-1][FromColumn-1]);
					//System.out.println(theGameBoard[i-1][FromColumn-1] + " Is at " +FromColumn + " " +i);
				}
    		}
			int end = path.size()-1;
			for(int i=0; i < path.size(); i++) {// loops through the path to see if there is a valid move or not
				System.out.println("Path "+ i +" "+ path.get(i));
				if(path.get(i) == "") {
					continue;
				}else if(path.get(i).charAt(0) == UserColor.charAt(0) && i != end) {
					return false;
				}else if(path.get(i).charAt(0) == OtherColor.charAt(0) && i == end) {
					return true;
				}else
					return false;
					
			}
			return true;
		}
		else if(ToColumn != FromColumn) { // checks for pieces if rook is moving right
			if(FromColumn < ToColumn) { // ROOK INCREASING COLUMN
				for(int i = FromColumn+1; i < ToColumn+1; i++) { //loop through and check if any pieces are in the way of rooks path
					path.add(theGameBoard[FromRow-1][i-1]);
    				//System.out.println(theGameBoard[FromRow-1][i-1] + " Is at " + i + " " +FromRow);
    			}
			}else { // ROOK DECREASING COLUMN
				for(int i = FromColumn-1; i > ToColumn-1; i--) { //loop through and check if any pieces are in the way of rooks path
					path.add(theGameBoard[FromRow-1][i-1]);
					//System.out.println(theGameBoard[FromRow-1][i-1] + " Is at " + i + " " + FromRow);
    			}
			}
			int end = path.size()-1;
			for(int i=0; i < path.size(); i++) {// loops through the path to see if there is a valid move or not
				System.out.println("Path "+ i +" "+ path.get(i));
				if(path.get(i) == "") {
					continue;
				}else if(path.get(i).charAt(0) == UserColor.charAt(0) && i != end) {
					return false;
				}else if(path.get(i).charAt(0) == OtherColor.charAt(0) && i == end) {
					return true;
				}else
					return false;
					
			}
			return true;
		}
    	
    	return false;
    }
    // METHOD FOR VALIDATING A BISHOPS MOVE
    public boolean BishopValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow, String UserColor, String OtherColor) { 
    	//System.out.println("Not Done Yet");
    	
    	ArrayList<String> path = new ArrayList<String>(); // stores the path of the bishop
    	
    	if(ToRow == FromRow || ToColumn == FromColumn)
    		return false;
    	int Slope = (ToRow-FromRow)/(ToColumn-FromColumn); // gets the slope of the line
    	//System.out.println("Slope :: " + Slope);
    	if(Slope == -1) { // checks if the slope is 1 or -1 (diagonal for bishop)
    		if(ToColumn > FromColumn) { // check the diagonal going top right for any pieces in the way
    			//int count = 0;
    			for(int i = 1; i+FromColumn <= ToColumn; i++) {
    				int addedrow = FromRow-i;
    				int addedcol = FromColumn+i;
    				//System.out.println(theGameBoard[FromRow-1-i][FromColumn+i-1] + " Is at " + addedrow + " " + addedcol);
    				path.add(theGameBoard[FromRow-1-i][FromColumn+i-1]);
    			}
    		}else { // ToColumn < FromColumn
    			for(int i = 1; i+FromColumn <= ToColumn; i++) { // check the diagonal going down and to the left
    				int addedrow = FromRow+i;
    				int addedcol = FromColumn-i;
    				//System.out.println(theGameBoard[FromRow-1+i][FromColumn-i-1] + " Is at " + addedrow + " " + addedcol);
    				path.add(theGameBoard[FromRow-1+i][FromColumn-i-1]);
    			}
    		}
    		int end = path.size()-1;
			for(int i=0; i < path.size(); i++) {// loops through the path to see if there is a valid move or not
				System.out.println("Path "+ i +" "+ path.get(i));
				if(path.get(i) == "") {
					continue;
				}else if(path.get(i).charAt(0) == UserColor.charAt(0) && i != end) {
					return false;
				}else if(path.get(i).charAt(0) == OtherColor.charAt(0) && i == end) {
					return true;
				}else
					return false;
					
			}
			return true;
    	}
    	else {
    		if(ToColumn > FromColumn) { // check the diagonal going bottom right for any pieces in the way
    			//int count = 0;
    			for(int i = 1; i+FromColumn <= ToColumn; i++) {
    				int addedrow = FromRow+i;
    				int addedcol = FromColumn+i;
    				path.add(theGameBoard[FromRow-1+i][FromColumn+i-1]);
    				//System.out.println(theGameBoard[FromRow-1+i][FromColumn+i-1] + " Is at " + addedrow + " " + addedcol);
    			}
    		}else { // ToColumn < FromColumn
    			for(int i = 1; i+FromColumn <= ToColumn; i++) { // check the diagonal going up and to the left
    				int addedrow = FromRow-i;
    				int addedcol = FromColumn-i;
    				path.add(theGameBoard[FromRow-1-i][FromColumn-i-1]);
    				//System.out.println(theGameBoard[FromRow-1-i][FromColumn-i-1] + " Is at " + addedrow + " " + addedcol);
    			}
    		}
    		int end = path.size()-1;
			for(int i=0; i < path.size(); i++) {// loops through the path to see if there is a valid move or not
				System.out.println("Path "+ i +" "+ path.get(i));
				if(path.get(i) == "") {
					continue;
				}else if(path.get(i).charAt(0) == UserColor.charAt(0) && i != end) {
					return false;
				}else if(path.get(i).charAt(0) == OtherColor.charAt(0) && i == end) {
					return true;
				}else
					return false;
					
			}
			return true;
    	}
    }
 // METHOD FOR VALIDATING A QUEENS MOVE
    public boolean QueenValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow, String UserColor, String OtherColor) {
    	boolean movingDiagonal = false;
    	
    	//checks if the destination is on a diagonal from the queen
    	if ( FromRow - ToRow != 0 && FromColumn - ToColumn != 0) {
    		movingDiagonal = true;
    	}
    	
    	//uses validity function for bishop if queen is moving diagonally and rook if moving in a straight line
    	if (movingDiagonal) {
    		return BishopValidMove(theGameBoard, FromColumn, FromRow, ToColumn, ToRow, UserColor, OtherColor);
    	}
    	else {
    		return RookValidMove( theGameBoard, FromColumn,  FromRow,  ToColumn,  ToRow, UserColor, OtherColor);
    	}
    }
    // METHOD FOR VALIDATING A KINGS MOVE
    public boolean KingValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow, String UserColor, String OtherColor) {
    	//System.out.println("Not Done Yet"); // king can move only 1 space at a time around it
    	if(Math.abs(FromColumn - ToColumn) > 1) // check if the move is greater than 1 on column
    		return false;
    	if(Math.abs(FromRow - ToRow) > 1) //check if the move is greater than 1 on row
    		return false;
    	if(theGameBoard[ToRow-1][ToColumn-1] == "") {
    		//System.out.println("made it");
    		return true;
    	}else if(theGameBoard[ToRow-1][ToColumn-1].charAt(0) == OtherColor.charAt(0)) {
    		return true;
    	}else
    		return false;
    }
    // METHOD FOR VALIDATING A KNIGHTS MOVE
    public boolean KnightValidMove(String[][] theGameBoard,int FromColumn, int FromRow, int ToColumn, int ToRow) {
    	System.out.println("Not Done Yet");// knights can move two spaces around them + 1 space up or down in an L shape
    	return false;
    }
}
