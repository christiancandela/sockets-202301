package co.edu.uniquindio.grid.ejemplo08b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Hello world!
 */
public class ServerApp {

    public static void main(String[] args) throws IOException {
        Server server = new Server(5555, () -> ServerApp::processRequest);
        server.run();
    }

    public static void processRequest(final Socket socket) {
        try (socket;
             final PrintStream out = new PrintStream(socket.getOutputStream());
             final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            saludar(out, in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saludar(PrintStream out, BufferedReader in) throws IOException {
        out.println("Ingrese su nombre:");
        final var nombre = in.readLine();
        out.println("Hello "+nombre);
    }
}
