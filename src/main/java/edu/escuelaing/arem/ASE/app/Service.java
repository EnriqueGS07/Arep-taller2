package edu.escuelaing.arem.ASE.app;

public interface Service {
    /**
     * Metodo que retorna un header con status ok dependiendo del tipo de archivo
     * @return Header HTTP status ok
     */
    public String getHeader();

    /**
     * Metodo que retorna el cuerpo del archivo
     * @return archivo en texto o binario
     */
    public String getResponse();
}
