package xo;

import xo.client.command.ChatCommand;
import xo.client.command.ListChatCommand;
import xo.client.command.PrivateChatCommand;

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

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in)); //

        String message;
        while ((message = console.readLine()) != null) {
            for (ChatCommand command : commands) {
                String result = command.process(message);
                if (result != null) {
                    System.out.println(result);
                    break;
                }
            }
        }
    }

}
