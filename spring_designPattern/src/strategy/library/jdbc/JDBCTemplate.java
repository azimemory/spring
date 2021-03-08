package strategy.library.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	ConnectionMaker connectionMaker;

	//생성자를 private으로 만들어서 외부에서 JDBCTemplate의 생성을 차단
	public JDBCTemplate(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public Connection getConnection() {
		return connectionMaker.getConnection();
	}
	
	//commit 수행
	public void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet rset, Statement stmt) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
			
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(Statement stmt, Connection conn) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet rset, Statement stmt, Connection conn) {
		
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
			
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	

}
