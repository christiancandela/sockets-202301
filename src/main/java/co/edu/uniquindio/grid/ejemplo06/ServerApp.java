package co.edu.uniquindio.grid.ejemplo06;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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
        final InputStream in = clientSocket.getInputStream();


        saludar(out,in);


        clientSocket.close();
        serverSocket.close();
    }

    public static void saludar(PrintStream out, InputStream in) {
        printString(out,"Ingrese su nombre:");
        final var nombre = readString(in);
        printString(out,"Hello "+nombre);
    }

    public static String readString(InputStream in){
        final Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }

    public static void printString(PrintStream out,String mensaje){
        out.println(mensaje);
    }
}
