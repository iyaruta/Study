package xo.client;

import xo.client.command.ChatCommand;
import xo.client.command.ListChatCommand;
import xo.client.command.PrivateChatCommand;

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
            for (ChatCommand command : commands) {
                String result = command.process(message);
                if (result != null) {
                    out.println(result);
                    break;
                }
            }






            out.write(1);
            out.println(message);
            if (message.equalsIgnoreCase("close")) break;
            if (message.equalsIgnoreCase("exit")) break;
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
