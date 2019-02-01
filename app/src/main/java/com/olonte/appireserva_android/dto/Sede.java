package com.olonte.appireserva.dto;

/**
 * Created by jsgravenhorst on 10/17/2015.
 */
public class Sede {
    private String idSede;
    private String nombreSede;

    public Sede(String idSede, String nombreSede) {
        this.idSede = idSede;
        this.nombreSede = nombreSede;
    }

    public String getIdSede() {
        return idSede;
    }

    public void setIdSede(String idSede) {
        this.idSede = idSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String toString(){
       return getNombreSede();
    }
}
