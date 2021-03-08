package singleton;

import java.sql.Date;

public class GoogleMail extends SMTPConnector{

	public GoogleMail(String url, String id, String password, Date currnetTime) {
		super(url, id, password, currnetTime);
	}

	@Override
	public void connect() {
		System.out.println("구글 SMTP 서버에 연결되었습니다.");
	}
}
