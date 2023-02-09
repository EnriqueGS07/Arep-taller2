package edu.escuelaing.arem.ASE.app;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Clase que hace de servidor web y ser la fachada para que el usuario interactue con la aplicacion
 */
public class HttpServer {


    private static HttpServer _instance = new HttpServer();
    private Map<String, Service> services = new HashMap<>();


    public static HttpServer getInstance() {
        return _instance;
    }

    private String executeService(String serviceName) {
        Service rs = services.get(serviceName);
        String header = rs.getHeader();
        String body = rs.getResponse();
        return header + body;
    }

    public void addService(String key, Service service) {
        services.put(key, service);
    }

    public void run() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while(running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine;

            boolean first_line = true;
            String request = "/simple";
            while ((inputLine = in.readLine()) != null) {
                if (first_line) {
                    request = inputLine.split(" ")[1];
                    first_line = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            if (request.startsWith("/apps/")) {
                outputLine = executeService(request.substring(5));
                //outputLine = jsonSimple();
            }else{
                outputLine = "HTTP/1.1 200 OK\r\n" +
                        "Content-type: text/html\r\n" +
                        "\r\n" +
                        "<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title>Title of the document</title>\n"
                        + "</head>"
                        + "<body>"
                        + "My Web Site"
                        + "</body>"
                        + "</html>";
            }
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }
}
