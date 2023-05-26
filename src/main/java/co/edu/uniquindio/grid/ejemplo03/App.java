package co.edu.uniquindio.grid.ejemplo03;

import java.io.PrintStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final PrintStream out = System.out;
        printString(out,"Hello World!");
    }

    public static void printString(PrintStream out,String mensaje){
        out.println(mensaje);
    }
}
