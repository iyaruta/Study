package xo.client;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * User: Alexander Rudenko
 * Date: 07.12.14
 */
public class Reader implements Runnable {

    boolean active = true;
    BufferedReader in;

    public Reader(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (active) {
            try {
                if (in.ready()) {
                    String serverMessage = in.readLine();
                    System.out.println(serverMessage);
                }
            } catch (IOException e) {
                System.out.println("Error on read");
            }
        }
    }

    public void stop() {
        active = false;
    }
}
