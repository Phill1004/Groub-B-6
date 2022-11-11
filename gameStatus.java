import java.util.Scanner;
public class gameStatus {
    int stalemateCounter = 0;

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