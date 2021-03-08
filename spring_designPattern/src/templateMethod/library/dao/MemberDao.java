package templateMethod.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import templateMethod.library.jdbc.JDBCTemplate;

public class MemberDao {
	
	public JDBCTemplate jdt;
	
	public MemberDao(JDBCTemplate jdt) {
		super();
		this.jdt = jdt;
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
