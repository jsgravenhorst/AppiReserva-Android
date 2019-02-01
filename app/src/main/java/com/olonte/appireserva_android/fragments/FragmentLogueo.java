package com.olonte.appireserva.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.olonte.appireserva.R;
import com.olonte.appireserva.activities.ReservaActivity;
import com.olonte.appireserva.controller.AppiReservaApplication;
import com.olonte.appireserva.helper.AlertDialogManager;

public class FragmentLogueo extends Fragment {

    private AppiReservaApplication appiReservaApplication;
    private Context context;
    private AlertDialogManager alertDialogManager;
    private String usuario;
    private String clave;
    private EditText editTextUsuario;
    private EditText editTextClave;
    private Button buttonProfesor;
    private Button buttonEstudiante;



    public FragmentLogueo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_logueo, container, false);
        editTextUsuario  = (EditText) rootView.findViewById(R.id.editTextUsuario);
        editTextClave    = (EditText) rootView.findViewById(R.id.editTextClave);
        buttonProfesor   = (Button) rootView.findViewById(R.id.buttonProfesor);
        buttonEstudiante = (Button) rootView.findViewById(R.id.buttonEstudiante);
        appiReservaApplication = (AppiReservaApplication)getActivity().getApplication();
        alertDialogManager = new AlertDialogManager();

        buttonProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarUsuario(editTextUsuario.getText().toString(),
                        editTextClave.getText().toString())) {
                    appiReservaApplication.setUsuarioActual(editTextUsuario.getText().toString());
                    Intent reservaActivity = new Intent(getActivity(), ReservaActivity.class);
                    startActivity(reservaActivity);
                }else{
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            alertDialogManager.showAlertDialog(context,
                                    getActivity().getString(R.string.tag_tl_error_usuario),
                                    getActivity().getString(R.string.tag_msj_error_usuario));
                        }
                    });
                    editTextUsuario.setText("");
                    editTextClave.setText("");
                }
            }
        });

        editTextUsuario.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( (event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER) ){
                    editTextUsuario.clearFocus();
                    editTextClave.requestFocus();
                    return true;
                }
                return false;
            }
        });

        editTextClave.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    editTextClave.clearFocus();
                    buttonProfesor.requestFocus();
                    return true;
                }

                return false;
            }
        });

        buttonEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public boolean validarUsuario(String usuario, String clave){
        boolean band;
        band = false;

        for (int i = 0; i < appiReservaApplication.getArrayListUsuarios().size(); i++){
            if(appiReservaApplication.getArrayListUsuarios().get(i).getUsuario().equals(usuario) &&
                    appiReservaApplication.getArrayListUsuarios().get(i).getClave().equals(clave)){
                band = true;
                break;
            }
        }

        return band;

    }


}
