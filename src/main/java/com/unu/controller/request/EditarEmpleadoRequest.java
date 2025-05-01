package com.unu.controller.request;

import com.unu.entity.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EditarEmpleadoRequest {

    /* Personal */

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

    /* Laboral */

    @NotNull()
    private LocalDate fechaEmision;

    @NotNull()
    private ModalidadContrato modalidadContrato;

    @NotNull()
    private LocalDate fechaInicio;

    @NotNull()
    private LocalDate fechaFin;

    @NotNull()
    private Area area;

    @NotNull()
    private JornadaLaboral jornadaLaboral;

    /* Bancario */

    @NotNull()
    private Banco banco;

    @Size(min = 1, max = 20)
    private String cci;

}
