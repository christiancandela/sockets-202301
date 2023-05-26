package co.edu.uniquindio.grid.ejemplo10;

import java.net.Socket;

public interface ClientHandler {
    void processRequest(final Socket socket);
}
