package co.edu.uniquindio.grid.ejemplo07;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 */
public class ClientApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final String server = "localhost";
        final int port = 5555;

        try(final var socket = new Socket(server,port)) {
            final ObjectOutputStream outServer = new ObjectOutputStream(socket.getOutputStream());
            final ObjectInputStream inServer = new ObjectInputStream(socket.getInputStream());
            final InputStream inKeyBoard = System.in;

            final var mensaje = (String) inServer.readObject();
            System.out.println(mensaje);

            final var nombre = readString(inKeyBoard);
            outServer.writeObject(nombre);

            final var respuesta = (String) inServer.readObject();
            System.out.println(respuesta);
        }
    }

    public static String readString(InputStream in){
        final Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }
}
