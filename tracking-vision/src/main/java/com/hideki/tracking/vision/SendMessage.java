/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
public class SendMessage {

    private String webHookUrl = "https://hooks.slack.com/services/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";
    private String channel = "";
    public void sendMessage(String message) throws IOException {
        try {

            Payload payload = Payload.builder()
                    .channel(channel)
                    .username("TrackingVision")
                    .text(message)
                    .build();

            WebhookResponse response = Slack.getInstance().send(webHookUrl, payload);
        }catch(Exception e) {
            System.out.printf("Erro ao enviar mensagem: %s", e.getMessage());
        }

    }

    public void mandarMensagemAviso(List<Limites> limites, Log log) throws IOException {
        Double uso = null;
//        sendMessage("Aviso");
        for (int i = 0; i < limites.size(); i++) {
            if (limites.get(i).getTipo().equalsIgnoreCase("CPU")) {
                uso = log.getUsoCpu();
            } else if (limites.get(i).getTipo().equalsIgnoreCase("RAM")) {
                uso = log.getUsoRam();
            } else if (limites.get(i).getTipo().equalsIgnoreCase("DISCO")) {
                uso = log.getUsoDisco();
            } else {
                uso = null;
            }

            if (uso <= limites.get(i).getOk()) {
                System.out.println("Dentro do limite");
                try {
                    sendMessage(String.format("A máquina %d está com o uso de %s em %.2f, está dentro do limite de %.2f", log.getFkMaquina(), limites.get(i).getTipo(), uso, limites.get(i).getOk()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (uso > limites.get(i).getOk() && uso <= limites.get(i).getAviso()) {
                System.out.println("Acima do limite");
                try {
                    sendMessage(String.format("A máquina %d está com o uso de %s em %.2f, está acima do limite de %.2f", log.getFkMaquina(), limites.get(i).getTipo(), uso, limites.get(i).getOk()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (uso > limites.get(i).getAviso() && uso <= limites.get(i).getPerigo()) {
                System.out.println("Acima do limite");
                try {
                    sendMessage(String.format("A máquina %d está com o uso de %s em %.2f, está acima do limite de %.2f", log.getFkMaquina(), limites.get(i).getTipo(), uso, limites.get(i).getAviso()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (uso > limites.get(i).getPerigo()) {
                System.out.println("Acima do limite");
                try {
                    sendMessage(String.format("A máquina %d está com o uso de %s em %.2f, está acima do limite de %.2f", log.getFkMaquina(), limites.get(i).getTipo(), uso, limites.get(i).getPerigo()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
