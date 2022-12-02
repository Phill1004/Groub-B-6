package chess;
import pieces.*;
import java.util.Scanner; 

public class gameBoard {
    static final char SIDE_LETTERS[] = {'A','B','C','D','E','F','G','H'};
	static final int SIDE_NUMS[] = {1,2,3,4,5,6,7,8};//symbols on the side of board
    public static Square[][] board = new Square[8][8];

	public static final Scanner scanner = new Scanner(System.in);

    public static void setUp() {
        //board array and location x,y are inverted
		board[0][0] = new Rook("black");
		board[0][1] = new Knight("black");
		board[0][2] = new Bishop("black");
		board[0][3] = new Queen("black");
		board[0][4] = new King("black");
		board[0][5] = new Bishop("black");
		board[0][6] = new Knight("black");
		board[0][7] = new Rook("black");
		
		//pawns
		for(int i = 0; i < 8; i++){
			board[1][i] = new Pawn("black");
		}
		
		for(int i = 2; i < 6; i++){ //creating blank spaces in middle
			for(int j = 0; j < 8; j++){
				board[i][j] = new BlankSpace();
			}
		}
		
		//pawns
		for(int i = 0; i < 8; i++){
			board[6][i] = new Pawn("white");
		}

		board[7][0] = new Rook("white");
		board[7][1] = new Knight("white");
		board[7][2] = new Bishop("white");
		board[7][3] = new Queen("white");
		board[7][4] = new King("white");
		board[7][5] = new Bishop("white");
		board[7][6] = new Knight("white");
		board[7][7] = new Rook("white");

    }


	public static void update(int[] origLoc, int[] newLoc){ //setting new location to piece type and setting old location to blank
		board[newLoc[1]][newLoc[0]] = board[origLoc[1]][origLoc[0]];
		board[origLoc[1]][origLoc[0]] = new BlankSpace();
	}

	public static void draw(){
		System.out.print("\n   ");
		
		for(char i: SIDE_LETTERS){ //printing letters across the top
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n   ");
		
		for(int i = 0; i < 8; i++){
			System.out.print(" --- ");
		}
		
		System.out.print("\n");
		for(int i = 0; i < 8; i++){ //looping through the board and printing symbols
			System.out.print(" " + (8 - i) + " "); //print number on left side
			
			for(Square j: board[i]){
				System.out.print("|" + j.getSymbol() + "|");
			}
			System.out.print(" " + (8 - i) + " "); //number on right side
			
			System.out.print("\n   ");//to get next line
			
			for(int j = 0; j < 8; j++){
				System.out.print(" --- ");
			}
			System.out.print("\n");
		}
		System.out.print("   ");
		for(char i: SIDE_LETTERS){ //printing letters across the bottom
			System.out.print("  " + i + "  ");
		}
		System.out.print("\n\n");
	}

	public static String getName(int playerNum, String prevName){ 
		String name;
		
		while(true){
			System.out.print("Player " + playerNum + " please enter your name.\n>> ");
			name = scanner.nextLine().trim();
			
			//if there is no spaces and it is not empty and names are not the same
			if(!name.isEmpty() && !(name.contains(" ") || name.contains("\t")) && !name.equals(prevName)) 
				
				break; //otherwise the user will be asked to enter again
			else
				System.out.println("Invalid name. Try again.");
		}
		return name;
	}
}
