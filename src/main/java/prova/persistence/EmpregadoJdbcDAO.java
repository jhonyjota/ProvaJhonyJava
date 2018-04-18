package prova.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prova.model.Empregado;

public class EmpregadoJdbcDAO {

private Connection conn;
	
	
	public EmpregadoJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Empregado c) throws SQLException {
		String sql = "insert into tb_empregados values ('"+c.getNome()+"','"+c.getSobrenome()+"','"+c.getCPF()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
                prepareStatement.close();
	}
	
	public void alterar(Empregado cExample) {
		String sql = "update tb_empregados set nome='"+cExample.getNome()+"',sobrenome='"+cExample.getSobrenome()+"',CPF='"+cExample.getCPF()+"' where id_empregado='"+cExample.getId_empregado()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void excluir(int id) {
		String sql = "delete from tb_empregados where id_empregado='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}

	public List<Empregado> listar() {
		String sql = "select * from tb_empregados";
        System.out.println(sql);		
        List<Empregado> empregados = new ArrayList<Empregado>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id_empregado");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String CPF = rs.getString("CPF");
				Empregado empregado = new Empregado();
				empregado.setId_empregado(id);
				empregado.setNome(nome);
				empregado.setSobrenome(sobrenome);
				empregado.setCPF(CPF);
				empregados.add(empregado);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empregados;
	}

	public Empregado findById(Integer id) {
		String sql = "select * from tb_empregados where id_empregado = "+id;
        System.out.println(sql);		        
        Empregado empregado = null;
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				empregado = new Empregado();
				int idEmpr = rs.getInt("id_empregado");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String CPF = rs.getString("CPF");
				
				empregado.setId_empregado(id);
				empregado.setNome(nome);
				empregado.setSobrenome(sobrenome);
				empregado.setCPF(CPF);
			}
			prepareStatement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empregado;
	}
}
