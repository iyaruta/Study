package io;

import java.net.Socket;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: Alexandr
 * Date: 27.11.2014
 */                                                           //тут будем пересылать сообщения если надо

public class ChatManager implements Runnable{

    Queue<Socket> registrations = new ArrayBlockingQueue<>(10);
    Map<String, User> users = new ConcurrentHashMap<>();


    public void run() {
        while (true) {
            for (Socket socket : registrations) {
                //тут будем регистрировать пользователя (запросим имя)
            }

            for (Map.Entry<String, User> userEntry : users.entrySet()) {
                //тут будем пересылать сообщения если надо

            }



        }
    }

    public void add(Socket socket){
        registrations.add(socket);
    }

}
