public class gameStatus {

    boolean checkWin(String[][] theBoard, int whichUser){
        //assume player is white, will work on if player is black later
        String userColor = "W";
        String otherUserColor = "B";
        int kingRow = 0, kingCol = 0, rook1Row = 99, rook1Col = 99, rook2Row = 99, rook2Col = 99;
        int counter = 0;//counter to differentiate the rooks

        //Locates the other players king
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(theBoard[row][col].equals("BKing")){
                    kingRow = row;
                    kingCol = col;
                }
            }
        }
        //locates the players rooks
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(theBoard[row][col].equals("WRook") && counter == 0){
                    rook1Row = row;
                    rook1Col = col;
                    counter++;
                }
                else if(theBoard[row][col].equals("WRook")){
                    rook2Row = row;
                    rook2Col = col;
                }
            }
        }

        //checks if pawns have a check
        if(kingRow != 7){
            if(kingCol == 0){
                if(theBoard[kingRow + 1][kingCol + 1].equals("WPawn")){
                    //bottom right pawn has check
                }
            }
            else if(kingCol == 7){
                if(theBoard[kingRow + 1][kingCol - 1].equals("WPawn")){
                    //bottom left pawn has check
                }
            }
            else{
                if(theBoard[kingRow + 1][kingCol - 1].equals("WPawn")){
                    //bottom left pawn has check
                }
                else if(theBoard[kingRow + 1][kingCol + 1].equals("WPawn")){
                    //bottom right pawn has check
                }
            }
        }
        //checks if rooks have check
        if(rook1Row != 99 && rook2Row != 99){

        }
        else if(rook1Row != 99){
            if(rook1Row == kingRow){
                //checks out of bounds to make sure we dont overflow
                if(rook1Row == 1){

                }
            }
            else if(rook1Col == kingCol){
                if(rook1Row == 7){
                    if(kingRow == rook1Row - 1){
                        //rook has single depth check
                    }
                    else if(theBoard[rook1Row + 1][rook1Col].equals("")){

                    }
                }
                else if(rook1Row == 0){
                    if(kingRow == rook1Row + 1){
                        //rook has single depth check
                    }
                }
            }
        }




        return false;
    }

    boolean checkDraw(gameBoard theBoard){


        return false;
    }

    boolean checkTime(clock theTime){

        return false;
    }
}