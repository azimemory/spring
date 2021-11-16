package strategy.framework;

import java.sql.Connection;

public interface ConnectionMaker {
	
	Connection getConnection();

}
