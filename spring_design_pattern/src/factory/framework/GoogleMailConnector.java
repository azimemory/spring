package factory.framework;

import java.util.Date;

public class GoogleMailConnector extends SMTPConnector{

	protected GoogleMailConnector(String url, String id, String password, Date connectTime) {
		super(url, id, password, connectTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		System.out.println("구글 SMTP서버에 연결되었습니다.");
	}

}
