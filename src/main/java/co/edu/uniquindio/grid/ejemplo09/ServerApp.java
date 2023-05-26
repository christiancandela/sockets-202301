package co.edu.uniquindio.grid.ejemplo09;

import java.io.IOException;

/**
 * Hello world!
 */
public class ServerApp {

    public static void main(String[] args) throws IOException {
        Server server = new Server(5555, ClientHandlerImpl::new);
        server.run();
    }
}
