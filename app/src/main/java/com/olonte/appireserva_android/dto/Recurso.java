package com.olonte.appireserva.dto;

/**
 * Created by jsgravenhorst on 10/17/2015.
 */
public class Recurso {
    private String idRecurso;
    private String nombreRecurso;
    private String capacidadRecurso;

    public Recurso(String idRecurso, String nombreRecurso, String capacidadRecurso) {
        this.idRecurso = idRecurso;
        this.nombreRecurso = nombreRecurso;
        this.capacidadRecurso = capacidadRecurso;
    }

    public Recurso(String idRecurso, String nombreRecurso ) {
        this.idRecurso = idRecurso;
        this.nombreRecurso = nombreRecurso;
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getCapacidadRecurso() {
        return capacidadRecurso;
    }

    public void setCapacidadRecurso(String capacidadRecurso) {
        this.capacidadRecurso = capacidadRecurso;
    }

    public String toString(){
        return getNombreRecurso();
    }
}
