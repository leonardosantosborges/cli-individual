/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tracking.vision.service;

import com.mycompany.tracking.vision.paulo.Conexao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
public class FuncionarioService {
    public List<Funcionario> login (String email, String senha) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.query("select * from funcionario where email = ? and senha = ?", new BeanPropertyRowMapper(Funcionario.class), email, senha);
    }

    public Integer retornarFkEmpresa(String email, String senha) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("select fkEmpresa from funcionario where email = ? and senha = ?", Integer.class, email, senha);
    }
}
