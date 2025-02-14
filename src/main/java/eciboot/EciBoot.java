package eciboot;

import java.io.*;
import java.net.*;

public class EciBoot {
    /**
     * Iniciar el programa
     * @param args args
     * @throws IOException Por si algo sale mal en el proceso
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RequestHandler server = RequestHandler.getInstance();

        server.run(args);
    }
}