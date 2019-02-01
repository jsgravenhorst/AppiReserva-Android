package com.olonte.appireserva.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.olonte.appireserva.R;
import com.olonte.appireserva.listener.OnAppiReservaClickListener;

public class FragmentInicio extends Fragment {

    private static OnAppiReservaClickListener mListenerVacio = new OnAppiReservaClickListener() {
        @Override
        public void onClickInicio() {

        }
    };

    private OnAppiReservaClickListener mListener = mListenerVacio;

    public FragmentInicio() {
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
        Button button;
        rootView = inflater.inflate(R.layout.fragment_inicio, container, false);
        button = (Button) rootView.findViewById(R.id.btnInicio);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClickInicio();
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if(context instanceof Activity){
            activity = (Activity) context;
            try {
                mListener = (OnAppiReservaClickListener) activity;
            }catch (ClassCastException e) {
                throw new IllegalStateException("La clase " + activity.toString()  +
                        " debe implementar la interfaz " +
                        OnAppiReservaClickListener.class.getName() +
                        " del Fragment al que quiere escuchar");
            }
        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnAppiReservaClickListener) activity;
        }catch (ClassCastException e) {
            throw new IllegalStateException("La clase " + activity.toString()  +
                    " debe implementar la interfaz " +
                    OnAppiReservaClickListener.class.getName() +
                    " del Fragment al que quiere escuchar");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = mListenerVacio;
    }
}
