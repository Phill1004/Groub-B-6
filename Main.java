import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creates the 2d array game board
        String[][] board = new String[8][8];
        board = setBoard(board);
        displayBoard(board);

        //TESTING FOR THE VALID MOVE FUNCTION - Nathan
        chessController CContr = new chessController(board); // makes he chessController object and passes the board
        Scanner keyboard = new Scanner(System.in); // creates new scanner
        int X= 0, Y = 0, X2 = 0, Y2 = 0; // creates variables for user input

        System.out.println("Enter Selection column :: ");
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

        System.out.println("Enter Selection row :: ");
        Y = keyboard.nextInt();

        //Gets input on where to go
        System.out.println("Enter Selection column :: ");
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

        System.out.println("Enter Selection row :: ");
        Y2 = keyboard.nextInt();

        // 0 - white
        // 1 - black
        Boolean Validmove = CContr.validMove(board, X, Y, X2, Y2, "0");
        if(Validmove)
            System.out.println("Move is Valid");
        else
            System.out.println("Move is InValid");


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
}