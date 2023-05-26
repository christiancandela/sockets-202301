package co.edu.uniquindio.grid.ejemplo10;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Server {
    private final int port;
    private final ServerSocket serverSocket;
    private final Supplier<ClientHandler> supplier;
    private boolean running;

    private final ExecutorService executorService;

    public Server(int port,int sizePool, Supplier<ClientHandler> supplier) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
        this.supplier = supplier;
         executorService = Executors.newFixedThreadPool(sizePool);
    }

    public void run() throws IOException {
        running = true;
        while(running){
            final var socket = serverSocket.accept();
            executorService.execute( ()->supplier.get().processRequest(socket) );
        }
        serverSocket.close();
    }

    public void stop(){
        running = false;
        executorService.shutdown();
    }
}
