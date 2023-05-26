package co.edu.uniquindio.grid.ejemplo06b;

import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * Hello world!
 */
public class ServerApp {

    public static void main(String[] args) throws IOException {
        final int puerto = 5555;
        ServerSocket serverSocket = new ServerSocket(puerto);
        final var clientSocket = serverSocket.accept();

        final PrintStream out = new PrintStream(clientSocket.getOutputStream());
        final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        saludar(out,in);


        clientSocket.close();
        serverSocket.close();
    }

    public static void saludar(PrintStream out, BufferedReader in) throws IOException {
        out.println("Ingrese su nombre:");
        final var nombre = in.readLine();
        out.println("Hello "+nombre);
    }

}
