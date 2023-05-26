package co.edu.uniquindio.grid.ejemplo08;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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
            final InputStream inServer = socket.getInputStream();
            final InputStream inKeyBoard = System.in;

            final String mensaje = readString(inServer);
            printString(outScreen, mensaje);

            final var nombre = readString(inKeyBoard);
            printString(outServer, nombre);

            final String respuesta = readString(inServer);
            printString(outScreen, respuesta);
        }
    }

    public static String readString(InputStream in){
        final Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }

    public static void printString(PrintStream out,String mensaje){
        out.println(mensaje);
    }
}
