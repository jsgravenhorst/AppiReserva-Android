package com.olonte.appireserva.util;

/**
 * Created by jsgravenhorst on 10/19/2015.
 */
public class Hora {

    public static  String getHoraAmPm(int hora){
        if (hora >= 12) {
            if (hora >= 13 && hora < 24) {
                hora -= 12;
            }
            else {
                hora = 12;
            }
        } else if (hora == 0) {
            hora = 12;
        }
        return String.valueOf(hora);
    }

   public static  String getAmPm(int hora){
        String am_pm;
        am_pm = " AM";
        if (hora >= 12) {
            am_pm = " PM";
        }
        return am_pm;
    }

    public static String getMinutoCero(int minuto){
        String minutoCero;
        minutoCero = "";
        if (minuto < 10) {
            minutoCero = "0";
        }
        return minutoCero;

    }
}
