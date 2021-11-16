package factory.framework;

import java.util.Date;

public class NaverMailConnector extends SMTPConnector{

	protected NaverMailConnector(String url, String id, String password, Date connectTime) {
		super(url, id, password, connectTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		System.out.println("네이버 SMTP서버에 연결되었습니다.");
	}
}
