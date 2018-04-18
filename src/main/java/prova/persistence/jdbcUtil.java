package prova.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {

	private static String connectionDriverClass="org.gjt.mm.mysql.Driver";
    private static String connectionUrl="jdbc:mysql://localhost:3306/empresa";
    private static String connectionUsername="root";
    private static String connectionPassword="";


    
    
	 private static Connection conn;
	 
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		if(jdbcUtil.conn != null) {
			return jdbcUtil.conn;
		}else {
			Class.forName(connectionDriverClass);
			return DriverManager.getConnection(
					jdbcUtil.connectionUrl,
					jdbcUtil.connectionUsername,
					jdbcUtil.connectionPassword);
		}
	}
	
}
