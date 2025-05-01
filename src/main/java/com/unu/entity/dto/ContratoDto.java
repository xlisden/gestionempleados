package com.unu.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContratoDto {

    private int id;
    private String antiguedad;
    private String modalidadContrato;
    private String fechaInicio;
    private String fechaFin;
    private String area;
    private double sueldoBasico;
    private String jornadaLaboral;

}
