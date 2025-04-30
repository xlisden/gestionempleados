package com.unu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CuentaBancaria")
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CuentaId")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "CuentaBanco", foreignKey = @ForeignKey(name = "fk_cuenta_banco"))
    private Banco banco;

    @Column(name = "CuentaCci", unique = true, length = 20)
    private String cci;

    @ManyToOne()
    @JoinColumn(name = "CuentaEmpleado", foreignKey = @ForeignKey(name = "fk_cuenta_empleado"))
    private Empleado empleado;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int id, Banco banco, String cci, Empleado empleado) {
        this.id = id;
        this.banco = banco;
        this.cci = cci;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int idCuenta) {
        this.id = idCuenta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
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
