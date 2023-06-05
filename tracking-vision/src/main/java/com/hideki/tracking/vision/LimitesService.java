package com.hideki.tracking.vision;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LimitesService {
    public List<Limites> retornarLimites(Integer fkMaquina) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.query("select * from limites where fkMaquina = ?", new BeanPropertyRowMapper(Limites.class), fkMaquina);
    }
}
