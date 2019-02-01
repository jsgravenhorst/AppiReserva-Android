package com.olonte.appireserva.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by jsgravenhorst on 10/19/2015.
 */
public class FragmentFechaPicker extends DialogFragment {
    DatePickerDialog.OnDateSetListener onDateSetListener;
    private int annon, mes, dia;

    public FragmentFechaPicker() {}

    public void setCallBack(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.onDateSetListener = onDateSetListener;
    }

    @SuppressLint("NewApi")
    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        annon = args.getInt("annon");
        mes   = args.getInt("mes");
        dia   = args.getInt("dia");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), onDateSetListener, annon, mes, dia);
    }
}
