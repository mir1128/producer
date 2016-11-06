package com.data;

import org.quickserver.net.AppException;
import org.quickserver.net.server.QuickServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class DataProducerRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        QuickServer myServer = new QuickServer("com.data.CommandHandler");
        myServer.setPort(9000);
        try {
            myServer.startServer();
        } catch (AppException e) {
            System.err.println("Error in server : " + e);
        }
    }
}
