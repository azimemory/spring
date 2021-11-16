package templateCallback.framework;

import java.sql.Connection;

@FunctionalInterface
public interface ConnectionMaker {
	
	Connection getConnection();
	
}
