package com.unu.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmpleadoDetalleDto {

    private int id;
    private String cod;
    private String dni;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String genero;
    private String estadoCivil;
    private int edad;
    private String estado;
    private String foto;

}
