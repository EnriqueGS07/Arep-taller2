package edu.escuelaing.arem.ASE.app;

import java.io.IOException;

public class ConcurrentTest extends Thread{

    private String titulo;
    private String info;

    public ConcurrentTest(String titulo){
        this.titulo = titulo;
    }

    @Override
    public void run() {
        Buscador buscador = new Buscador();
        try {
            this.info = buscador.buscarPeli(titulo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getInfo(){
        return this.info;
    }
}
