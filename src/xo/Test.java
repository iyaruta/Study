package xo;

import xo.client.command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Alexander Rudenko
 * Date: 07.12.14
 */
public class Test {

    public static void main(String[] args) throws IOException {
        List<ChatCommand> commands = new ArrayList<>();
        commands.add(new ListChatCommand());
        commands.add(new PrivateChatCommand());
        commands.add(new ExitChatCommand());
        commands.add(new DefaultChatCommand());

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in)); //

        String message;
        while ((message = console.readLine()) != null) {
            String result = null;
            for (ChatCommand command : commands) {
                result = command.process(message);
                if (result != null) {
                    System.out.println(result);
                    break;
                }
            }

            if ("9".equals(result)) {
                break;

            }
        }
    }

}
