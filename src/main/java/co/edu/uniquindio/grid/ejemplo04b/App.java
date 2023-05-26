package co.edu.uniquindio.grid.ejemplo04b;

import java.io.*;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        final PrintStream out = System.out;
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        out.println("Ingrese su nombre:");
        final var nombre = in.readLine();
        out.println("Hello "+nombre);
    }
}
