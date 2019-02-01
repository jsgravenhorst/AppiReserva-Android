package com.olonte.appireserva.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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
import com.olonte.appireserva.util.Hora;

import java.util.Calendar;

public class FragmentReserva extends Fragment {

    private Context context;
    private AppiReservaApplication appiReservaApplication;
    private String horaSeleccionada;
    private Bundle bundle;
    private Calendar calendario;
    private  View rootView;
    private TextView textViewFecha;
    private TextView textViewHoraIni;
    private TextView textViewHoraFin;
    private Spinner spinnerSede;
    private Spinner spinnerBloque;
    private Spinner spinnerArea;
    private Spinner spinnerPrograma;
    private Spinner spinnerAsignatura;
    private Spinner spinnerGrupo;
    private Spinner spinnerTipoActividad;
    private Spinner spinnerRecurso;

    private Button buttonFecha;
    private Button buttonHoraIni;
    private Button buttonHoraFin;
    private Button buttonRserva;



    public FragmentReserva() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_reserva, container, false);
        appiReservaApplication = (AppiReservaApplication) getActivity().getApplication();
        buttonFecha   = (Button) rootView.findViewById(R.id.buttonFecha);
        buttonHoraIni = (Button)rootView.findViewById(R.id.buttonHoraIni);
        buttonHoraFin = (Button) rootView.findViewById(R.id.buttonHoraFin);
        buttonRserva  = (Button) rootView.findViewById(R.id.buttonReserva);

        textViewFecha   = (TextView) rootView.findViewById(R.id.textViewFecha);
        textViewHoraIni = (TextView) rootView.findViewById(R.id.textViewHoraIni);
        textViewHoraFin = (TextView) rootView.findViewById(R.id.textViewHoraFin);

        spinnerSede          = (Spinner) rootView.findViewById(R.id.spinnerSede);
        spinnerBloque        = (Spinner) rootView.findViewById(R.id.spinnerBloque);
        spinnerArea          = (Spinner) rootView.findViewById(R.id.spinnerArea);
        spinnerPrograma      = (Spinner) rootView.findViewById(R.id.spinnerPrograma);
        spinnerAsignatura    = (Spinner) rootView.findViewById(R.id.spinnerAsignatura);
        spinnerGrupo         = (Spinner) rootView.findViewById(R.id.spinnerGrupo);
        spinnerTipoActividad = (Spinner) rootView.findViewById(R.id.spinnerTipoActividad);
        spinnerRecurso       = (Spinner) rootView.findViewById(R.id.spinnerRecurso);

        cargarDatos();

        buttonFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        buttonHoraIni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
                horaSeleccionada = getActivity().getString(R.string.tag_hora_ini);
            }
        });

        buttonHoraFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
                horaSeleccionada = getActivity().getString(R.string.tag_hora_fin);
            }
        });

        buttonRserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog;
                alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setTitle(getActivity().getString(R.string.tag_tlt_gen_reserva));
                alertDialog.setMessage(getActivity().getString(R.string.tag_msj_reserva));
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getActivity().getString(R.string.tag_btn_conf_res),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(),
                                                getActivity().getString(R.string.tag_msj_reserva_ext),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                );
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getActivity().getString(R.string.tag_btn_cancl_res),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }
                );
                alertDialog.show();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private void showDatePicker() {
        FragmentFechaPicker fragmentFechaPicker = new FragmentFechaPicker();
        /**
         * Set Up Current Date Into dialog
         */
        calendario = Calendar.getInstance();
        bundle = new Bundle();
        bundle.putInt("annon", calendario.get(Calendar.YEAR));
        bundle.putInt("mes", calendario.get(Calendar.MONTH));
        bundle.putInt("dia", calendario.get(Calendar.DAY_OF_MONTH));
        fragmentFechaPicker.setArguments(bundle);
        /**
         * Set Call back to capture selected date
         */
        fragmentFechaPicker.setCallBack(ondateDateSetListener);
        fragmentFechaPicker.show(getFragmentManager(), "Fecha Picker");
    }

    private void showTimePicker(){
        FragmentHoraPicker fragmentHoraPicker = new FragmentHoraPicker();
        /**
         * Set Up Current Time Into dialog
         */
        calendario = Calendar.getInstance();
        bundle = new Bundle();
        bundle.putInt("hora",calendario.get(Calendar.HOUR));
        bundle.putInt("minuto", calendario.get(Calendar.MINUTE));
        fragmentHoraPicker.setArguments(bundle);
        /**
         * Set Call back to capture selected time
         */
        fragmentHoraPicker.setCallBack(onTimeSetListener);
        fragmentHoraPicker.show(getFragmentManager(),"Hora Picker");
    }


    DatePickerDialog.OnDateSetListener ondateDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int annon, int mesDelAnnon,
                              int diaDelMes) {
            String fechaStr;
            fechaStr = String.valueOf(diaDelMes) + "-" + String.valueOf(mesDelAnnon+1) + "-" + String.valueOf(annon);
            textViewFecha.setText(fechaStr);
        }
    };

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener(){
        public void onTimeSet(TimePicker view, int hora, int minuto){
            String horaStr;
            horaStr = Hora.getHoraAmPm(hora) + ":" + Hora.getMinutoCero(minuto) + String.valueOf(minuto) + " " + Hora.getAmPm(hora);
            if (horaSeleccionada.equals(getActivity().getString(R.string.tag_hora_ini))) {
                textViewHoraIni.setText(horaStr);
            }else {
                textViewHoraFin.setText(horaStr);
            }
        }
    };

    public void cargarSede(){
        ArrayAdapter<Sede> arrayAdapterSede;
        arrayAdapterSede = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,
                appiReservaApplication.getArrayListSedes());
        arrayAdapterSede.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSede.setAdapter(arrayAdapterSede);
        spinnerSede.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarBloque(){
        ArrayAdapter<Bloque> arrayAdapterBloque;
        arrayAdapterBloque = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,
                appiReservaApplication.getArrayListBloques());
        arrayAdapterBloque.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBloque.setAdapter(arrayAdapterBloque);
        spinnerBloque.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarArea() {
        ArrayAdapter<Area> arrayAdapterArea;
        arrayAdapterArea = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,
                appiReservaApplication.getArrayListAreas());
        arrayAdapterArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArea.setAdapter(arrayAdapterArea);
        spinnerArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarPrograma(){
        ArrayAdapter<Programa> arrayAdapterPrograma;
        arrayAdapterPrograma = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,
                appiReservaApplication.getArrayListProgramas());
        arrayAdapterPrograma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrograma.setAdapter(arrayAdapterPrograma);
        spinnerPrograma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarAsignatura(){
        ArrayAdapter<Asignatura> arrayAdapterAsignatura;
        arrayAdapterAsignatura = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,
                appiReservaApplication.getArrayListAsignaturas());
        arrayAdapterAsignatura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAsignatura.setAdapter(arrayAdapterAsignatura);
        spinnerAsignatura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarGrupo() {
        ArrayAdapter<Grupo> arrayAdapterGrupo;
        arrayAdapterGrupo = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,
                appiReservaApplication.getArrayListGrupos());
        arrayAdapterGrupo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGrupo.setAdapter(arrayAdapterGrupo);
        spinnerGrupo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarTipoActividad(){
        ArrayAdapter<TipoActividad> arrayAdapterTipoActividad;
        arrayAdapterTipoActividad = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,
                appiReservaApplication.getArrayListTipoActividades());
        arrayAdapterTipoActividad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoActividad.setAdapter(arrayAdapterTipoActividad);
        spinnerTipoActividad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarRecurso(){
        ArrayAdapter<Recurso> arrayAdapterRecurso;
        arrayAdapterRecurso = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,
                appiReservaApplication.getArrayListRecursos());
        arrayAdapterRecurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRecurso.setAdapter(arrayAdapterRecurso);
        spinnerRecurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarDatos(){
        cargarSede();
        cargarBloque();
        cargarArea();
        cargarPrograma();
        cargarAsignatura();
        cargarGrupo();
        cargarTipoActividad();
        cargarRecurso();
    }


}
