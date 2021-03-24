package strategy.framework.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import strategy.framework.jdbc.ConnectionMaker;
import strategy.framework.jdbc.JDBCTemplate;

public class MemberDao {
	
	private JDBCTemplate jdt;
	
	//사용자가 JDBCTemplate을 상속받아 만든 MyTemplate을 생성자의 매개변수로 전달받는다.
	public MemberDao(ConnectionMaker cm) {
		this.jdt = new JDBCTemplate(cm);
	}
	
	public String selectPassword(String userId) {
		
		PreparedStatement pstm;
		ResultSet rset;
		String res = null;
		String sql = "select password from tb_member where user_id = ?";
		
		try {
			pstm = jdt.getConnection().prepareStatement(sql);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			if(rset.next()) {
				res = rset.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}
