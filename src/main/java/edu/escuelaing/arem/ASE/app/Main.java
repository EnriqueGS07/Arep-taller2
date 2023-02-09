package edu.escuelaing.arem.ASE.app;

import java.io.IOException;

public class Main {


        public static void main(String[] args) throws IOException {
            HttpServer server = HttpServer.getInstance();
            server.addService("/pagina", new HTMLService());
            server.addService("/estilos", new StyleService());
            server.addService("/script", new JsService());
            server.run();
        }

}
