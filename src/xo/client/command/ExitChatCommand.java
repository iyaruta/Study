package xo.client.command;

/**
 * User: Alexander Rudenko
 * Date: 08.12.14
 */
public class ExitChatCommand implements ChatCommand {

    @Override
    public String getName() {
        return ":exit";
    }
    @Override
    public String process(String request){
        String result = null;
        if (request.startsWith(getName())){
            result = "9";
        }
        return result;
    }

}
