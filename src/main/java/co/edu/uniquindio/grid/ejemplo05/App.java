package co.edu.uniquindio.grid.ejemplo05;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final PrintStream out = System.out;
        final InputStream in = System.in;

        saludar(out, in);
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
