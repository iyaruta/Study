package xo.client;

import xo.client.command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Reader reader;
    private BufferedReader console;

    private String host;
    private int port;

    private List<ChatCommand> commands;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;

        commands = new ArrayList<>();
        commands.add(new ListChatCommand());
        commands.add(new PrivateChatCommand());
        commands.add(new ExitChatCommand());
        commands.add(new DefaultChatCommand());
    }

    public void start() throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //получаем данные с сервера
        out = new PrintWriter(socket.getOutputStream(), true); //отправляем данные на сервер

        reader = new Reader(in);
        new Thread(reader).start();
        process();
    }

    public void process() throws IOException {
        console = new BufferedReader(new InputStreamReader(System.in)); //

        String message;
        while ((message = console.readLine()) != null) {
            String result = null;
            for (ChatCommand command : commands) {
                result = command.process(message);
                if (result != null) {
                    out.println(result);
                    break;
                }
            }

            if ("9".equals(result)){
                break;
            }

        }

        close();
    }

    public void close() throws IOException {
        out.write(9);
        out.flush();
        out.close();
        reader.stop();
        in.close();
        console.close();
        socket.close();
    }
}
