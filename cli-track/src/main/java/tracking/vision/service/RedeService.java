package tracking.vision.service;

import com.mycompany.tracking.vision.paulo.Conexao;
import com.mycompany.tracking.vision.paulo.ConexaoMysql;
import org.springframework.jdbc.core.JdbcTemplate;

public class RedeService {
public void cadastrarRede(Redes rede) {
        Conexao conexao = new Conexao();
        ConexaoMysql conexaoMysql = new ConexaoMysql();

        JdbcTemplate con = conexao.getConnection();
        JdbcTemplate conMysql = conexaoMysql.getConnection();

        con.update("insert into placaRede(nomeRede,nomeExibicao,ipv4,mac,fkMaquina) values (?, ?, ?, ?,?)", rede.getNomeRede(), rede.getNomeExibicao(), rede.getIpv4(), rede.getMac(),rede.getFkMaquina());
    }

    public void cadastrarRedeMysql(Redes rede) {
        ConexaoMysql conexaoMysql = new ConexaoMysql();

        JdbcTemplate conMysql = conexaoMysql.getConnection();

        conMysql.update("insert into placaRede(nomeRede,nomeExibicao,ipv4,mac,fkMaquina) values (?, ?, ?, ?,?)", rede.getNomeRede(), rede.getNomeExibicao(), rede.getIpv4(), rede.getMac(),rede.getFkMaquina());
    }

    public Integer retornarIdRede (Redes redes) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("select idRede from placaRede where nomeRede = ? and nomeExibicao = ? and ipv4 = ? and mac = ?", Integer.class, redes.getNomeRede(), redes.getNomeExibicao(), redes.getIpv4(), redes.getMac());
    }
}
