package factory.client;

import factory.framework.ConnectorFactory;
import factory.framework.SMTPConnector;

public class Run {

	public static void main(String[] args) {
		SMTPConnector conn = ConnectorFactory.builder()
				.url("smtp.daum.net")
				.id("azimemory@daum.net")
				.password("12345")
				.build()
				.getConnector();
		
		conn.connect();
	}

}
