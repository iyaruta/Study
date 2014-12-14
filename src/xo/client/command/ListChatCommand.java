package xo.client.command;

import java.util.List;

/**
 * User: Alexander Rudenko
 * Date: 07.12.14
 */
public class ListChatCommand implements ChatCommand  {

    @Override
    public String getName() {
        return ":list";
    }

    @Override
    public String process(String request) {
        String result = null;
        if (request.startsWith(getName())) {
            result = "2";
        }

        return result;
    }
}

