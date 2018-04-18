package prova;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import prova.model.Horista;
import prova.persistence.HoristaJdbcDAO;
import prova.persistence.jdbcUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try {
        	//Horista hor = new Horista();
        	//hor.setId_horista(6);
        	//hor.setPrecoHora((float) 10);
        	//hor.setHorasTrabalhadas((float) 20);
        	
			Connection conn = (Connection) jdbcUtil.getConnection();
			HoristaJdbcDAO horDAO = new HoristaJdbcDAO(conn);
			//horDAO.salvar(hor);
			List<Horista> listar = horDAO.listar();
			for (Horista h:listar) {
				System.out.println(h);
			}
			System.out.println(conn);
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
