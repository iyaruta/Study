package cross;

/**
 * User: Alexandr
 * Date: 29.10.2014
 */
public class Game {
    private int w;
    private int h;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;         // опесание класа
    private Player[] field;
    private boolean gameOver;
    private int steps;

    public Game(int w, int h) {
        field = new Player[w * h];
        this.w = w;
        this.h = h;
    }

//    public Player getNextPlayer(){

//    }

    public void print() {
        for (int i = 0; i < field.length; i++) {
            if (field[i] == null) {
                System.out.print("-");
            } else {
                System.out.print(field[i].getSign());
            }

            System.out.print(" ");
            if (i % w == w - 1) {
                System.out.println();
            }
        }
    }

    public boolean step(int x, int y) {
        x--;
        y--;
        int i = w * y + x;
        if (isValid(x, y) && field[i] == null) {
            field[i] = currentPlayer;
            if (isWin(x, y, currentPlayer)){
                System.out.println("YOU ARE WIIIIIIIN!!!!");
                gameOver = true;
            } else {
                currentPlayer = next();
            }
            steps++;
            if (steps == w * h) {
                gameOver = true;
                System.out.println("No winners");
            }
            return true;
        } else {
            System.out.println("Не верные кординаты");
            return false;
        }

    }

    private Player next() {
        if (playerX == currentPlayer){
            return playerO;
        }else {
            return playerX;
        }
    }

    public void add(Player p1, Player p2) {
        this.playerX = p1;
        playerO = p2;
        currentPlayer = playerX;
    }

    private boolean isWin(int x, int y, Player p) {
        return count(x, y, p, 0, 1) >= 3
                || count(x, y, p, 1, 0) >= 3
                || count(x, y, p, 1, 1) >= 3
                || count(x, y, p, 1, -1) >= 3;

//        int counter = count(x, y, p, 0, 1);
//        if (counter >= 3) {
//            return true; //победил
//        }
//
//        counter = count(x, y, p, 1, 0);
//        if (counter >= 3) {
//            return true;
//        }
//
//        counter = count(x, y, p, 1, 1);
//        if (counter >= 3) {
//            return true;
//        }
//
//        counter = count(x, y, p, 1, -1);
//        if (counter >= 3){
//            return true;
//        }
//
//        return false; // выиграша не было
    }

    private int count(int x, int y, Player p, int dx, int dy){
        return  1 + count(x, y, p, dx, dy, 1) + count(x, y, p, dx, dy, -1);
//
//        for (int i = 1; ;i++){
//            int nextX = x + dx * i;
//            int nextY = y + dy * i;
//            int a = w * nextY + nextX;
//            if (isValid(nextX, nextY) && field[a] == p) {
//                result++;
//            } else {
//                break;
//            }
//        }
//
//        for (int i = -1; ;i--){
//            int nextX = x + dx * i;
//            int nextY = y + dy * i;
//            int a = w * nextY + nextX;
//            if (isValid(nextX, nextY) && field[a] == p) {
//                result++;
//            } else {
//                break;
//            }
//        }

//        return result;
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < w && y >=0 && y < h);
    }

    private int count(int x, int y, Player p, int dx, int dy, int sign) {
        int result = 0;
        for (int i = -1; ;i--){
            int nextX = x + dx * i * sign;
            int nextY = y + dy * i * sign;
            int a = w * nextY + nextX;
            if (isValid(nextX, nextY) && field[a] == p) {
                result++;
            } else {
                break;
            }
        }

        return result;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public Player getCurrentPlayer() {
        return  currentPlayer;
    }

}