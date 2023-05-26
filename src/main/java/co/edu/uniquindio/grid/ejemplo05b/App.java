package co.edu.uniquindio.grid.ejemplo05b;

import java.io.*;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        final PrintStream out = System.out;
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        saludar(out, in);
    }

    public static void saludar(PrintStream out, BufferedReader in) throws IOException {
        out.println("Ingrese su nombre:");
        final var nombre = in.readLine();
        out.println("Hello "+nombre);
    }
}
