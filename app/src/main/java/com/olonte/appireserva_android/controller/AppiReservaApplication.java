package com.olonte.appireserva.controller;

import android.app.Application;

import com.olonte.appireserva.dto.Area;
import com.olonte.appireserva.dto.Asignatura;
import com.olonte.appireserva.dto.Bloque;
import com.olonte.appireserva.dto.Grupo;
import com.olonte.appireserva.dto.Programa;
import com.olonte.appireserva.dto.Recurso;
import com.olonte.appireserva.dto.Reserva;
import com.olonte.appireserva.dto.Sede;
import com.olonte.appireserva.dto.TipoActividad;
import com.olonte.appireserva.dto.Usuario;

import java.util.ArrayList;

/**
 * Created by jsgravenhorst on 10/17/2015.
 */
public class AppiReservaApplication extends Application{
    private ArrayList<Usuario> arrayListUsuarios;
    private ArrayList<Reserva> arrayListReservas;
    private ArrayList<Sede> arrayListSedes;
    private ArrayList<Area> arrayListAreas;
    private ArrayList<Bloque> arrayListBloques;
    private ArrayList<Programa> arrayListProgramas;
    private ArrayList<Asignatura> arrayListAsignaturas;
    private ArrayList<Grupo> arrayListGrupos;
    private ArrayList<TipoActividad> arrayListTipoActividades;
    private ArrayList<Recurso> arrayListRecursos;
    private String usuarioActual;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ArrayList<Usuario> getArrayListUsuarios() {
        return arrayListUsuarios;
    }

    public void setArrayListUsuarios(ArrayList<Usuario> arrayListUsuarios) {
        this.arrayListUsuarios = arrayListUsuarios;
    }

    public ArrayList<Reserva> getArrayListReservas() {
        return arrayListReservas;
    }

    public void setArrayListReservas(ArrayList<Reserva> arrayListReservas) {
        this.arrayListReservas = arrayListReservas;
    }

    public ArrayList<Sede> getArrayListSedes() {
        return arrayListSedes;
    }

    public void setArrayListSedes(ArrayList<Sede> arrayListSedes) {
        this.arrayListSedes = arrayListSedes;
    }

    public ArrayList<Bloque> getArrayListBloques() {
        return arrayListBloques;
    }

    public void setArrayListBloques(ArrayList<Bloque> arrayListBloques) {
        this.arrayListBloques = arrayListBloques;
    }

    public ArrayList<Area> getArrayListAreas() {
        return arrayListAreas;
    }

    public void setArrayListAreas(ArrayList<Area> arrayListAreas) {
        this.arrayListAreas = arrayListAreas;
    }

    public ArrayList<Programa> getArrayListProgramas() {
        return arrayListProgramas;
    }

    public void setArrayListProgramas(ArrayList<Programa> arrayListProgramas) {
        this.arrayListProgramas = arrayListProgramas;
    }

    public ArrayList<Asignatura> getArrayListAsignaturas() {
        return arrayListAsignaturas;
    }

    public void setArrayListAsignaturas(ArrayList<Asignatura> arrayListAsignaturas) {
        this.arrayListAsignaturas = arrayListAsignaturas;
    }

    public ArrayList<Grupo> getArrayListGrupos() {
        return arrayListGrupos;
    }

    public void setArrayListGrupos(ArrayList<Grupo> arrayListGrupos) {
        this.arrayListGrupos = arrayListGrupos;
    }

    public ArrayList<TipoActividad> getArrayListTipoActividades() {
        return arrayListTipoActividades;
    }

    public void setArrayListTipoActividades(ArrayList<TipoActividad> arrayListTipoActividades) {
        this.arrayListTipoActividades = arrayListTipoActividades;
    }

    public ArrayList<Recurso> getArrayListRecursos() {
        return arrayListRecursos;
    }

    public void setArrayListRecursos(ArrayList<Recurso> arrayListRecursos) {
        this.arrayListRecursos = arrayListRecursos;
    }

    public String getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}
