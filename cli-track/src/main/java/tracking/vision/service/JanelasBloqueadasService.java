/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.service;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
import com.mycompany.tracking.vision.paulo.Conexao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JanelasBloqueadasService {
    public List<JanelasBloqueadas> retornarJanelasBloqueadas(Integer fkEmpresa) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.query("select * from janelasbloqueadas where fkEmpresa = ?", new BeanPropertyRowMapper(JanelasBloqueadas.class), fkEmpresa);
    }
}
