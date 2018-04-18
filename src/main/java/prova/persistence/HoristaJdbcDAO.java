package prova.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prova.model.Horista;

public class HoristaJdbcDAO {

	private Connection conn;
	
	public HoristaJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Horista c) throws SQLException {
		String sql = "insert into tb_horista (id_horista, precoHora, horasTrabalhadas) values ('"+c.getId_horista()+"','"+c.getPrecoHora()+"','"+c.getHorasTrabalhadas()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
                prepareStatement.close();
	}
	
	public void alterar(Horista cExample) {
		String sql = "update tb_horista set precoHora='"+cExample.getPrecoHora()+"',horasTrabalhadas='"+cExample.getHorasTrabalhadas()+"' where id_horista='"+cExample.getId_horista()+"';";
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
		String sql = "delete from tb_horista where id_horista='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}

	public List<Horista> listar() {
		String sql = "select * from tb_horista;";
        System.out.println(sql);		
        List<Horista> horistas = new ArrayList<Horista>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id_horista");
				Float precoHora = rs.getFloat("precoHora");
				Float horasTrabalhadas = rs.getFloat("horasTrabalhadas");
				Horista horista = new Horista();
				horista.setId_horista(id);
				horista.setPrecoHora(precoHora);
				horista.setHorasTrabalhadas(horasTrabalhadas);
				horistas.add(horista);				
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horistas;
	}

	public Horista findById(Integer id) {
		String sql = "select * from tb_horista where id_horista = "+id;
        System.out.println(sql);		        
        Horista horista = null;
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				horista = new Horista();
				int idHora = rs.getInt("id_horista");
				Float precoHora= rs.getFloat("precoHora");
				Float horasTrabalhadas = rs.getFloat("horasTrabalhadas");
				
				horista.setId_horista(id);
				horista.setPrecoHora(precoHora);
				horista.setHorasTrabalhadas(horasTrabalhadas);
			}
			prepareStatement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horista;
	}
}
