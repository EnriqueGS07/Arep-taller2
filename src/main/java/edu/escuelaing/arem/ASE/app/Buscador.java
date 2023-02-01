package edu.escuelaing.arem.ASE.app;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class Buscador {
    static ConcurrentHashMap<String, String> memoria = new ConcurrentHashMap<String, String>();

    /**
     * Metodo que realiza la busqueda de la pelicula en cache y si no lo encuentra va a la api
     * @param titulo titulo de la pelicula que se busca
     * @return json de la pelicula que se busco
     * @throws IOException
     */
    public String buscarPeli(String titulo) throws IOException {
        String json;
        synchronized (memoria){
            if (memoria.containsKey(titulo)){
                json  = memoria.get(titulo);
            }else{
                json = HttpConnection.getJsonPeli(titulo);
                memoria.put(titulo, json);
            }
        }
        return json;
    }
}
