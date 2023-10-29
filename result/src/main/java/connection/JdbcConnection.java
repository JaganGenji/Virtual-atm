package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	public static Connection getconnection()  
	{Connection con=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "jagan");
		System.out.println("CONNECTED-----------");
		
		
	} catch (ClassNotFoundException |SQLException e) {
		System.out.println("connction failed");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;

}
}
