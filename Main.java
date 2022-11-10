public class Main {
    public static void main(String[] args) {
        gameBoard theGameBoard = new gameBoard();

        theGameBoard.printBoard();
        //testing the integer.parseint to try to get the first number out of the 2 numbers in temp
        int temp = 03;
        System.out.println(Integer.parseInt(Integer.toString(temp).substring(0)));
        //System.out.println(Integer.parseInt(Integer.toString(temp).substring(1)));

    }
}