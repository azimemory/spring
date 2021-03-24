package factory;

import java.util.Date;

public class GoogleMail extends SMTPConnector{

	public GoogleMail(String url, String id, String password, Date connectTime) {
		super(url, id, password, connectTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		System.out.println("구글 SMTP 서버에 연결되었습니다.");
	}
}
