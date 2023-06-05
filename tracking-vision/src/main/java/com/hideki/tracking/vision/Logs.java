package com.hideki.tracking.vision;


import com.github.britooo.looca.api.core.Looca;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logs {
//    public void generateLoginSucesso(String email, List<Maquina> hostname) throws IOException {
//
//
//
//        Date horario = new Date();
//        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-mm-yyyy HH-mm-ss");
//        String dataFormatada = simpleDate.format(horario);
//
//        Path path;
//
//        Looca looca = new Looca();
//
//        if(looca.getSistema().getSistemaOperacional().contains("Windows")){
//
//            path = Paths.get("C:/Logs-tracking-vision/");
//
//        }
//
//        else {
//
//            path = Paths.get("/home/$USER/Desktop/");
//            System.out.println(path);
//
//        }
//
//        //faça um mensagem de log pra login sucesso
//        String msg = horario + " - " + email + " - " + hostname.get(0).getHostnameMaquina() + " - " + "Login realizado com sucesso";
//
//
//        path = Paths.get("/home/ubuntu/Desktop/Logs");
//        if (!Files.exists(path)) {
//
//
//            Files.createDirectory(path);
//
//        }
//        System.out.println(dataFormatada);
//        File log = new File (String.format(path/dataFormatada));
//
//        if (!log.exists()) {
//
//            log.createNewFile();
//
//        }
//
//        System.out.printf("Tabelas de Logs\n");
//
//        FileWriter file = new FileWriter(log, true);
//
//        BufferedWriter bw = new BufferedWriter(file);
//
//        bw.write(msg);
//
//        bw.newLine();
//
//        bw.close();
//
//        file.close();
//
//    }




        private String filename;
        private DateTimeFormatter dateTimeFormatter;

        public Logs(String filename) {
            this.filename = filename;
            this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        }

        public void log(String message) {
            String timestamp = LocalDateTime.now().format(dateTimeFormatter);
            String logMessage = String.format("[%s] %s%n", timestamp, message);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write(logMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




}
