package prova.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prova.model.Assalariado;
import prova.model.Comissionado;

public class AssalariadoJdbcDAO {

	private Connection conn;
	
	public AssalariadoJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	public void salvar(Assalariado c) throws SQLException {
		String sql = "insert into tb_assalariado values ('"+c.getSalario()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
                prepareStatement.close();
	}
	
	public void alterar(Assalariado cExample) {
		String sql = "update tb_assalariado set salario='"+cExample.getSalario()+"' where id_salario='"+cExample.getId_assalariado()+"';";
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
		String sql = "delete from tb_assalariado where id_assalariados='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}

	public List<Assalariado> listar() {
		String sql = "select * from tb_assalariado";
        System.out.println(sql);		
        List<Assalariado> assalariados = new ArrayList<Assalariado>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id_assalariado");
				Float salario = rs.getFloat("salario");
				Assalariado assalariado = new Assalariado();
				assalriado.setId_assalariado(id);
				assalriado.setSalario(salario);
				assalriados.add(assalariado);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assalariados;
	}

	public Assalariado findById(Integer id) {
		String sql = "select * from tb_assalariado where id_assalariado= "+id;
        System.out.println(sql);		        
        Assalariado assalariado = null;
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				assalariado = new Assalariado();
				int idAssal = rs.getInt("id_assalariado");
				Float salario = rs.getFloat("salario");
				
				assalariado.setId_assalariado(id);
				assalariado.setSalario(salario);
			}
			prepareStatement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assalariado;
	}
}
