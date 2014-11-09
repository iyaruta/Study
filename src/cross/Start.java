package cross;

import java.util.Scanner;

/**
 * User: Alexandr
 * Date: 29.10.2014
 */
public class Start {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game(3, 3);
        String name1 = sc.next();
        Player player1 = new Player(name1, 'X');
        Player player2 = new Player(sc.next(), 'O');
        game.add(player1, player2);

        while (!game.isGameOver()) {
            game.print();
            Player player = game.getCurrentPlayer();
            System.out.println("Ходит " + player.getName());
            System.out.print("X:");
            int x = sc.nextInt();
            System.out.print("Y:");
            int y = sc.nextInt();
            game.step(x, y);
        }



//        System.out.println(game.step(1, 1, p));
//        System.out.println(game.step(1, 2, p));
//        System.out.println(game.step(1, 3, p));
//        game.print();

    }

    public static void show() {
        System.out.println("Ведите параметры");
    }
}
