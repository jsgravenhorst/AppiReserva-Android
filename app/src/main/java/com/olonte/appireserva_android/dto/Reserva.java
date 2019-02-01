package com.olonte.appireserva.dto;

import java.util.Date;

/**
 * Created by jsgravenhorst on 10/17/2015.
 */
public class Reserva {
    private String idReserva;
    private String idSede;
    private String idBloque;
    private String idArea;
    private String idPrograma;
    private String idAsignatura;
    private String idGrupo;
    private String idTipoActividad;
    private String idRecurso;
    private Date   fechaReserva;

    public Reserva(String idReserva, String idSede, String idBloque, String idArea, String idPrograma, String idAsignatura, String idGrupo, String idTipoActividad, String idRecurso, Date fechaReserva) {
        this.idReserva = idReserva;
        this.idSede = idSede;
        this.idBloque = idBloque;
        this.idArea = idArea;
        this.idPrograma = idPrograma;
        this.idAsignatura = idAsignatura;
        this.idGrupo = idGrupo;
        this.idTipoActividad = idTipoActividad;
        this.idRecurso = idRecurso;
        this.fechaReserva = fechaReserva;
    }
}
