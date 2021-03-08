package factory;

import java.sql.Date;

public class NaverMail extends SMTPConnector{
	
	public NaverMail(String url, String id, String password, Date currnetTime) {
		super(url, id, password, currnetTime);
	}

	@Override
	public void connect() {
		System.out.println("네이버 SMTP 서버에 연결되었습니다.");
	}
}
