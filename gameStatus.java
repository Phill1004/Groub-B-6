import java.util.Scanner;
public class gameStatus {
    int stalemateCounter = 0;

    boolean checkWin(String[][] theBoard, int whichUser){
        //assume player is white, will work on if player is black later
        String userColor = "W";
        String otherUserColor = "B";
        boolean hasCheck = false;
        int kingRow = 0, kingCol = 0, rook1Row = 99, rook1Col = 99, rook2Row = 99, rook2Col = 99;
        int bishop1Row = 99, bishop1Col = 99, bishop2Row = 99, bishop2Col = 99, queenRow = 99;
        int knight1Row = 99, knight1Col = 99, knight2Row = 99, knight2Col = 99, queenCol = 99;
        int counter = 0;//counter to differentiate the rooks and bishops
        String kingInDiagonal = ""; //to test if king is in bishop diagonal

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
        counter = 0;//resets counter, so it can be used to differentiate the bishops
        //locates the players bishops
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(theBoard[row][col].equals("WBishop") && counter == 0){
                    bishop1Row = row;
                    bishop1Col = col;
                    counter++;
                }
                else if(theBoard[row][col].equals("WBishop")){
                    bishop2Row = row;
                    bishop2Col = col;
                }
            }
        }
        counter = 0;//resets counter, so it can be used to knights
        //locates the players knights
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(theBoard[row][col].equals("WKnight") && counter == 0){
                    knight1Row = row;
                    knight1Col = col;
                    counter++;
                }
                else if(theBoard[row][col].equals("WKnight")){
                    knight2Row = row;
                    knight2Col = col;
                }
            }
        }
        //locates the players queen
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if(theBoard[row][col].equals("WQueen")){
                    queenRow = row;
                    queenCol = col;
                }
            }
        }

        //checks if pawns have a check
        if(kingRow != 7){
            if(kingCol == 0){
                if(theBoard[kingRow + 1][kingCol + 1].equals("WPawn")){
                    hasCheck = true;
                }
            }
            else if(kingCol == 7){
                if(theBoard[kingRow + 1][kingCol - 1].equals("WPawn")){
                    hasCheck = true;
                }
            }
            else{
                if(theBoard[kingRow + 1][kingCol - 1].equals("WPawn")){
                    hasCheck = true;
                }
                else if(theBoard[kingRow + 1][kingCol + 1].equals("WPawn")){
                    hasCheck = true;
                }
            }
        }

        //checks to see if there is a rook on board, if so checks for check by first rook
        if(rook1Row != 99){
            //checks that row for a check, by checking each column in the row
            if(rook1Row == kingRow){
                //checks check for rooks on left edge, right edge, then any other spot.
                if(rook1Col == 0){
                    if(kingCol == rook1Col + 1){
                        hasCheck = true;
                    }
                    else{
                        for(int col = 1; col < kingCol; col++){
                            if(theBoard[rook1Row][col].equals("")){
                                hasCheck = true;
                            }
                            else{
                                hasCheck = false;
                                col = 10; //no check
                            }
                        }
                    }

                }
                else if(rook1Col == 7){
                    if(kingCol == rook1Col - 1){
                        hasCheck = true;
                    }
                    else {
                        for(int col = 6; kingCol < col; col--){
                            if(theBoard[rook1Row][col].equals("")){
                                hasCheck = true;
                            }
                            else{
                                hasCheck = false;
                                col = 0;//no check
                            }
                        }
                    }

                }
                else if(rook1Col < kingCol){
                    if(kingCol == rook1Col + 1){
                        hasCheck = true;
                    }
                    else{
                        for(int col = rook1Col + 1; col < kingCol; col++){
                            if(theBoard[rook1Row][col].equals("")){
                                hasCheck = true;
                            }
                            else{
                                hasCheck = false;
                                col = 10; //no check
                            }
                        }
                    }
                }
                //rook col must be greater than king col
                else{
                    if(kingCol == rook1Col - 1){
                        hasCheck = true;
                    }
                    else{
                        for(int col = rook1Col - 1; kingCol < col; col--){
                            if(theBoard[rook1Row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                col = 0;//no check
                            }
                        }
                    }
                }
            }
            //checks that col for a check by checking each row in the column
            else if(rook1Col == kingCol){
                if(rook1Row == 7){
                    if(kingRow == rook1Row - 1){
                        hasCheck = true;
                    }
                    else{
                        for(int row = 6; kingRow < row; row--){
                            if(theBoard[row][rook1Col].equals("")){
                                hasCheck = true;
                            }
                            else{
                                hasCheck = false;
                                row = 0;//no check
                            }
                        }
                    }
                }
                else if(rook1Row == 0){
                    if(kingRow == rook1Row + 1){
                        hasCheck = true;
                    }
                    else{
                        for(int row = 1; row < kingRow; row++){
                            if(theBoard[row][kingCol].equals("")){
                                hasCheck = true;
                            }
                            else{
                                hasCheck = false;
                                row = 10;//no check, terminates loop
                            }
                        }
                    }
                }
                else if(rook1Row < kingRow){
                    if(kingRow == rook1Row + 1){
                        hasCheck = true;
                    }
                    else{
                        for(int row = rook1Row + 1; row < kingRow; row++){
                            if(theBoard[row][kingCol].equals("")){
                                hasCheck = true;
                            }
                            else{
                                hasCheck = false;
                                row = 10;//no check, terminate loop
                            }
                        }
                    }
                }
                //rook row must be greater than king row at this point
                else{
                    if(kingRow == rook1Row - 1){
                        hasCheck = true;
                    }
                    else{
                        for(int row = rook1Row -1; kingRow < row; row++){
                            if(theBoard[row][kingCol].equals("")){
                                hasCheck = true;
                            }
                            else{
                                hasCheck = false;
                                row = 0; //no check, terminate loop
                            }
                        }
                    }
                }
            }
        }
        //checks to see if there is a second rook on board, if so checks for check by second rook.
        if(rook2Row != 99){
            //checks that row for a check by cheking each column in the row
            if(rook2Row == kingRow){
                //checks check for rooks on left edge, right edge, then any other spot.
                if(rook2Col == 0){
                    if(kingCol == rook2Col + 1){
                        hasCheck = true;
                    }
                    else{
                        for(int col = 1; col < kingCol; col++){
                            if(theBoard[rook2Row][col].equals("")){
                                hasCheck = true;
                            }
                            else{
                                hasCheck = false;
                                col = 10; //no check
                            }
                        }
                    }

                }
                else if(rook2Col == 7){
                    if(kingCol == rook2Col - 1){
                        hasCheck = true;                    }
                    else {
                        for(int col = 6; kingCol < col; col--){
                            if(theBoard[rook2Row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                col = 0;//no check
                            }
                        }
                    }

                }
                else if(rook2Col < kingCol){
                    if(kingCol == rook2Col + 1){
                        hasCheck = true;                    }
                    else{
                        for(int col = rook2Col + 1; col < kingCol; col++){
                            if(theBoard[rook2Row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                col = 10; //no check
                            }
                        }
                    }
                }
                //rook col must be greater than king col
                else{
                    if(kingCol == rook2Col - 1){
                        hasCheck = true;                    }
                    else{
                        for(int col = rook2Col - 1; kingCol < col; col--){
                            if(theBoard[rook2Row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                col = 0;//no check
                            }
                        }
                    }
                }
            }
            else if(rook2Col == kingCol){
                if(rook2Row == 7){
                    if(kingRow == rook2Row - 1){
                        hasCheck = true;                    }
                    else{
                        for(int row = 6; kingRow < row; row--){
                            if(theBoard[row][rook2Col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 0;//no check
                            }
                        }
                    }
                }
                else if(rook2Row == 0){
                    if(kingRow == rook2Row + 1){
                        hasCheck = true;                    }
                    else{
                        for(int row = 1; row < kingRow; row++){
                            if(theBoard[row][kingCol].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 10;//no check, terminates loop
                            }
                        }
                    }
                }
                else if(rook2Row < kingRow){
                    if(kingRow == rook2Row + 1){
                        hasCheck = true;                    }
                    else{
                        for(int row = rook2Row + 1; row < kingRow; row++){
                            if(theBoard[row][kingCol].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 10;//no check, terminate loop
                            }
                        }
                    }
                }
                //rook row must be greater than king row at this point
                else{
                    if(kingRow == rook2Row - 1){
                        hasCheck = true;                    }
                    else{
                        for(int row = rook2Row -1; kingRow < row; row++){
                            if(theBoard[row][kingCol].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 0; //no check, terminate loop
                            }
                        }
                    }
                }
            }
        }

        //checks to see if there is a bishop on board, if so checks for check by first bishop
        if(bishop1Row != 99){
            //checking bottom right diagonal for king
            for(int row = bishop1Row + 1, col = bishop1Col + 1; row < 8 && col < 8; row++, col++){
                if(theBoard[row][col].equals("BKing")){
                    kingInDiagonal = "BR";
                }
            }
            //checking bottom left diagonal for king
            for(int row = bishop1Row + 1, col = bishop1Col - 1; row < 8 && col >= 0; row++, col--){
                if(theBoard[row][col].equals("BKing")){
                    kingInDiagonal = "BL";
                }
            }
            //checking top left diagonal for king
            for(int row = bishop1Row - 1, col = bishop1Col - 1; row >= 0 && col >= 0; row--, col--){
                if(theBoard[row][col].equals("BKing")){
                    kingInDiagonal = "TL";
                }
            }
            //checking top right diagonal
            for(int row = bishop1Row - 1, col = bishop1Col + 1; row >= 0 && col < 8; row--, col++){
                if(theBoard[row][col].equals("BKing")){
                    kingInDiagonal = "TR";
                }
            }
            //if king is found to be in diagonal. this checks if bishop has a check on it
            if(!kingInDiagonal.equals("")){
                if(kingInDiagonal.equals("TL")){
                    if(theBoard[bishop1Row - 1][bishop1Col - 1].equals("BKing")){
                        hasCheck = true;                    }
                    else{
                        for(int row = bishop1Row - 1, col = bishop1Col - 1; row > kingRow && col > kingCol; row--, col--){
                            if(theBoard[row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 0;//no check terminate loop
                            }
                        }
                    }
                }
                else if(kingInDiagonal.equals("TR")){
                    if(theBoard[bishop1Row - 1][bishop1Col + 1].equals("BKing")){
                        hasCheck = true;                    }
                    else{
                        for(int row = bishop1Row - 1, col = bishop1Col + 1; row > kingRow && col < kingCol; row--, col++){
                            if(theBoard[row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 0;//no check, terminate loop
                            }
                        }
                    }
                }
                else if(kingInDiagonal.equals("BL")){
                    if(theBoard[bishop1Row + 1][bishop1Col - 1].equals("BKing")){
                        hasCheck = true;                    }
                    else{
                        for(int row = bishop1Row + 1, col = bishop1Col - 1; row < kingRow && col > kingCol; row++, col--){
                            if(theBoard[row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 10; //no check terminate loop
                            }
                        }
                    }
                }
                //king must be in BR diagonal of bishop
                else{
                    if(theBoard[bishop1Row + 1][bishop1Col + 1].equals("BKing")){
                        hasCheck = true;                    }
                    else{
                        for(int row = bishop1Row + 1, col = bishop1Col + 1; row < kingRow && col < kingCol; row++, col++){
                            if(theBoard[row][col].equals("")){
                                hasCheck = true;                            }
                            else {
                                hasCheck = false;
                                row = 10;//no check terminate loop
                            }
                        }
                    }
                }
            }
        }
        //checks to see if there is a second bishop on board, if so checks for check by second bishop
        if(bishop2Row != 99){
            //checking bottom right diagonal for king
            for(int row = bishop2Row + 1, col = bishop2Col + 1; row < 8 && col < 8; row++, col++){
                if(theBoard[row][col].equals("BKing")){
                    kingInDiagonal = "BR";
                }
            }
            //checking bottom left diagonal for king
            for(int row = bishop2Row + 1, col = bishop2Col - 1; row < 8 && col >= 0; row++, col--){
                if(theBoard[row][col].equals("BKing")){
                    kingInDiagonal = "BL";
                }
            }
            //checking top left diagonal for king
            for(int row = bishop2Row - 1, col = bishop2Col - 1; row >= 0 && col >= 0; row--, col--){
                if(theBoard[row][col].equals("BKing")){
                    kingInDiagonal = "TL";
                }
            }
            //checking top right diagonal
            for(int row = bishop2Row - 1, col = bishop2Col + 1; row >= 0 && col < 8; row--, col++){
                if(theBoard[row][col].equals("BKing")){
                    kingInDiagonal = "TR";
                }
            }
            //if king is found to be in diagonal. this checks if bishop has a check on it
            if(!kingInDiagonal.equals("")){
                if(kingInDiagonal.equals("TL")){
                    if(theBoard[bishop2Row - 1][bishop2Col - 1].equals("BKing")){
                        hasCheck = true;                    }
                    else{
                        for(int row = bishop2Row - 1, col = bishop2Col - 1; row > kingRow && col > kingCol; row--, col--){
                            if(theBoard[row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 0;//no check terminate loop
                            }
                        }
                    }
                }
                else if(kingInDiagonal.equals("TR")){
                    if(theBoard[bishop2Row - 1][bishop2Col + 1].equals("BKing")){
                        hasCheck = true;                    }
                    else{
                        for(int row = bishop2Row - 1, col = bishop2Col + 1; row > kingRow && col < kingCol; row--, col++){
                            if(theBoard[row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 0;//no check, terminate loop
                            }
                        }
                    }
                }
                else if(kingInDiagonal.equals("BL")){
                    if(theBoard[bishop2Row + 1][bishop2Col - 1].equals("BKing")){
                        hasCheck = true;                    }
                    else{
                        for(int row = bishop2Row + 1, col = bishop2Col - 1; row < kingRow && col > kingCol; row++, col--){
                            if(theBoard[row][col].equals("")){
                                hasCheck = true;                            }
                            else{
                                hasCheck = false;
                                row = 10; //no check terminate loop
                            }
                        }
                    }
                }
                //king must be in BR diagonal of bishop
                else{
                    if(theBoard[bishop2Row + 1][bishop2Col + 1].equals("BKing")){
                        hasCheck = true;                    }
                    else{
                        for(int row = bishop2Row + 1, col = bishop2Col + 1; row < kingRow && col < kingCol; row++, col++){
                            if(theBoard[row][col].equals("")){
                                hasCheck = true;                            }
                            else {
                                hasCheck = false;
                                row = 10;//no check terminate loop
                            }
                        }
                    }
                }
            }
        }
        kingInDiagonal = "";//resets String so it can be used for queen section

        //checks to see if there is a queen, if so checks for a check
        if(queenRow != 99){
            //checking to see if king is in row
            if(kingRow == queenRow){

            }
            //checking to see if king is in column
            else if(kingCol == queenCol){

            }
            else{
                //checking for bottom right diagonal for king
                for(int row = queenRow + 1, col = queenCol + 1; row < 8 && col < 8; row++, col++){
                    if(theBoard[row][col].equals("BKing")){
                        kingInDiagonal = "BR";
                    }
                }
                //checking bottom left diagonal for king
                for(int row = queenRow + 1, col = queenCol - 1; row < 8 && col >= 0; row++, col--){
                    if(theBoard[row][col].equals("BKing")){
                        kingInDiagonal = "BL";
                    }
                }
                //checking top left diagonal for king
                for(int row = queenRow - 1, col = queenCol - 1; row >= 0 && col >= 0; row--, col--){
                    if(theBoard[row][col].equals("BKing")){
                        kingInDiagonal = "TL";
                    }
                }
                //checking top right diagonal
                for(int row = queenRow - 1, col = queenCol + 1; row >= 0 && col < 8; row--, col++){
                    if(theBoard[row][col].equals("BKing")){
                        kingInDiagonal = "TR";
                    }
                }
            }



        }

        //checks to see if there is a knight on board, if so checks for check by first knight
        if(knight1Row != 99){
            //still working on it
        }


        return hasCheck;
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