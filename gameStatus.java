import java.util.Scanner;

public class gameStatus {

	int stalemateCounter = 0;
	
    boolean checkWin(gameBoard theBoard){
    	
        return false;
    }

    //method is called when request draw button is clicked
    boolean checkDraw(gameBoard theBoard, boolean isPlayer1){
    			//Initialize input variables
    			String yesOrNo;
    			boolean draw = false;
    			boolean playerOnesTurn = isPlayer1;
    			Scanner keyboard = new Scanner(System.in);
    			
    			//prompt responding player for draw (IDE console serves the purpose of the accept draw button)
    			if (playerOnesTurn) {
    				System.out.print("P2, do you accept the draw?(Y/N): ");
    			}
    			else {
    				System.out.print("P1, do you accept the draw?(Y/N): ");
    			}
    			yesOrNo = keyboard.nextLine();
    			if (yesOrNo.equals("Y")||yesOrNo.equals("y")) {
    				draw = true;
    			}
    			
    			if (draw) {
    				System.out.println("The game ends in a draw");
    			}
    			
    			keyboard.close();
    			return draw;
    }
    
    //checks for stalemates after each set of 2 moves
    boolean checkStalemate(boolean repeatedMoves) {
    	//increments or resets the stalemate counter
    	if (repeatedMoves) {
    		stalemateCounter++;
    		System.out.println("Players have repeated their last moves "+(3-stalemateCounter)+" repeated rounds until stalemate");
    	}
    	else {
    		if (stalemateCounter != 0) {
    			System.out.println("Stalemate avoided. The game can continue");
    		}
    		stalemateCounter = 0;
    	}
    	
    	//returns true if both players have repeated their moves 3 times
    	if (stalemateCounter >= 3) {
    		System.out.println("The game ends in a draw");
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    

    boolean checkTime(clock theTime){

        return false;
    }
}