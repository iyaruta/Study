package xo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Client side");

        Socket fromserver = null;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        fromserver = new Socket("127.0.0.1", 8091);
        BufferedReader in = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
        PrintWriter out = new PrintWriter(fromserver.getOutputStream(), true);

        String message;
        Reader reader = new Reader(in);
        new Thread(reader).start();

        while ((message = console.readLine()) != null) {
            out.write(1);
            out.println(message);
            if (message.equalsIgnoreCase("close")) break;
            if (message.equalsIgnoreCase("exit")) break;
//            if (message.equalsIgnoreCase("private")) break;
        }

//        out.write(2);
        out.write(9);
        out.flush();
        out.close();
        reader.stop();
        in.close();
        console.close();
        fromserver.close();
    }

    public static class Reader implements Runnable {
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
                        String line = in.readLine();
                        System.out.println(line);
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
}
