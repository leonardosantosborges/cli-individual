/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.tracking.vision;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;

import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.hideki.tracking.vision.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardobgs
 */
public class Login {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Insira o seu email: ");

        String login = leitor.nextLine();

        System.out.println("Insira a sua senha: ");

        String senha = leitor.nextLine();

        FuncionarioService funcDao = new FuncionarioService();
        API api = new API();

        if (!funcDao.login(login, senha).isEmpty()) {
            //log login
            System.out.println("Login realizado com sucesso!");

            MaquinaService maquinaService = new MaquinaService();
            Looca looca = new Looca();
            Rede rede = looca.getRede();
            List<Maquina> hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());
            Logs logs = new Logs("logs.txt");
            logs.log("Login realizado com esso!");

            RedeService redeDao = new RedeService();

            hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());
            List<RedeInterface> redes = new ArrayList<>();
            if (hostname.isEmpty()) {
                System.out.println("Cadastrando maquina...");
                Double frequenciaCpu = Double.valueOf(api.getProcessador().getFrequencia());
                frequenciaCpu = frequenciaCpu / 1000000000.00;

                Double capRam = Double.valueOf(api.getMemoria().getTotal());
                capRam = capRam / 1073741824.00;

                Double capDisco = Double.valueOf(api.getDisco().get(0).getTamanho());
                capDisco = capDisco / 1073741824.00;

                Double leituraDisco = Double.valueOf(api.getDisco().get(0).getBytesDeLeitura());
                leituraDisco = leituraDisco / 100000000.00;

                Double escritaDisco = Double.valueOf(api.getDisco().get(0).getBytesDeEscritas());
                escritaDisco = escritaDisco / 100000000.00;
                for (int i = 0; i < rede.getGrupoDeInterfaces().getInterfaces().size(); i++) {

                    if (!rede.getGrupoDeInterfaces().getInterfaces().get(i).getEnderecoIpv4().isEmpty() && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesRecebidos() > 0 && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesEnviados() > 0) {

                        redes.add(rede.getGrupoDeInterfaces().getInterfaces().get(i));

                    }
                }

                Maquina maquina = new Maquina(null, rede.getParametros().getHostName(), 1, api.getProcessador().getNome(), frequenciaCpu, "Memoria", capRam, api.getDisco().get(0).getModelo(), capDisco, leituraDisco, escritaDisco, funcDao.retornarFkEmpresa(login, senha), 1);

                maquinaService.salvarMaquina(maquina);

                hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());
                System.out.println("Hostname do for do lgin: " + hostname);
                System.out.println("Cadastrando rede");
                Redes redesCadastrar = new Redes(null, redes.get(0).getNome(), redes.get(0).getNomeExibicao(), redes.get(0).getEnderecoIpv4().get(0), redes.get(0).getEnderecoMac(), hostname.get(0).getIdMaquina());
                redeDao.cadastrarRede(redesCadastrar);
            } else {
                System.out.println("Maquina ja cadastrada");

            }

            hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());
            System.out.println(hostname.get(0).getIdMaquina());

            LogService logService = new LogService();
            
            JanelaGrupo janelaGrupo = looca.getGrupoDeJanelas();
            DiscoGrupo disco = looca.getGrupoDeDiscos();

            hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());

            //Frequncia do processador convertida para GHz
            Double usoDisco = (double) (api.getDisco().get(0).getTamanho() - disco.getVolumes().get(0).getDisponivel());
            usoDisco = usoDisco / 1073741824.00;

            //Uso da ram to GB
            Double usoRam = Double.valueOf(api.getMemoriaEmUso());
            usoRam = usoRam / 1073741824.00;
            Double finalUsoDisco1 = usoDisco;
            Double finalUsoRam1 = usoRam;
            List<Maquina> finalHostname = hostname;
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    List<String> janelas = new ArrayList<>();
                    List<Long> janelasPid = new ArrayList<>();

                    for (int i = 0; i < janelaGrupo.getTotalJanelasVisiveis(); i++) {
                        if (janelaGrupo.getJanelasVisiveis().get(i).getTitulo().length() > 0) {
                            janelas.add(janelaGrupo.getJanelasVisiveis().get(i).getTitulo());
                            janelasPid.add(janelaGrupo.getJanelasVisiveis().get(i).getPid());
                        }
                    }
                    List<RedeInterface> redes = new ArrayList<>();

                    for (int i = 0; i < rede.getGrupoDeInterfaces().getInterfaces().size(); i++) {

                        if (!rede.getGrupoDeInterfaces().getInterfaces().get(i).getEnderecoIpv4().isEmpty() && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesRecebidos() > 0 && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesEnviados() > 0) {

                            redes.add(rede.getGrupoDeInterfaces().getInterfaces().get(i));
                            break;

                        }
                    }

                    for (int j = 0; j < janelas.size(); j++) {
                        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                        Log log = new Log(null, timeStamp, janelasPid.get(j), janelas.get(j), api.getProcessador().getUso(), finalUsoDisco1, finalUsoRam1, (redes.get(0).getBytesRecebidos() * 8) / 1000000, (redes.get(0).getBytesEnviados() * 8) / 1000000, finalHostname.get(0).getIdMaquina());

                        System.out.println(log.toString());
                        logService.salvarLog(log);

                        LimitesService limitesService = new LimitesService();
                        List<Limites> limites = limitesService.retornarLimites(log.getFkMaquina());
                        SendMessage sendMessage = new SendMessage();
                        try {
                            sendMessage.mandarMensagemAviso(limites, log);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        JanelasBloqueadasService janelasBloqueadasService = new JanelasBloqueadasService();
                        List<JanelasBloqueadas> janelasBloqueadasList = janelasBloqueadasService.retornarJanelasBloqueadas(finalHostname.get(0).getFkEmpresa());

                        for (JanelasBloqueadas janelasBloqueadas : janelasBloqueadasList) {
                            if (janelas.get(j).toLowerCase().contains(janelasBloqueadas.getNome().toLowerCase())) {
                                System.out.println("seu computador sera desligado");
                                try {
                                    Runtime.getRuntime().exec("shutdown -s -t 120");
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        }
                    }
                }
            }, 0, 60000);
        } else {
            System.out.println("""
                Senha ou login invalido
                ou usuario nao cadastrado via web""");
        }

    }

}
