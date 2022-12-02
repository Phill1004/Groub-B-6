package chess;

public class Main {
    public static void main(String[] args) {

        //gameStatus game = new gameStatus();

        System.out.println("=====> CHESS <====="); //title
		
		String ply1Name = gameBoard.getName(1, null);
		String ply2Name = gameBoard.getName(2, ply1Name);
		
		chessController whitePly = new chessController(ply1Name, "white");
		chessController blackPly = new chessController(ply2Name, "black");
		
		gameBoard.setUp(); //get board set

        // TESTING FOR TWO CLOCKS - Nicholas
        // This clock will run while the program runs even if there is no more output
        // Once the clock ends it will print a msg. We can use player#.timerEnded boolean to check if the timer ended
        int minutes = 15; // can change the amount of time if needed
        clock player1 = new clock(); // create player 1 and 2's clock
        clock player2 = new clock();
        player1.minutes = minutes; // set minutes for each player's clock
        player2.minutes = minutes;
        player1.name = "player1"; // set names. This can be removed later but for now shows who's timer ended when printing
        player2.name = "player2";
        player1.countDownTimer(); // start player 1 and 2's clock
        player2.countDownTimer();
        System.out.println(minutes + " minute timer has begun");

        while(true){
			
			for(int runNum = 1; runNum <= 2; runNum++){ //run for each player
				gameBoard.draw(); //show board
				
				int move[][] = new int[2][2];
				
				while(true){
				
					if(runNum == 1){ //first run
						move = whitePly.getMove();
					}
					else{ //second run
						move = blackPly.getMove();
					}
				
					if(move[0][0] == -1){ //restarting loop if input is wrong
						System.out.println("Invalid location. Try again.");
						continue;
					}
					
					int[] moveFrom = move[0];
					int[] moveTo = move[1];
					Square fromSquare = gameBoard.board[moveFrom[1]][moveFrom[0]];
				
					boolean checkValue;
					if(runNum == 1){
						checkValue = fromSquare.checkMove(moveFrom, moveTo, "white", false); //checking for pawn move validity
					}
					else{
						checkValue = fromSquare.checkMove(moveFrom, moveTo, "black", false);
					}
					if(checkValue){
						gameBoard.update(moveFrom, moveTo);
						
						if(runNum == 1){
							if (gameStatus.checkForCheckOrMate("white") == "check"){
								System.out.println("Check!");
							}
						}
						else{
							if (gameStatus.checkForCheckOrMate("black") == "check"){
								System.out.println("Check!");
							}
						}
						break;
					}
					System.out.println("Invalid move. Try again."); //not printed if break is called
				}
			}
		}
    }
}

