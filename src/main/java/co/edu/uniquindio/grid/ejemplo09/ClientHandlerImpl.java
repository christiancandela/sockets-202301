package co.edu.uniquindio.grid.ejemplo09;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandlerImpl implements ClientHandler {
    @Override
    public void processRequest(Socket socket) {
        try (socket;
             final PrintStream out = new PrintStream(socket.getOutputStream());
             final Scanner in = new Scanner(socket.getInputStream())
        ) {
            out.println("Ingrese su nombre:");
            final var nombre = in.nextLine();
            out.println("Hello " + nombre);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
