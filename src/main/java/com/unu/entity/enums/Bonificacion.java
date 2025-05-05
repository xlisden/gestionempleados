package com.unu.entity.enums;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Month;

public class Bonificacion {

    public static double bonitificacion = 5000.0;

    public static boolean isBonificacion(){
        LocalDate date  = LocalDate.now();
//        LocalDate hola = LocalDate.of(2025, Month.JULY, 23);
//        System.out.println(hola.getMonth());
        if (date.getMonth() == Month.JULY || date.getMonth() == Month.DECEMBER)
            return true;
        return false;
    }

}
