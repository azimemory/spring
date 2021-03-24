package templateMethod.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import templateMethod.framework.jdbc.JDBCTemplate;

public class MyTemplate extends JDBCTemplate{

	@Override
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bm";
		String password = "USER11";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			//Transaction 관리를 개발자가 하기 위해 AutoCommit 설정 끄기
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
