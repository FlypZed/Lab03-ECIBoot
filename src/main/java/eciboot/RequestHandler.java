package eciboot;

import java.io.*;
import java.net.*;


class RequestHandler{
    private static RequestHandler instance;

    /**
     * Obtiene la instancia única del servidor (Patrón Singleton).
     * @return Instancia de HttpServer
     */
    public static RequestHandler getInstance() {
        if (instance == null){
            instance = new RequestHandler();
        }
        return instance;
    }

    /**
     * Inicia el servidor y escucha peticiones en el puerto 35000.
     * @param args Argumentos de la línea de comandos
     * @throws IOException Si ocurre un error al iniciar el servidor
     */
    public void run(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = null;
        IoCFramework.loadControllers();

        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 8080.");
            System.exit(1);
        }

        boolean running = true;

        while(running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir desde el puerto: 8080");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String requestLine = in.readLine();
            if (requestLine == null) return;

            String[] parts = requestLine.split(" ");
            String path = parts[1];

            out.println(IoCFramework.handleRequest(path));

            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

}