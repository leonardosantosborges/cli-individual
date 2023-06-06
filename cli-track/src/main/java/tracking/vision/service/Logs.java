/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.service;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Logs {


    private final String filename;
    private final DateTimeFormatter dateTimeFormatter;

    public Logs(String filename) {
        this.filename = filename;
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public void logLogin(String message, String email) {
        String timestamp = LocalDateTime.now().format(dateTimeFormatter);
        String logMessage = String.format("[%s] O funcionario com o email: %s teve seu %s%n", timestamp, email, message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logCadastro(String message, List<Maquina> hostname) {
        String timestamp = LocalDateTime.now().format(dateTimeFormatter);
        String logMessage = String.format("[%s] A maquina com o Hostname: %s foi %s%n", timestamp, hostname.get(0).getHostnameMaquina(), message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logCadastro(String message) {
        String timestamp = LocalDateTime.now().format(dateTimeFormatter);
        String logMessage = String.format("[%s] Maquina %s%n", timestamp,message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logRede(String message, List<Maquina> hostname, Redes rede) {
        String timestamp = LocalDateTime.now().format(dateTimeFormatter);
        String logMessage = String.format("[%s] A maquina com o Hostname: %s teve sua %s, Nome da Rede: %s%n", timestamp, hostname.get(0).getHostnameMaquina(), message, rede.getNomeRede());

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
