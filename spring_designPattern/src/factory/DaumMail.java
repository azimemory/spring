package factory;

import java.sql.Date;

public class DaumMail extends SMTPConnector {

	public DaumMail(String url, String id, String password, Date currnetTime) {
		super(url, id, password, currnetTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		System.out.println("다음 SMTP 서버에 연결되었습니다.");
	}

}
