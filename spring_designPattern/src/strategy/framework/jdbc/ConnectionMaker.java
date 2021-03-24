package strategy.framework.jdbc;

import java.sql.Connection;

public interface ConnectionMaker {
	
	public Connection getConnection();

}
