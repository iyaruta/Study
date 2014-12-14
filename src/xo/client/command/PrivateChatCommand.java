package xo.client.command;


/**
 * User: Alexander Rudenko
 * Date: 07.12.14
 */
public class PrivateChatCommand implements ChatCommand {

    @Override
    public String getName() {
        return ":to";
    }

    @Override
    public String process(String request) {
        String result = null;
        if (request.startsWith(getName())){
            String str = request.replaceFirst(getName(), "");
            str = "3" + str.trim();
            result = str.replaceFirst(":", "\\$");
        }

        return result;
    }

}
