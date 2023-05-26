package co.edu.uniquindio.grid.ejemplo07;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

/**
 * Hello world!
 */
public class ServerApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final int puerto = 5555;
        ServerSocket serverSocket = new ServerSocket(puerto);
        final var clientSocket = serverSocket.accept();

        final ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
        final ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());


        saludar(out,in);


        clientSocket.close();
        serverSocket.close();
    }

    public static void saludar(ObjectOutputStream out, ObjectInputStream in) throws IOException, ClassNotFoundException {
        out.writeObject("Ingrese su nombre:");
        final var nombre = in.readObject();
        out.writeObject("Hello "+nombre);
    }
}
