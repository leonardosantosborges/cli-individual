/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.cli;

import com.github.britooo.looca.api.core.Looca;

import com.github.britooo.looca.api.group.janelas.JanelaGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import tracking.vision.service.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;

/**
 *
 * @author leonardoborges
 */
public class Login {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FuncionarioService funcionarioService = new FuncionarioService();
        MaquinaService maquinaService = new MaquinaService();
        LogService logService = new LogService();
        Looca looca = new Looca();
        RedeService redeService = new RedeService();
        Rede rede = looca.getRede();
        
        Boolean login = false;
        System.out.println("Para acessar o sistema, será necessário informar seu email e senha.");

        while (!login) {

            System.out.println("Digite seu email: ");
            String email = in.nextLine();

            System.out.println("Digite sua senha: ");
            String senha = in.nextLine();

            if (!funcionarioService.login(email, senha).isEmpty()) {
                login = true;
                System.out.println("Login realizado com sucesso!");

                List<Maquina> hostname = maquinaService.buscarPeloHostname(looca.getRede().getParametros().getHostName());
                List<Maquina> hostnameMysql = maquinaService.buscarPeloHostnameMySql(looca.getRede().getParametros().getHostName());
                List<RedeInterface> redes = new ArrayList<>();
                Double freqCpu = Double.valueOf(looca.getProcessador().getFrequencia());
                freqCpu = freqCpu / 1000000000.00;

                Double capRam = Double.valueOf(looca.getMemoria().getTotal());
                capRam = capRam / 1073741824.00;

                Double capDisco = Double.valueOf(looca.getGrupoDeDiscos().getDiscos().get(0).getTamanho());
                capDisco = capDisco / 1073741824.00;

                Double leituraDisco = Double.valueOf(looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeLeitura());
                leituraDisco = leituraDisco / 100000000.00;

                Double escritaDisco = Double.valueOf(looca.getGrupoDeDiscos().getDiscos().get(0).getBytesDeEscritas());
                escritaDisco = escritaDisco / 100000000.00;

                adicionarRede(redes, rede);
                Maquina maquina = new Maquina(null, 1, rede.getParametros().getHostName(), looca.getProcessador().getNome(), freqCpu, "Memoria", capRam, looca.getGrupoDeDiscos().getDiscos().get(0).getModelo(), capDisco, leituraDisco, escritaDisco, funcionarioService.retornarFkEmpresa(email, senha), 1);
                if (hostname.isEmpty()) {

                    System.out.println("Cadastrando maquina no SQL Server...");

                    maquinaService.salvarMaquina(maquina);
                    System.out.println("Cadastrando rede...");
                    hostname = maquinaService.buscarPeloHostname(looca.getRede().getParametros().getHostName());
                    Redes redesCadastrar = new Redes(null, redes.get(0).getNome(), redes.get(0).getNomeExibicao(), redes.get(0).getEnderecoIpv4().get(0), redes.get(0).getEnderecoMac(), hostname.get(0).getIdMaquina());
                    redeService.cadastrarRede(redesCadastrar);
                } else {
                    System.out.println("Maquina ja cadastrada no SQL Server");
                }

                if (hostnameMysql.isEmpty()) {

                    System.out.println("Cadastrando maquina no Mysql...");

                    maquinaService.salvarMaquinaMysql(maquina);
                    System.out.println("Cadastrando rede...");
                    hostnameMysql = maquinaService.buscarPeloHostnameMySql(looca.getRede().getParametros().getHostName());
                    Redes redesCadastrar = new Redes(null, redes.get(0).getNome(), redes.get(0).getNomeExibicao(), redes.get(0).getEnderecoIpv4().get(0), redes.get(0).getEnderecoMac(), hostnameMysql.get(0).getIdMaquina());
                    redeService.cadastrarRedeMysql(redesCadastrar);
                } else {
                    System.out.println("Maquina ja cadastrada no Mysql");
                }

                System.out.println("Começando a abstrair recursos da sua máquina!");
                hostname = maquinaService.buscarPeloHostname(looca.getRede().getParametros().getHostName());
                hostnameMysql = maquinaService.buscarPeloHostnameMySql(looca.getRede().getParametros().getHostName());

                Double usoDisco = Double.valueOf(looca.getGrupoDeDiscos().getDiscos().get(0).getTamanho() - looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel());
                usoDisco = usoDisco / 1073741824.00;

                Double usoRam = Double.valueOf(looca.getMemoria().getEmUso());
                usoRam = usoRam / 1073741824.00;

                Double finalUsoDisco = usoDisco;
                Double finalUsoRam = usoRam;
                List<Maquina> finalHostname = hostname;
                List<Maquina> finalHostnameMysql = hostnameMysql;
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        List<String> janelas = new ArrayList();
                        List<Long> janelasPid = new ArrayList();
                        JanelaGrupo janelaGrupo = looca.getGrupoDeJanelas();

                        for (int i = 0; i < janelaGrupo.getTotalJanelasVisiveis(); i++) {
                            if (janelaGrupo.getJanelasVisiveis().get(i).getTitulo().length() > 0) {
                                janelas.add(janelaGrupo.getJanelasVisiveis().get(i).getTitulo());
                                janelasPid.add(janelaGrupo.getJanelasVisiveis().get(i).getPid());
                            }
                        }

                        List<RedeInterface> redes = new ArrayList<>();

                        adicionarRede(redes, rede);
                        if (!janelas.isEmpty()) {
                            for (int j = 0; j < janelas.size(); j++) {
                                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                                Log log = new Log(null, timeStamp, janelasPid.get(j), janelas.get(j), looca.getProcessador().getUso(), finalUsoDisco, finalUsoRam, (redes.get(0).getBytesRecebidos() * 8) / 1000000, (redes.get(0).getBytesEnviados() * 8) / 1000000, finalHostname.get(0).getIdMaquina());
                                Log logMysql = new Log(null, timeStamp, janelasPid.get(j), janelas.get(j), looca.getProcessador().getUso(), finalUsoDisco, finalUsoRam, (redes.get(0).getBytesRecebidos() * 8) / 1000000, (redes.get(0).getBytesEnviados() * 8) / 1000000, finalHostnameMysql.get(0).getIdMaquina());

                                System.out.println(log);
                                logService.salvarLog(log);
                                logService.salvarLogMysql(logMysql);

                                LimitesService limitesService = new LimitesService();
                                List<Limites> limites = limitesService.retornarLimites(log.getFkMaquina());
                                JanelasBloqueadasService janelasBloqueadasService = new JanelasBloqueadasService();
                                List<JanelasBloqueadas> janelasBloqueadasList = janelasBloqueadasService.retornarJanelasBloqueadas(finalHostname.get(0).getFkEmpresa());

                                for (JanelasBloqueadas janelasBloqueadas : janelasBloqueadasList) {
                                    if (janelas.get(j).toLowerCase().contains(janelasBloqueadas.getNome().toLowerCase())) {
                                        System.out.println("Seu computador será desligado");
                                        try {
                                            if (looca.getSistema().getSistemaOperacional().equalsIgnoreCase("windows")) {
                                                Runtime.getRuntime().exec("shutdown -s -t 120");

                                            } else {
                                                Runtime.getRuntime().exec("sudo shutdown now");
                                            }
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }

                                }

                            }
                        } else {
                            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                            Log log = new Log(null, timeStamp, null, null, looca.getProcessador().getUso(), finalUsoDisco, finalUsoRam, (redes.get(0).getBytesRecebidos() * 8) / 1000000, (redes.get(0).getBytesEnviados() * 8) / 1000000, finalHostname.get(0).getIdMaquina());
                            Log logMysql = new Log(null, timeStamp, null, null, looca.getProcessador().getUso(), finalUsoDisco, finalUsoRam, (redes.get(0).getBytesRecebidos() * 8) / 1000000, (redes.get(0).getBytesEnviados() * 8) / 1000000, finalHostnameMysql.get(0).getIdMaquina());

                            logService.salvarLog(log);
                            logService.salvarLogMysql(logMysql);
                            System.out.println(log);
                        }
                    }
                }, 0, 3000);

            } else {
                login = false;
                System.out.println("Email ou senha incorretos!");
            }
        }

    }

    private static void adicionarRede(List<RedeInterface> redes, Rede rede) {
        for (int i = 0; i < rede.getGrupoDeInterfaces().getInterfaces().size(); i++) {

            if (!rede.getGrupoDeInterfaces().getInterfaces().get(i).getEnderecoIpv4().isEmpty() && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesRecebidos() > 0 && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesEnviados() > 0) {

                redes.add(rede.getGrupoDeInterfaces().getInterfaces().get(i));

            }
        }
    }
}
