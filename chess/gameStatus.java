package chess;

public class gameStatus {
    public static String checkForCheckOrMate(String plyColor){ //check for win or check
		for(int kingY = 0; kingY < 8; kingY++){
			for(int kingX = 0; kingX < 8; kingX++){
				Square kingSquare = gameBoard.board[kingY][kingX];
				
				String kingColor;
				if(plyColor == "white"){
					kingColor = "black";
				}
				else{ //black
					kingColor = "white";
				}
				
				if((kingSquare.getType() == "king") && (kingSquare.getColor() == kingColor)){
					
					for(int threatY = 0; threatY < 8; threatY++){
						for(int threatX = 0; threatX < 8; threatX++){
							Square threatSquare = gameBoard.board[threatY][threatX];
							
							if((threatSquare.getType() != "blank") && (threatSquare.getColor() == plyColor)){
								int[] moveFrom = {threatX, threatY};
								int[] moveTo = {kingX, kingY};
							
								if(threatSquare.checkMove(moveFrom, moveTo, plyColor, true)){
									return "check";
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
}