package templateMethod.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import templateMethod.library.jdbc.JDBCTemplate;

public class MyTemplate extends JDBCTemplate{

	@Override
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bm";
		String password = "USER11";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
			//Transaction을 개발자가 관리하기 위해 AutoCommit을 false로 지정
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
