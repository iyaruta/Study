package xo.client;

import java.io.IOException;

/**
 * User: Alexander Rudenko
 * Date: 07.12.14
 */
public class ClientMain {

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1", 8091);
        client.start();
    }

}
