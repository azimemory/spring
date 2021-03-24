package factory;

public class Run {

	public static void main(String[] args) {
		
		ConnectorFactory cf = ConnectorFactory.builder()
						.id("azimemory")
						.password("1234")
						.url("azimemory@gmail.com")
						.build();
		
		SMTPConnector gmail = cf.getConnector("google");
		System.out.println(gmail);
		gmail.connect();
		
	}
}
