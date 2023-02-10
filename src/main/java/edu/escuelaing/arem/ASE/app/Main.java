package edu.escuelaing.arem.ASE.app;

import java.io.IOException;

public class Main {

    /**
     * Metodo que agrega los servicios y corre el servidor
     * @param args
     * @throws IOException
     */
        public static void main(String[] args) throws IOException {
            HttpServer server = HttpServer.getInstance();
            server.addService("/pagina", new HTMLService());
            server.addService("/styles.css", new StyleService());
            server.addService("/app.js", new JsService());
            server.addService("/imagen.jpg", new JpgService());
            server.addService("/notFound", new NotFound());
            server.run();
        }

}
