package co.edu.uniquindio.grid.ejemplo09b;

import java.net.Socket;

public interface ClientHandler {
    void processRequest(final Socket socket);
}
