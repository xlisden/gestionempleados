package com.unu.entity.dto;

public class CuentaBancariaDto {

    private int id;
    private String banco;
    private String cci;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCci() {
        return cci;
    }

    public void setCci(String cci) {
        this.cci = cci;
    }
}
