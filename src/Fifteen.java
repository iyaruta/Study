import java.util.Scanner;

/**
 * User: Alexandr
 * Date: 22.09.2014
 */
public class Fifteen {

    //Поле
    int[] game;

    //Конструктор
    public Fifteen() {
        game = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    }

    //Метод
    public void move(int number) {
        int t = find(number);

        if((t - 4 >= 0) && (game[t-4] == 0)){
            game[t-4] = game[t];
            game[t] = 0;
        } else if ((t + 4 <= 15) && (game[t+4] == 0)) {
            game[t + 4] = game[t];
            game[t] = 0;
        } else if (t%4 != 3 && game[t+1] == 0){
            game[t+1] = game[t];
            game[t] = 0;
        } else if (t%4 != 0 && game[t-1] == 0) {
            game[t-1] = game[t];
            game[t] = 0;
        }
    }

    public void print() {
        for (int i = 0; i < game.length; i++) {
            if (game[i] == 0){
                System.out.print("_ ");
            }else {
                System.out.print(game[i] + " ");
            }
            if (game[i] < 10){
                System.out.print(" ");
            }
            if (i % 4 == 3){
                System.out.println();
            }
        }
    }

    public boolean isWin() {
        return false;
    }

    private int find(int number) {
        for(int i = 0; i < game.length; i++) {
            if (game[i] == number) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Fifteen fifteen = new Fifteen();
        Scanner sc = new Scanner(System.in);
        while (!fifteen.isWin()) {
            fifteen.print();
            int input = sc.nextInt();
            fifteen.move(input);
        }

        System.out.println("Congratulation! You win!");
    }



}
