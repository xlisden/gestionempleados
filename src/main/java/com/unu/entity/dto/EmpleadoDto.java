package com.unu.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmpleadoDto {

    private int id;
    private String cod;
    private String nombreCompleto;
    private String area;
    private String antiguedad;
    private String modalidadContrato;
    private String jornadaLaboral;
    private boolean activo;

}
