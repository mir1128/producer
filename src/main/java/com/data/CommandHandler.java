package com.data;

import org.apache.commons.io.IOUtils;
import org.quickserver.net.server.ClientCommandHandler;
import org.quickserver.net.server.ClientHandler;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class CommandHandler implements ClientCommandHandler {
    private String data;

    public CommandHandler() {
        try {
            data = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("data1.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleCommand(ClientHandler clientHandler, String s) throws SocketTimeoutException, IOException {

    }

    @Override
    public void gotConnected(ClientHandler clientHandler) throws SocketTimeoutException, IOException {
        while (true) {
            clientHandler.sendClientMsg(data);
            System.out.println("sending message...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void lostConnection(ClientHandler clientHandler) throws IOException {

    }

    @Override
    public void closingConnection(ClientHandler clientHandler) throws IOException {

    }


}
