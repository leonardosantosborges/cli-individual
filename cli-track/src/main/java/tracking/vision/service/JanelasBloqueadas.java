/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.service;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
public class JanelasBloqueadas {
    private Integer idJanelasBloqueadas;
    private String nome;
    private String endereco;
    private Integer fkEmpresa;

    public JanelasBloqueadas(Integer idJanelasBloqueadas, String nome, String endereco, Integer fkEmpresa) {
        this.idJanelasBloqueadas = idJanelasBloqueadas;
        this.nome = nome;
        this.endereco = endereco;
        this.fkEmpresa = fkEmpresa;
    }
    public JanelasBloqueadas() {
    }

    public Integer getIdJanelasBloqueadas() {
        return idJanelasBloqueadas;
    }

    public void setIdJanelasBloqueadas(Integer idJanelasBloqueadas) {
        this.idJanelasBloqueadas = idJanelasBloqueadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }
}

