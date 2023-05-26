package co.edu.uniquindio.grid.ejemplo06c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;

/**
 * Hello world!
 */
public class ServerApp {

    public static void main(String[] args) throws IOException {
        final int puerto = 5555;
        ServerSocket serverSocket = new ServerSocket(puerto);

        while( true ) {
            final var clientSocket = serverSocket.accept();

            final PrintStream out = new PrintStream(clientSocket.getOutputStream());
            final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            saludar(out, in);


            clientSocket.close();
        }
        //serverSocket.close();
    }

    public static void saludar(PrintStream out, BufferedReader in) throws IOException {
        out.println("Ingrese su nombre:");
        final var nombre = in.readLine();
        System.out.println("Respondiendo al usuario "+nombre);
        out.println("Hello "+nombre);
    }

}
