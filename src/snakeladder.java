import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

//SnakeLadder Practice Problem
class Snakeladd {

    final static int WINPOINT = 100;

    static Map<Integer, Integer> snake = new HashMap<Integer, Integer>();
    static Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();

    {
        snake.put(99, 54);
        snake.put(70, 55);
        snake.put(52, 42);
        snake.put(25, 2);
        snake.put(95, 72);

        ladder.put(6, 25);
        ladder.put(11, 40);
        ladder.put(60, 85);
        ladder.put(46, 90);
        ladder.put(17, 69);
    }

    public int rollDice(){
        int n = 0;
        Random r=new Random();
        n=r.nextInt(7);
        return( n == 0?1:n );
    }

    public int calculatePlayerVal(int player,int dicevalue)
    {
        player = player + dicevalue;

        if (player > WINPOINT) {
            player = player - dicevalue;
            return player;
        }

        if (null != snake.get(player)) {
            System.out.println("swallopwedby snake");
            player = snake.get(player);
        }

        if (null != ladder.get(player)) {
            System.out.println("climb up the ladder");
            player = ladder.get(player);
        }
        return player;
    }

    public boolean isWin(int player){
        return WINPOINT == player;
    }

    public void startGame() {
        int player1 = 0, player2=0;
        int currentPlayer = -1;
        Scanner s = new Scanner(System.in);
        String str;
        int dicevalue = 0;
        do {
            System.out.println(currentPlayer == -1?"\n\nFIRST PLAYERTURN":"\n\nSECOND PLAYER TURN");
            System.out.println("press r to roll the Dice");
            str = s.next();
            dicevalue = rollDice();

            if (currentPlayer == -1 )
            {
                player1 = calculatePlayerVal(player1, dicevalue);
                System.out.println("First Player :: " + player1);
                System.out.println("Second Player :: " + player2);
                System.out.println("...................");
                if (isWin(player1)) {
                    System.out.println("First player wins");
                    return;
                }
            }
           else
           {
                player2 = calculatePlayerVal(player2, dicevalue);
                System.out.println("First Player :: " + player1);
                System.out.println("Second Player :: " + player2);
                System.out.println("...................");
                if (isWin(player2)) {
                    System.out.println("First player wins");
                    return;
                }
            }

            currentPlayer = -currentPlayer;

        }while ("r".equals((str)));
    }
}

public class snakeladder {

    public static void main(String[] args) {
        Snakeladd s = new Snakeladd();
        s.startGame();
        s.calculatePlayerVal();
    }
}

