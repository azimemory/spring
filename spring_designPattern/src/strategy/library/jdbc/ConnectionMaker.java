package strategy.library.jdbc;

import java.sql.Connection;

public interface ConnectionMaker {
	public Connection getConnection();
}
