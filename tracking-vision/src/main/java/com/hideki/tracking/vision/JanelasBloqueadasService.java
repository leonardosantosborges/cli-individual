package com.hideki.tracking.vision;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JanelasBloqueadasService {
    public List<JanelasBloqueadas> retornarJanelasBloqueadas(Integer fkEmpresa) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.query("select * from janelasbloqueadas where fkEmpresa = ?", new BeanPropertyRowMapper(JanelasBloqueadasService.class), fkEmpresa);
    }
}
