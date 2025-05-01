package com.unu.controller.request;

import com.unu.entity.EstadoCivil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class InsertarEmpleadoRequest {

    @Size(min = 1, max = 6)
    private String cod;

    @Size(min = 1, max = 8)
    private String dni;

    @Size(min = 1, max = 20)
    private String nombre;

    @Size(min = 1, max = 20)
    private String apPaterno;

    @Size(min = 1, max = 20)
    private String apMaterno;

    @NotNull()
    private boolean genero;

    @NotNull()
    private EstadoCivil estadoCivil;

    @NotNull()
    private LocalDate fechaNacimiento;

    @Size(min = 1, max = 30)
    private String foto;

}
