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

                    String request = in.readLine();
                    if (request.isEmpty()) {
                        continue;
                    }

                    int operation = Integer.valueOf(request.substring(0, 1));
                    switch (operation) {
                        case 2:
                            out.println(list());
                            break;
                        case 3:
                            String rq = request.substring(1);
                            String[] privateRequest = rq.split("\\$");
                            Player recipient = players.get(privateRequest[0]);
                            if (recipient == null) {
                                out.println("User not found");
                            } else {
                                recipient.out.println(entry.getKey() + ": " + privateRequest[1]);
                                out.println(entry.getKey() + ": " + privateRequest[1]);
                            }
                            break;
                        case 4:
                            String publicMessage = request.substring(1);
                            send(entry.getKey() + ": " + publicMessage);
                            break;
                        case 9:
                            String message = entry.getKey() + " leave us";
                            send(message);
                            shutdown(player);
                            players.remove(entry.getKey());
                            break;
                        default:
                            out.println("Error: invalid message");
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

    private String list() {
        String result = "Users online: ";
        for (String username : players.keySet()) {
            result += username + " | ";
        }

        return result;
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
