package com.unu.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CuentaBancariaDto {

    private int id;
    private String banco;
    private String cci;

}
