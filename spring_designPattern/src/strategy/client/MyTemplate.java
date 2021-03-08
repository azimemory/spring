package strategy.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import strategy.library.jdbc.ConnectionMaker;

public class MyTemplate implements ConnectionMaker{

	@Override
	public Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bm";
		String password = "USER11";
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
