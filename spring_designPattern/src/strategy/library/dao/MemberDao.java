package strategy.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import strategy.library.jdbc.ConnectionMaker;
import strategy.library.jdbc.JDBCTemplate;

public class MemberDao {
	
	public JDBCTemplate jdt;
	
	public MemberDao(ConnectionMaker connectionMaker) {
		super();
		this.jdt = new JDBCTemplate(connectionMaker); 
	}

	public String selectPassword(String sql) {
		
		PreparedStatement pstm;
		ResultSet rs;
		String res = "";
		
		try {
			pstm = jdt.getConnection().prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				res = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return res;
	}
}
