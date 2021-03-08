package factory;

public class Run {

	public static void main(String[] args) {
		//ConnectorFactory 생성
		ConnectorFactory cf = ConnectorFactory
				.builder()
				.url("azimemory@gmail")
				.id("azimemory")
				.password("123qwe!@#")
				.build();
							
		//Google
		SMTPConnector connector = cf.getConnector("Google");
		System.out.println(connector);
		connector.connect();
		
		//Naver
		SMTPConnector naverConn = cf.getConnector("Naver");
		System.out.println(naverConn);
		naverConn.connect();
		
		//Daum
		SMTPConnector daumConn = cf.getConnector("Daum");
		System.out.println(daumConn);
		daumConn.connect();
	}
}
