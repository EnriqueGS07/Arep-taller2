package edu.escuelaing.arem.ASE.app;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Clase que se encarga de hacer la petición a la api o al cache en caso de que se haya buscado antes
 */
public class Buscador {
    static ConcurrentHashMap<String, String> memoria = new ConcurrentHashMap<String, String>();

    /**
     * Metodo que realiza la busqueda de la pelicula en caché y si no lo encuentra va a la api
     * @param titulo titulo de la pelicula que se busca
     * @return json de la pelicula que se buscó
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
