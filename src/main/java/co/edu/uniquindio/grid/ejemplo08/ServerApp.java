package co.edu.uniquindio.grid.ejemplo08;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
             final InputStream in = socket.getInputStream()) {
            saludar(out, in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saludar(PrintStream out, InputStream in) {
        printString(out, "Ingrese su nombre:");
        final var nombre = readString(in);
        printString(out, "Hello " + nombre);
    }

    public static String readString(InputStream in) {
        final Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }

    public static void printString(PrintStream out, String mensaje) {
        out.println(mensaje);
    }
}
