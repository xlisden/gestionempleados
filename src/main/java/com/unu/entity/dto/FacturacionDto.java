package com.unu.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FacturacionDto {

    private int id;
    private String empleado;
    private String fechaPago;
    private double sueldoNeto;

}
