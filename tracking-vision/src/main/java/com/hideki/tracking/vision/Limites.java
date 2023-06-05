package com.hideki.tracking.vision;

public class Limites {
    private Integer idLimite;
    private Double ok;
    private Double perigo;
    private Double aviso;
    private String tipo;
    private Integer fkMaquina;

    public Limites(Integer idLimite, Double ok, Double perigo, Double aviso, String tipo, Integer fkMaquina) {
        this.idLimite = idLimite;
        this.ok = ok;
        this.perigo = perigo;
        this.aviso = aviso;
        this.tipo = tipo;
        this.fkMaquina = fkMaquina;
    }
    public Limites() {
    }

    public Integer getIdLimite() {
        return idLimite;
    }

    public void setIdLimite(Integer idLimite) {
        this.idLimite = idLimite;
    }

    public Double getOk() {
        return ok;
    }

    public void setOk(Double ok) {
        this.ok = ok;
    }

    public Double getPerigo() {
        return perigo;
    }

    public void setPerigo(Double perigo) {
        this.perigo = perigo;
    }

    public Double getAviso() {
        return aviso;
    }

    public void setAviso(Double aviso) {
        this.aviso = aviso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }
}
