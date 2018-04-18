package prova.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prova.model.Comissionado;

public class ComissionadoJdbcDAO {
	
private Connection conn;
	
	
	public ComissionadoJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Comissionado c) throws SQLException {
		String sql = "insert into tb_comissionado values ('"+c.getTotalVenda()+"','"+c.getTaxaComissao()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
                prepareStatement.close();
	}
	
	public void alterar(Comissionado cExample) {
		String sql = "update tb_comissionado set totalVenda='"+cExample.getTotalVenda()+"',taxaComissao='"+cExample.getTaxaComissao()+"' where id_comissionado='"+cExample.getId_comissionado()+"';";
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
		String sql = "delete from tb_comissonado where id_comissionado='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}

	public List<Comissionado> listar() {
		String sql = "select * from tb_comissionado";
        System.out.println(sql);		
        List<Comissionado> comissionados = new ArrayList<Comissionado>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id_comissionado");
				Float totalVenda = rs.getFloat("totalVenda");
				Float taxaComissao = rs.getFloat("taxaComissao");
				Comissionado comissionado = new Comissionado();
				comissionado.setId_comissionado(id);
				comissionado.setTotalVenda(totalVenda);
				comissionado.setTaxaComissao(taxaComissao);
				comissionados.add(comissionado);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comissionados;
	}

	public Comissionado findById(Integer id) {
		String sql = "select * from tb_comissionado where id_comissionado = "+id;
        System.out.println(sql);		        
        Comissionado comissionado = null;
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				comissionado = new Comissionado();
				int idComis = rs.getInt("id_comissionado");
				Float totalVenda = rs.getFloat("totalVenda");
				Float taxaComissao = rs.getFloat("taxaComissao");
				
				comissionado.setId_comissionado(id);
				comissionado.setTotalVenda(totalVenda);
				comissionado.setTaxaComissao(taxaComissao);
			}
			prepareStatement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comissionado;
	}
}
