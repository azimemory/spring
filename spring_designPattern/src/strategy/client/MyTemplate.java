package strategy.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import strategy.framework.jdbc.ConnectionMaker;

public class MyTemplate implements ConnectionMaker{

	@Override
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "bm";
			String password = "USER11";
			
			try {
				conn = DriverManager.getConnection(url,user,password);
				//Transaction 관리를 개발자가 하기 위해 AutoCommit 설정 끄기
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return conn;
	}
}
