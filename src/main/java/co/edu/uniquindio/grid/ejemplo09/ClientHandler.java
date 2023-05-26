package co.edu.uniquindio.grid.ejemplo09;

import java.net.Socket;

public interface ClientHandler {
    void processRequest(final Socket socket);
}
