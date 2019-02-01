package com.olonte.appireserva.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.olonte.appireserva.R;
import com.olonte.appireserva.controller.AppiReservaApplication;
import com.olonte.appireserva.dto.Area;
import com.olonte.appireserva.dto.Asignatura;
import com.olonte.appireserva.dto.Bloque;
import com.olonte.appireserva.dto.Grupo;
import com.olonte.appireserva.dto.Programa;
import com.olonte.appireserva.dto.Recurso;
import com.olonte.appireserva.dto.Sede;
import com.olonte.appireserva.dto.TipoActividad;
import com.olonte.appireserva.dto.Usuario;
import com.olonte.appireserva.fragments.FragmentInicio;
import com.olonte.appireserva.fragments.FragmentLogueo;
import com.olonte.appireserva.listener.OnAppiReservaClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnAppiReservaClickListener {
    private AppiReservaApplication appiReservaApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        appiReservaApplication = (AppiReservaApplication) getApplication();
        cargarDatos();
        FragmentInicio fragmentInicio = new FragmentInicio();
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container,fragmentInicio)
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickInicio() {
        FragmentLogueo fragmentLogueo;
        fragmentLogueo = new FragmentLogueo();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragmentLogueo)
                .commit();
    }

    public void cargarDatos(){
        cargarUsuario();
        cargarSede();
        cargarBloque();
        cargarArea();
        cargarPrograma();
        cargarAsignatura();
        cargarGrupo();
        cargarTipoActividad();
        cargarRecurso();
    }

    public void cargarUsuario(){
        ArrayList<Usuario> arrayListUsuarios;
        arrayListUsuarios = new ArrayList<>();
        Usuario usuario;
        usuario = new Usuario("1","Johann S. Gravenhors R.","jsg","123");
        arrayListUsuarios.add(usuario);
        usuario = new Usuario("2","James E. Millan B.","jem","123");
        arrayListUsuarios.add(usuario);
        usuario = new Usuario("3","Fernando Montoya","fem","123");
        arrayListUsuarios.add(usuario);
        appiReservaApplication.setArrayListUsuarios(arrayListUsuarios);
    }

    public void cargarSede(){
        ArrayList<Sede> arrayListSedes;
        Sede sede;
        arrayListSedes = new ArrayList<>();
        sede = new Sede("0","Seleccionar...");
        arrayListSedes.add(sede);
        sede = new Sede("1","Cali");
        arrayListSedes.add(sede);
        sede = new Sede("2","Palmira");
        arrayListSedes.add(sede);
        sede = new Sede("3","Tulua");
        arrayListSedes.add(sede);
        appiReservaApplication.setArrayListSedes(arrayListSedes);
    }

    public void cargarBloque(){
        ArrayList<Bloque> arrayListBloques;
        Bloque bloque;
        arrayListBloques = new ArrayList<>();
        bloque = new Bloque("0","Seleccionar...");
        arrayListBloques.add(bloque);
        bloque = new Bloque("1","Fundadores");
        arrayListBloques.add(bloque);
        bloque = new Bloque("2","El Lago");
        arrayListBloques.add(bloque);
        bloque = new Bloque("3","Bliblioteca");
        arrayListBloques.add(bloque);
        appiReservaApplication.setArrayListBloques(arrayListBloques);
    }
    public void cargarArea(){
        ArrayList<Area> arrayListAreas;
        Area area;
        arrayListAreas = new ArrayList<>();
        area = new Area("0","Seleccionar...");
        arrayListAreas.add(area);
        area = new Area("1","Informatica y Computacion");
        arrayListAreas.add(area);
        area = new Area("2","Ciencias Economicas");
        arrayListAreas.add(area);
        area = new Area("3","Lenguas Modernas");
        arrayListAreas.add(area);
        appiReservaApplication.setArrayListAreas(arrayListAreas);
    }
    public void cargarPrograma(){
        ArrayList<Programa> arrayListProgramas;
        Programa programa;
        arrayListProgramas = new ArrayList<>();
        programa = new Programa("0","Seleccionar...");
        arrayListProgramas.add(programa);
        programa = new Programa("1","Ingenieria de Sistemas");
        arrayListProgramas.add(programa);
        programa = new Programa("2","Ingenieria de Electronica");
        arrayListProgramas.add(programa);
        programa = new Programa("3","Administgracion de Empresas");
        arrayListProgramas.add(programa);
        appiReservaApplication.setArrayListProgramas(arrayListProgramas);
    }

    public void cargarAsignatura(){
        ArrayList<Asignatura> arrayListAsignaturas;
        Asignatura asignatura;
        arrayListAsignaturas = new ArrayList<>();
        asignatura = new Asignatura("0","Seleccionar...");
        arrayListAsignaturas.add(asignatura);
        asignatura = new Asignatura("1","Programacion I");
        arrayListAsignaturas.add(asignatura);
        asignatura = new Asignatura("2","Administracion II");
        arrayListAsignaturas.add(asignatura);
        asignatura = new Asignatura("3","Fisica I");
        arrayListAsignaturas.add(asignatura);
        appiReservaApplication.setArrayListAsignaturas(arrayListAsignaturas);
    }

    public void cargarGrupo(){
        ArrayList<Grupo> arrayListGrupos;
        Grupo grupo;
        arrayListGrupos = new ArrayList<>();
        grupo = new Grupo("0","Seleccionar...");
        arrayListGrupos.add(grupo);
        grupo = new Grupo("1","Grupo 01");
        arrayListGrupos.add(grupo);
        grupo = new Grupo("2","Grupo 02");
        arrayListGrupos.add(grupo);
        grupo = new Grupo("3","Grupo 03");
        arrayListGrupos.add(grupo);
        appiReservaApplication.setArrayListGrupos(arrayListGrupos);
    }
    public void cargarTipoActividad(){
        ArrayList<TipoActividad> arrayListTipoActividades;
        TipoActividad tipoActividad;
        arrayListTipoActividades = new ArrayList<>();
        tipoActividad = new TipoActividad("0","Seleccionar...");
        arrayListTipoActividades.add(tipoActividad);
        tipoActividad = new TipoActividad("1","Conferencia");
        arrayListTipoActividades.add(tipoActividad);
        tipoActividad = new TipoActividad("2","Exposicion");
        arrayListTipoActividades.add(tipoActividad);
        tipoActividad = new TipoActividad("3","Video Conferencia");
        arrayListTipoActividades.add(tipoActividad);
        appiReservaApplication.setArrayListTipoActividades(arrayListTipoActividades);
    }

    public void cargarRecurso(){
        ArrayList<Recurso> arrayListRecurso;
        Recurso recurso;
        arrayListRecurso = new ArrayList<>();
        recurso = new Recurso("0","Seleccionar...");
        arrayListRecurso.add(recurso);
        recurso = new Recurso("1","Audivisuales 101 Cap = 20");
        arrayListRecurso.add(recurso);
        recurso = new Recurso("2","Audivisuales 102 Cap = 25");
        arrayListRecurso.add(recurso);
        recurso = new Recurso("3","Audivisuales 103 Cap = 30");
        arrayListRecurso.add(recurso);
        appiReservaApplication.setArrayListRecursos(arrayListRecurso);
    }

}
