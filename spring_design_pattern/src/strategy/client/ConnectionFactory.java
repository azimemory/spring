package strategy.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import strategy.framework.ConnectionMaker;

public class ConnectionFactory implements ConnectionMaker{

	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
					 , "bookmanager", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
