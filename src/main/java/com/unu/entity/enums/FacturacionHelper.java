package com.unu.entity.enums;

import java.time.LocalDate;
import java.time.Month;

public class FacturacionHelper {

    public static double bonitificacion = 500.0;

    public static int diaPago = 1;

    public static boolean isBonificacion(){
        LocalDate date  = LocalDate.now();
        if (date.getMonth() == Month.JULY || date.getMonth() == Month.DECEMBER)
            return true;
        return false;
    }

    public static boolean isBonificacion(LocalDate date){
        if (date.getMonth() == Month.JULY || date.getMonth() == Month.DECEMBER)
            return true;
        return false;
    }

}
