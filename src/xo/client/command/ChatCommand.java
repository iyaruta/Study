package xo.client.command;

/**
 * User: Alexander Rudenko
 * Date: 07.12.14
 */
public interface ChatCommand {

    String getName();

    String process(String request);
}
