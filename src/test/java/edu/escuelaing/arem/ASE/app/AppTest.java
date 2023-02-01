package edu.escuelaing.arem.ASE.app;

import junit.framework.TestCase;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    private ArrayList<ConcurrentTest> hilosTest = new ArrayList<ConcurrentTest>();
    private ArrayList<Integer> posiciones = new ArrayList<Integer>();
    private String[] listaPruebas = {"pele", "hola", "avatar", "jhon", "avengers", "rock", "cars", "lola"};
    /**
     * Prueba para verificar
     */
    public void testDeberiaBuscar() throws InterruptedException {
        for (int i=0; i<10; i++){
            int posicion = (int)Math.random()*listaPruebas.length;
            posiciones.add(posicion);
            String titulo = listaPruebas[posicion];
            hilosTest.add(new ConcurrentTest(titulo));
        }
        for (ConcurrentTest c : hilosTest){
            c.start();
        }
        boolean pasoPrueba = true;
        for (int i=0; i<10; i++){
            hilosTest.get(i).join();
            JSONObject json = new JSONObject(hilosTest.get(i).getInfo());
            pasoPrueba = json.getString(("Title")).toLowerCase().contains(listaPruebas[posiciones.get(i)]);
        }

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
