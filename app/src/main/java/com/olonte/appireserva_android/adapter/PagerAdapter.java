package com.olonte.appireserva.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.olonte.appireserva.fragments.FragmentListadoReserva;
import com.olonte.appireserva.fragments.FragmentReserva;

/**
 * Created by jsgravenhorst on 10/15/2015.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    int nNumOfTabs;

    public PagerAdapter(FragmentManager fragmentManager, int nNumOfTabs){
        super(fragmentManager);
        this.nNumOfTabs = nNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentReserva fragmentReserva = new FragmentReserva();
                return fragmentReserva;
            case 1:
                FragmentListadoReserva fragmentListadoReserva = new FragmentListadoReserva();
                return fragmentListadoReserva;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
