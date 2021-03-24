package factory;

import java.util.Date;

public class DaumMail extends SMTPConnector{

	public DaumMail(String url, String id, String password, Date connectTime) {
		super(url, id, password, connectTime);
	}

	@Override
	public void connect() {
		System.out.println("다음 SMTP 서버에 연결되었습니다.");
	}
}
