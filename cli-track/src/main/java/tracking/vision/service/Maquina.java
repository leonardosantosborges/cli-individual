/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.service;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
public class Maquina {

    private Integer idMaquina;
    private Integer status;
    private String hostnameMaquina;
    private String nomeModeloCpu;
    private Double clockCpu;
    private String nomeModeloRam;
    private Double capacidadeTotalRam;
    private String nomeModeloDisco;
    private Double capacidadeTotalDisco;
    private Double leituraDisco;
    private Double escritaDisco;
    private Integer fkEmpresa;
    private Integer fkJanelasBloqueadas;

    public Maquina(Integer idMaquina, Integer status, String hostnameMaquina, String nomeModeloCpu, Double clockCpu, String nomeModeloRam, Double capacidadeTotalRam, String nomeModeloDisco, Double capacidadeTotalDisco, Double leituraDisco, Double escritaDisco, Integer fkEmpresa, Integer fkJanelasBloqueadas) {
        this.idMaquina = idMaquina;
        this.status = status;
        this.hostnameMaquina = hostnameMaquina;
        this.nomeModeloCpu = nomeModeloCpu;
        this.clockCpu = clockCpu;
        this.nomeModeloRam = nomeModeloRam;
        this.capacidadeTotalRam = capacidadeTotalRam;
        this.nomeModeloDisco = nomeModeloDisco;
        this.capacidadeTotalDisco = capacidadeTotalDisco;
        this.leituraDisco = leituraDisco;
        this.escritaDisco = escritaDisco;
        this.fkEmpresa = fkEmpresa;
        this.fkJanelasBloqueadas = fkJanelasBloqueadas;
    }
    
    public Maquina(){
        
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHostnameMaquina() {
        return hostnameMaquina;
    }

    public void setHostnameMaquina(String hostnameMaquina) {
        this.hostnameMaquina = hostnameMaquina;
    }

    public String getNomeModeloCpu() {
        return nomeModeloCpu;
    }

    public void setNomeModeloCpu(String nomeModeloCpu) {
        this.nomeModeloCpu = nomeModeloCpu;
    }

    public Double getClockCpu() {
        return clockCpu;
    }

    public void setClockCpu(Double clockCpu) {
        this.clockCpu = clockCpu;
    }

    public String getNomeModeloRam() {
        return nomeModeloRam;
    }

    public void setNomeModeloRam(String nomeModeloRam) {
        this.nomeModeloRam = nomeModeloRam;
    }

    public Double getCapacidadeTotalRam() {
        return capacidadeTotalRam;
    }

    public void setCapacidadeTotalRam(Double capacidadeTotalRam) {
        this.capacidadeTotalRam = capacidadeTotalRam;
    }

    public String getNomeModeloDisco() {
        return nomeModeloDisco;
    }

    public void setNomeModeloDisco(String nomeModeloDisco) {
        this.nomeModeloDisco = nomeModeloDisco;
    }

    public Double getCapacidadeTotalDisco() {
        return capacidadeTotalDisco;
    }

    public void setCapacidadeTotalDisco(Double capacidadeTotalDisco) {
        this.capacidadeTotalDisco = capacidadeTotalDisco;
    }

    public Double getLeituraDisco() {
        return leituraDisco;
    }

    public void setLeituraDisco(Double leituraDisco) {
        this.leituraDisco = leituraDisco;
    }

    public Double getEscritaDisco() {
        return escritaDisco;
    }

    public void setEscritaDisco(Double escritaDisco) {
        this.escritaDisco = escritaDisco;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getFkJanelasBloqueadas() {
        return fkJanelasBloqueadas;
    }

    public void setFkJanelasBloqueadas(Integer fkJanelasBloqueadas) {
        this.fkJanelasBloqueadas = fkJanelasBloqueadas;
    }

    @Override
    public String toString() {
        return "Maquina{" + "idMaquina=" + idMaquina + ", status=" + status + ", hostnameMaquina=" + hostnameMaquina + ", nomeModeloCpu=" + nomeModeloCpu + ", clockCpu=" + clockCpu + ", nomeModeloRam=" + nomeModeloRam + ", capacidadeTotalRam=" + capacidadeTotalRam + ", nomeModeloDisco=" + nomeModeloDisco + ", capacidadeTotalDisco=" + capacidadeTotalDisco + ", leituraDisco=" + leituraDisco + ", escritaDisco=" + escritaDisco + ", fkEmpresa=" + fkEmpresa + ", fkJanelasBloqueadas=" + fkJanelasBloqueadas + '}';
    }
    
    
}
