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

public class EmpresaService {
    public static Empresa retornarEmpresa(Integer fkEmpresa) {
        Conexao conexao = new Conexao();

        return (Empresa) conexao.getConnection().queryForObject("select * from empresa where idEmpresa = ?", new Object[]{fkEmpresa}, new BeanPropertyRowMapper(Empresa.class));
    }
}
