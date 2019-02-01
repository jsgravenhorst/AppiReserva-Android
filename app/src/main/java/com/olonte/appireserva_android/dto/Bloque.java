package com.olonte.appireserva.dto;

/**
 * Created by jsgravenhorst on 10/17/2015.
 */
public class Bloque {
    private String idBloque;
    private String nombreBloque;

    public Bloque(String idBloque, String nombreBloque) {
        this.idBloque = idBloque;
        this.nombreBloque = nombreBloque;
    }

    public String getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(String idBloque) {
        this.idBloque = idBloque;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public void setNombreBloque(String nombreBloque) {
        this.nombreBloque = nombreBloque;
    }

    public String toString(){
        return getNombreBloque();
    }
}
