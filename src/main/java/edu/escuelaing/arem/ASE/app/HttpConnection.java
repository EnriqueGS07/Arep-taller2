package edu.escuelaing.arem.ASE.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *Clase que se encarga de conectarse a la api
 */
public class HttpConnection {

    private static final String USER_AGENT = "Mozilla/5.0";
//    private static final String GET_URL = " http://www.omdbapi.com/?i=tt3896198&apikey=a0da254d";

    /**
     * Metodo que obtiene un JSON con la informacion de la pelicula que se desee
     * @param titulo titulo de busqueda a la aAPI externa de peliculas
     * @return JSON con toda la informacion de la pelicula que se busca
     * @throws IOException
     */
    public static String getJsonPeli(String titulo) throws IOException {
        URL obj = new URL("http://www.omdbapi.com/?t=" + titulo + "&apikey=a0da254d");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        } else {
            return "GET request not worked";
        }


    }

}
