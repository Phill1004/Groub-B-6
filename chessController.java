public class chessController {

    //Idea is user will be prompted to pick a piece to move and we will take in the xy value
    //then user will input where they want to go and put in another xy value.
    //take these values and check if its possible.
    //the integer.parseint stuff just gives us the first number and second number so we can put in th array
    //to find the spot.

    boolean validMove(gameBoard theGameBoard, int fromWhere, int toWhere, String theUserColor){
        if(theGameBoard.getBoard()[Integer.parseInt(Integer.toString(fromWhere).substring(0, 1))][Integer.parseInt(Integer.toString(fromWhere).substring(1))].equals(" ")){
            return false;
        }
        else if(theGameBoard.getBoard()[Integer.parseInt(Integer.toString(toWhere).substring(0, 1))][Integer.parseInt(Integer.toString(toWhere).substring(1))].charAt(0) == theUserColor.charAt(0)){
            return false;
        }

        return false;
    }
}
