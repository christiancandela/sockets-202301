package co.edu.uniquindio.grid.ejemplo07b;

import java.io.*;
import java.net.Socket;

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
            final BufferedReader inKeyBoard = new BufferedReader(new InputStreamReader(System.in));

            final var mensaje = (String) inServer.readObject();
            System.out.println(mensaje);

            final var nombre = inKeyBoard.readLine();
            outServer.writeObject(nombre);

            final var respuesta = (String) inServer.readObject();
            System.out.println(respuesta);
        }
    }
}
