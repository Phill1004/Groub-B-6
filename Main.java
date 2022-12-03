import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        gameStatus game = new gameStatus();
        Scanner keyboard = new Scanner(System.in); // creates new scanner

        System.out.println("Welcome to JAVA CHESS");
        System.out.println("What would you like to do? 1-New Game 2-Rules 3-Quit");
        String mainMenu = keyboard.next();

        if (mainMenu.equals("2")) {
        	System.out.println("To play, each player must take turns inputting their moves in the keyboard.\n"
					+ "On your turn you will have the option to play, request a draw, or forfeit.\n"
					+ "If you choose to play you must select the coordinates of the peice you wish to move\n"
					+ "Then you must select coordinates of the destination. You will do this by typing and entering the\n"
					+ "letter corresponding to your chosen column, then the number corresponding to your chosen row\n"
					+ "If your move is valid, the process repeats for each player until the game is over\n"
					+ "The game is won if your opponent forfeits or if you take the opposing king.\n");
        	 System.out.println("Press enter key to continue to new game...");
             keyboard.nextLine();
             keyboard.nextLine();
        }
        else if (mainMenu.equals("3")) {
        	System.exit(0);
        }
        
        else if (!mainMenu.equals("1")) {
        	System.out.println("Invalid response. Resetting game.");
            main(args);
        }
        
        //Creates the 2d array game board
        String[][] board = new String[8][8];
        boolean gameOver = false;
        board = setBoard(board);

        //TESTING FOR THE VALID MOVE FUNCTION - Nathan
        chessController CContr = new chessController(board); // makes he chessController object and passes the board
        int X= 0, Y = 0, X2 = 0, Y2 = 0; // creates variables for user input

        // TESTING FOR TWO CLOCKS - Nicholas
        // This clock will run while the program runs even if there is no more output
        // Once the clock ends it will print a msg. We can use player#.timerEnded boolean to check if the timer ended
        clock white = new clock(); // create player 1 and 2's clock
        clock black = new clock();
        white.name = "White"; // set names. This can be removed later but for now shows who's timer ended when printing
        black.name = "Black";
        displayBoard(board);

        int winner = 0;
        int checkTimer = 0;

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

            System.out.println("What would you like to do? 1-Play 2-Request Draw 3-Forfeit");
            String choice = keyboard.next();

            if (choice.equals("2")) {
                gameOver = game.checkDraw(turnCount%2==0, keyboard);
                if (gameOver) {
                    winner = 0;
                    break;
                }
                continue;
            }
            else if (choice.equals("3")) {
                gameOver = true;
                if(turnCount%2 == 0)
                    winner = 2;
                else
                    winner = 1;

                break;
            }
            else if (!choice.equals("1")) {
                continue;
            }

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

            // check to see if time has run out
            if(white.timeOut == true){
                winner = 2;
                System.out.println(white.name +"'s time has run out!");
                break;
            }
            else if(black.timeOut == true){
                System.out.println(black.name +"'s time has run out!");
                winner = 1;
                break;
            }
        }

        System.out.println("Game Over!");
        switch (winner) {
            case 0:
                System.out.println("It's a tie!");
                break;
            case 1:
                System.out.println("White Wins!");
                break;
            case 2:
                System.out.println("Black Wins!");
                break;
        }
        
        System.out.println("Press enter key to reset...");
        keyboard.nextLine();
        keyboard.nextLine();
        keyboard.reset();
        main(args);

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
