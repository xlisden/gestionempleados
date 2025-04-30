package com.unu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "datosbancarios")
public class DatosBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCuenta")
    private int idCuenta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdEntidad", foreignKey = @ForeignKey(name = "fk_Datos_entidad"))
    private Banco banco;

    @Column(name = "Cci", unique = true, length = 20)
    private String cci;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdEmpleado", foreignKey = @ForeignKey(name = "fk_Datos_empleado"))
    private Empleado empleado;

    public DatosBancario() {
        super();
    }

    public DatosBancario(int idCuenta, Banco banco, String cci, Empleado empleado) {
        super();
        this.idCuenta = idCuenta;
        this.banco = banco;
        this.cci = cci;
        this.empleado = empleado;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Banco getEntidadBancaria() {
        return banco;
    }

    public void setEntidadBancaria(Banco banco) {
        this.banco = banco;
    }

    public String getCci() {
        return cci;
    }

    public void setCci(String cci) {
        this.cci = cci;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


}
