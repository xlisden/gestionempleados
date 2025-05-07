package com.unu.entity.dto;

public class CuentaBancariaDto {

    private int id;
    private String banco;
    private String cci;

    public CuentaBancariaDto() {
        this.id = 0;
    }

    public int getId() {
        return this.id;
    }

    public String getBanco() {
        return this.banco;
    }

    public String getCci() {
        return this.cci;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void setCci(String cci) {
        this.cci = cci;
    }
}
