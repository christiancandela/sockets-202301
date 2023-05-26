package co.edu.uniquindio.grid.ejemplo09b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandlerImpl implements ClientHandler {
    @Override
    public void processRequest(Socket socket) {
        try (socket;
             final PrintStream out = new PrintStream(socket.getOutputStream());
             final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            out.println("Ingrese su nombre:");
            final var nombre = in.readLine();
            out.println("Hello " + nombre);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
