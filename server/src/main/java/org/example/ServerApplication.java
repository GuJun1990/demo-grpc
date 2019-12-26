package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.service.impl.GreeterServiceImpl;

/**
 * Hello world!
 *
 */
public class ServerApplication {

    private Server server;

    private int port = 50051;

    private void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new GreeterServiceImpl())
                .build()
                .start();
        System.out.println("Server started");
        server.awaitTermination();
    }

    public static void main( String[] args ) {
        ServerApplication serverApplication = new ServerApplication();
        try {
            serverApplication.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
