package xo.client.command;

/**
 * User: Alexander Rudenko
 * Date: 08.12.14
 */
public class DefaultChatCommand implements ChatCommand {

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String process(String request) {
//        if (request.length() == 0) {
//            return null;
//        } else {
//            return "4" + request;
//        }
        return request.length() == 0 ? null : "4" + request;
    }
}
