/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision;

/**
 *
 * @author hidek
 */
public class Dados {

    private Integer id;
    private Long memoriaEmUso;
    private Long bytesDeLeitura;
    private Long bytesDeEscrita;
    private Double processadorEmUso;
    private Long bytesEnviados;
    private Long bytesRecebidos;
    private Long janelaId;
    //qq
    public Dados() {
        API api = new API();
        id = null;
        memoriaEmUso = api.getMemoriaEmUso();
        bytesDeLeitura = api.getBystesDeLeitura();
        bytesDeEscrita = api.getBytesDeEscrita();
        processadorEmUso = api.getProcessadorEmUso();
        bytesEnviados = api.getBytesEnviados();
        bytesRecebidos = api.getBytesRecebidos();
        janelaId = api.getJanelaId();
    }

    public Long getMemoriaEmUso() {
        return memoriaEmUso;
    }

    public Long getBytesDeLeitura() {
        return bytesDeLeitura;
    }

    public Long getBytesDeEscrita() {
        return bytesDeEscrita;
    }

    public Long getBytesEnviados() {
        return bytesEnviados;
    }

    public Long getBytesRecebidos() {
        return bytesRecebidos;
    }

    public Long getJanelaId() {
        return janelaId;
    }

    public Double getProcessadorEmUso() {
        return processadorEmUso;
    }

    @Override
    public String toString() {
        return "Dados do banco: " + "\nid: " + id + "\nmemoriaEmUso: " + memoriaEmUso + "\nbytesDeLeitura: " + bytesDeLeitura + "\nbytesDeEscrita: " + bytesDeEscrita + "\nprocessadorEmUso: " + processadorEmUso + "\nbytesEnviados: " + bytesEnviados + "\nbytesRecebidos: " + bytesRecebidos + "\njanelaId: " + janelaId + "\n";
    }

}
