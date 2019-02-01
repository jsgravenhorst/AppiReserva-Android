package com.olonte.appireserva.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

/**
 * Created by jsgravenhorst on 10/19/2015.
 */
public class FragmentHoraPicker extends DialogFragment {
    TimePickerDialog.OnTimeSetListener onTimeSetListener;
    private int hora, minuto;

    public FragmentHoraPicker(){
    }

    public void setCallBack(TimePickerDialog.OnTimeSetListener onTimeSetListener){
        this.onTimeSetListener = onTimeSetListener;
    }

    @SuppressLint("NewApi")
    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        hora = args.getInt("hora");
        minuto = args.getInt("minuto");
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(),onTimeSetListener, hora, minuto, DateFormat.is24HourFormat(getActivity()));


    }
}
