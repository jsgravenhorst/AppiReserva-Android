package com.olonte.appireserva.dto;

/**
 * Created by jsgravenhorst on 10/17/2015.
 */
public class TipoActividad {
    private String idTipoActividad;
    private String nombreTipoActividad;

    public TipoActividad(String idTipoActividad, String nombreTipoActividad) {
        this.idTipoActividad = idTipoActividad;
        this.nombreTipoActividad = nombreTipoActividad;
    }

    public String getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(String idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public String getNombreTipoActividad() {
        return nombreTipoActividad;
    }

    public void setNombreTipoActividad(String nombreTipoActividad) {
        this.nombreTipoActividad = nombreTipoActividad;
    }

    public String toString() {
        return getNombreTipoActividad();
    }
}
