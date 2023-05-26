package co.edu.uniquindio.grid.ejemplo08;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.function.Supplier;

public class Server {
    private final int port;
    private final ServerSocket serverSocket;
    private final Supplier<ClientHandler> supplier;
    private boolean running;

    public Server(int port, Supplier<ClientHandler> supplier) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
        this.supplier = supplier;
    }

    public void run() throws IOException {
        running = true;
        while(running){
            final var socket = serverSocket.accept();
            new Thread( ()->supplier.get().processRequest(socket) ).start();
        }
        serverSocket.close();
    }

    public void stop(){
        running = false;
    }
}
