import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        gameStatus game = new gameStatus();

        //Creates the 2d array game board
        String[][] board = new String[8][8];
        boolean gameOver = false;
        board = setBoard(board);

        //TESTING FOR THE VALID MOVE FUNCTION - Nathan
        chessController CContr = new chessController(board); // makes he chessController object and passes the board
        Scanner keyboard = new Scanner(System.in); // creates new scanner
        int X= 0, Y = 0, X2 = 0, Y2 = 0; // creates variables for user input

        // TESTING FOR TWO CLOCKS - Nicholas
        // This clock will run while the program runs even if there is no more output
        // Once the clock ends it will print a msg. We can use player#.timerEnded boolean to check if the timer ended
        int minutes = 15; // can change the amount of time if needed
        clock white = new clock(); // create player 1 and 2's clock
        clock black = new clock();
        white.name = "White"; // set names. This can be removed later but for now shows who's timer ended when printing
        black.name = "Black";
        System.out.println(minutes + " minute game has begun");
        displayBoard(board);

        String turn = "0";
        int turnCount = 0;
        System.out.println("White Start");
        boolean Validmove = false;
        while(gameOver == false){

            if(!Validmove) {
                turn = turn; // basically do nothing let the user input again
            }
            else {
                if(turnCount%2 == 0)
                    turn = "0"; //white turn
                else
                    turn = "1"; //black turn
            }


            String Name = ""; // stores the name of the person moving
            switch(turn) { // converts the number of the player to the color they play for printing
                case "0":
                    Name = "White";
                    white.turn = true; // set turn variables
                    black.turn = false;
                    white.runTimer(white.elapsedTime); // start timer and print time left for the player
                    white.timeLeft(white.elapsedTime);
                    break;
                case "1":
                    Name = "Black";
                    black.turn = true; // set turn variables
                    white.turn = false;
                    black.runTimer(black.elapsedTime);
                    black.timeLeft(black.elapsedTime); // start timer and print time left for the player
                    break;
            }
            System.out.println("It's "+Name+"'s turn "); // prints out the whose turn it is
            System.out.println("Enter piece to move column :: ");
            String column = keyboard.next();
            switch(column.charAt(0)) { // switch case to take letter input and change it to number input for backend
                case 'a' :
                    X = 1;
                    break;
                case 'b' :
                    X = 2;
                    break;
                case 'c' :
                    X = 3;
                    break;
                case 'd' :
                    X = 4;
                    break;
                case 'e' :
                    X = 5;
                    break;
                case 'f' :
                    X = 6;
                    break;
                case 'g' :
                    X = 7;
                    break;
                case 'h' :
                    X = 8;
                    break;
            }

            System.out.println("Enter piece to move row :: ");
            Y = keyboard.nextInt();

            //Gets input on where to go
            System.out.println("Enter piece to where column :: ");
            String column2 = keyboard.next();
            switch(column2.charAt(0)) { // switch case to take letter input and change it to number input for backend
                case 'a' :
                    X2 = 1;
                    break;
                case 'b' :
                    X2 = 2;
                    break;
                case 'c' :
                    X2 = 3;
                    break;
                case 'd' :
                    X2 = 4;
                    break;
                case 'e' :
                    X2 = 5;
                    break;
                case 'f' :
                    X2 = 6;
                    break;
                case 'g' :
                    X2 = 7;
                    break;
                case 'h' :
                    X2 = 8;
                    break;
            }

            System.out.println("Enter piece to where row :: ");
            Y2 = keyboard.nextInt();

            // 0 - white
            // 1 - black
            Validmove = CContr.validMove(board, X, Y, X2, Y2, Name);
            if(Validmove) {
                System.out.println("Move is Valid");
                board = updateBoard(board, X, Y, X2, Y2);
                turnCount++;// updates the turn count
            }
            else {
                System.out.println("Move is InValid");
            }
            gameOver = game.checkWin(board, 0);
            displayBoard(board);

        }

        System.out.println("Game Over!");

        //draw use case test (assumes it's p1's turn)
        {
            //draw button clicked
            boolean draw = false;
            gameStatus g = new gameStatus();
            draw = g.checkDraw(new gameBoard(), true);
            if (draw) {
                //This is where the game would end
            }

            //assumes several repeated turns
            if (!draw)
            {
                draw = g.checkStalemate(true);
                draw = g.checkStalemate(true);
                draw = g.checkStalemate(false);
                draw = g.checkStalemate(true);
                draw = g.checkStalemate(true);
                draw = g.checkStalemate(true);
                if (draw) {
                    //This is where the game would end
                }
            }

        }
    }

    public static String[][] setBoard(String[][] board){
        //creates the chess pieces object
        chessPieces pieces = new chessPieces();

        //sets black pieces
        board[0][0] = pieces.rook(1, 0, 0);
        board[0][1] = pieces.knight(1, 0, 1);
        board[0][2] = pieces.bishop(1, 0, 2);
        board[0][3] = pieces.queen(1, 0, 3);
        board[0][4] = pieces.king(1, 0, 4);
        board[0][5] = pieces.bishop(1, 0, 5);
        board[0][6] = pieces.knight(1, 0, 6);
        board[0][7] = pieces.rook(1, 0, 7);
        for(int i = 0; i < 8; i++){
            board[1][i] = pieces.pawn(1, 1, i);
        }
        //sets white pieces
        board[7][0] = pieces.rook(0, 7, 0);
        board[7][1] = pieces.knight(0, 7, 1);
        board[7][2] = pieces.bishop(0, 7, 2);
        board[7][3] = pieces.queen(0, 7, 3);
        board[7][4] = pieces.king(0, 7, 4);
        board[7][5] = pieces.bishop(0, 7, 5);
        board[7][6] = pieces.knight(0, 7, 6);
        board[7][7] = pieces.rook(0, 7, 7);
        for(int i = 0; i < 8; i++){
            board[6][i] = pieces.pawn(0, 6, i);
        }
        //sets empty spaces
        for(int row = 2; row < 6; row++){
            for(int col = 0; col < 8; col++){
                board[row][col] = "";
            }
        }
        return board;
    }

    public static void displayBoard(String[][] board){
        for(int row = 0; row < 8; row++){
            System.out.println();
            System.out.print(row+1 + " "); // prints out the numbers on the side
            for(int col = 0; col < 8; col++){
                System.out.printf("%15s","[" + board[row][col] + "]   "); // formats the string to make it line up
            }
            System.out.println(); // new line for spacing
        }
        //prints out the letter at the bottom
        System.out.println("         a              b"
                +     "              c              d"
                +     "	             e              f"
                +     "              g              h");
    }

    public static String[][] updateBoard(String[][] board, int x, int y, int x2, int y2){
        x -= 1;
        y -= 1;
        x2 -= 1;
        y2 -= 1;
        board[y2][x2] = board[y][x];
        board[y][x] = "";
        return board;
    }
}
