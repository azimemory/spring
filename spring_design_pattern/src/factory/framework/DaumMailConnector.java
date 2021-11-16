package factory.framework;

import java.util.Date;

public class DaumMailConnector extends SMTPConnector{

	protected DaumMailConnector(String url, String id, String password, Date connectTime) {
		super(url, id, password, connectTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		System.out.println("다음 SMTP서버에 연결되었습니다.");
	}
	
}
