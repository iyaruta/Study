package xo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8091);
        Game game = new Game();
        new Thread(game).start();
        while (true) {
            Socket client = server.accept();
            game.add(client);
        }
    }
}
