package xo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Game implements Runnable {

    Map<String, Player> players = new ConcurrentHashMap<>();

    @Override
    public void run() {
        try {
            while (true) {
                for (Map.Entry<String, Player> entry : players.entrySet()) {
                    Player player = entry.getValue();
                    if (!player.in.ready()) {
                        continue;
                    }

                    BufferedReader in = player.in;
                    PrintWriter out = player.out;

                    int operation = in.read();
                    String message;
//                    if (operation == 2){
//                        String input = in.readLine();
//                        message =entry.getKey() + ":" + input;
//                        send(message);
//                    }
                    if (operation == 9) {
                        message = entry.getKey() + " leave us";
                        send(message);
                        shutdown(player);
                        players.remove(entry.getKey());
                    } else {
                        if (in.ready()) {
                            String input = in.readLine();
                            message = entry.getKey() + ": " + input;
                            send(message);
                        }
                    }


                }
            }
        } catch (Exception e) {
            System.out.println("Fatal error!");
        }
    }

    private void send(String message) {
        System.out.println(message);
        for (Player player1 : players.values()) {
            player1.out.println(message);
        }
    }

    private void shutdown(Player player) throws IOException {
        player.in.close();
        player.out.close();
        player.socket.close();
    }

    public void add(Socket socket) throws IOException {
        Player player = new Player(socket);
        player.in.read();
        String username = player.in.readLine();
        players.put(username, player);
        player.out.println("Welcome " + username);
    }

    private static class Player {
        final Socket socket;
        final BufferedReader in;
        final PrintWriter out;

        private Player(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }



    }
}
