package com.olonte.appireserva.dto;

/**
 * Created by jsgravenhorst on 10/17/2015.
 */
public class Programa {
    private String idPrograma;
    private String nombrePrograma;

    public Programa(String idPrograma, String nombrePrograma) {
        this.idPrograma = idPrograma;
        this.nombrePrograma = nombrePrograma;
    }

    public String getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(String idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String toString(){
        return  getNombrePrograma();
    }
}
