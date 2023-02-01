package edu.escuelaing.arem.ASE.app;

import junit.framework.TestCase;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Rigourous Test :-)
     */
    public void testDeberiaBuscar() throws IOException {
        Buscador buscador = new Buscador();
        String[] listaPruebas = {"pele", "hola", "avatar", "jhon", "avengers", "rock", "cars", "lola"};
        String titulo = listaPruebas[(int)Math.random()*listaPruebas.length];
        String info = buscador.buscarPeli(titulo);
        JSONObject json = new JSONObject(info);
        assertTrue(json.getString(("Title")).toLowerCase().contains(titulo));
    }

    public void testNoExistePelicula() throws IOException {
        Buscador buscador = new Buscador();
        String titulo = "saddsa";
        String info = buscador.buscarPeli(titulo);
        JSONObject json = new JSONObject(info);
        assertEquals(json.getString(("Response")), "False");
    }

    public void testNoInsertoNombre() throws IOException {
        Buscador buscador = new Buscador();
        String titulo = "";
        String info = buscador.buscarPeli(titulo);
        JSONObject json = new JSONObject(info);
        assertEquals(json.getString(("Error")), "Incorrect IMDb ID.");
    }
}
