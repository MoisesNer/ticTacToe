import java.util.Scanner;
import java.util.Arrays; 
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
/**
 * GameChallenge
 */
public class GameChallenge2 {

    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();

    
    public static void main(String[] args){

        char[][] gameBoard = { {' ', '|', ' ', '|', ' '}, 
        {'-', '+', '-', '+', '-'}, 
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};

    printGameBoard(gameBoard);


        while (true){

            //Initialize scanner
            Scanner insert = new Scanner(System.in);

            //asking p1 to enter placement
            System.out.println("Player 1 enter your placement 1 - 9");
            int pos = insert.nextInt();

            //method p1
            placePiece(gameBoard, pos, "player1");
            
            //asking p2 to enter placement
            System.out.println("Player 2 enter your placement 1- 9");
            pos = insert.nextInt();

            //method p2
            placePiece(gameBoard, pos, "player2");
 
            //prints final gameboard
            printGameBoard(gameBoard);

            String result = counter();
            System.out.println(result);
        }

    }
    //Method printing gameboard
    public static void printGameBoard(char[][]gameBoard){
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }
    //method printing positions
    public static void placePiece(char[][] gameBoard, int pos, String user){

        char mark = ' ';

        if(user.equals("player1")){
            mark = 'X';
            player1Positions.add(pos);
        } else if (user.equals("player2")){
            mark = '0';
            player2Positions.add(pos);

        }

        switch(pos) {
            case 1:
                gameBoard[0][0] = mark;
            break;
            case 2:
                gameBoard[0][2] = mark;
            break;
            case 3:
                gameBoard[0][4] = mark;
            break;
            case 4:
                gameBoard[2][0] = mark;
            break;
            case 5:
                gameBoard[2][2] = mark;
            break;
            case 6:
                gameBoard[2][4] = mark;
            break;
            case 7:
                gameBoard[4][0] = mark;
            break;
            case 8:
                gameBoard[4][2] = mark;
            break;
            case 9:
                gameBoard[4][4] = mark;
            break;
            default:
            break;
        }

    }
    //method check counter
    public static String counter(){
        
        List topRow = Arrays.asList (1, 2, 3);
        List midRow = Arrays.asList (4, 5, 6);
        List lowRow = Arrays.asList (7, 8, 9);
        List leftCol = Arrays.asList (1, 4, 7);
        List midCol = Arrays.asList (2, 5, 8);
        List rightCol = Arrays.asList (3, 6, 9);
        List crossA = Arrays.asList (1, 5, 9);
        List crossB = Arrays.asList (7, 5, 3);


        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(lowRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(crossA);
        winning.add(crossB);

        for(List l : winning){
            if(player1Positions.containsAll(l)){
                return "\nplayer 1 WON --";
            } else if (player2Positions. containsAll(l)){
                return "\n-- player 2 WON --";
            } else if(player1Positions.size() + player2Positions.size() == 9){
            return "play again";
            }
        }
        
        return "";

    }

}