package factory;

import java.util.Date;

public class NaverMail extends SMTPConnector{

	public NaverMail(String url, String id, String password, Date connectTime) {
		super(url, id, password, connectTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		System.out.println("네이버 SMTP 서버에 연결되었습니다.");
	}
}
