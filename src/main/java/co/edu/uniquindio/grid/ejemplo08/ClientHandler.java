package co.edu.uniquindio.grid.ejemplo08;

import java.net.Socket;

public interface ClientHandler {
    void processRequest(final Socket socket);
}
