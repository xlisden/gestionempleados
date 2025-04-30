package com.unu.entity;

//<editor-fold defaultstate="collapsed" desc=" Librerías...">
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;

import java.sql.Date;
//</editor-fold>

@Entity
@Table(name = "Contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ContEmpleado", foreignKey = @ForeignKey(name = "fk_contrato_empleado"))
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "ContArea", foreignKey = @ForeignKey(name = "fk_contrato_area"))
    private Area area;

    private Date fechaEmision;

    @ManyToOne
    @JoinColumn(name = "ContModalidadCont", foreignKey = @ForeignKey(name = "fk_contrato_modalidad_cont"))
    private ModalidadContrato modContrato;

    private Date fechaInicio;

    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "ContJLaboral", foreignKey = @ForeignKey(name = "fk_contrato_jord_laboral"))
    private JornadaLaboral jornadaLaboral;

}
