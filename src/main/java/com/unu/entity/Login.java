package com.unu.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLogin")
    private int idLogin;
    @Column(name = "Usuario", unique = true, length = 15)
    private String usurio;
    @Column(name = "Contrasena", length = 15)
    private String contraseña;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdEmpleado", foreignKey = @ForeignKey(name = "fk_login_empleado"))
    private Empleado empleado;

    @Column(name = "Estado")
    private boolean estado;
    @Column(name = "Horas")
    private LocalDateTime horas;

    public Login() {
        super();
    }

    public Login(int idLogin, String usurio, String contraseña, Empleado empleado, boolean estado, LocalDateTime horas) {
        super();
        this.idLogin = idLogin;
        this.usurio = usurio;
        this.contraseña = contraseña;
        this.empleado = empleado;
        this.estado = estado;
        this.horas = horas;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getHoras() {
        return horas;
    }

    public void setHoras(LocalDateTime horas) {
        this.horas = horas;
    }

    public String getUsurio() {
        return usurio;
    }

    public void setUsurio(String usurio) {
        this.usurio = usurio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
