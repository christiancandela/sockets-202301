package co.edu.uniquindio.grid.ejemplo10;

import java.io.IOException;

/**
 * Hello world!
 */
public class ServerApp {

    public static void main(String[] args) throws IOException {
        Server server = new Server(5555, 10,ClientHandlerImpl::new);
        server.run();
    }
}
