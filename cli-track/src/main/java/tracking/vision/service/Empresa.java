/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.service;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
public class Empresa {
    private Integer idEmpresa;
    private String nomeEmpresa;
    private String emailEmpresa;
    private String senha;
    private String cnpj;

    private String rua;
    private String bairro;

    private String estado;

    private String cep;

    private String numero;

    public Empresa(Integer idEmpresa, String nomeEmpresa, String emailEmpresa, String senha, String cnpj, String rua, String bairro, String estado, String cep, String numero) {
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.senha = senha;
        this.cnpj = cnpj;
        this.rua = rua;
        this.bairro = bairro;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
    }

    public Empresa() {
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", emailEmpresa='" + emailEmpresa + '\'' +
                ", senha='" + senha + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
