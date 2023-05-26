package co.edu.uniquindio.grid.ejemplo09b;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 */
public class ClientApp {
    public static void main(String[] args) throws IOException {
        final String server = "localhost";
        final int port = 5555;

        try(final var socket = new Socket(server,port)) {
            final PrintStream outScreen = System.out;
            final PrintStream outServer = new PrintStream(socket.getOutputStream());
            final BufferedReader inServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final BufferedReader inKeyBoard = new BufferedReader(new InputStreamReader(System.in));

            final String mensaje = inServer.readLine();
            outScreen.println(mensaje);

            final var nombre = inKeyBoard.readLine();
            outServer.println(nombre);

            final String respuesta = inServer.readLine();
            outScreen.println(respuesta);
        }
    }
}
