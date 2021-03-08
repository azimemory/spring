package factory;

import java.sql.Date;

public abstract class SMTPConnector {
	
	protected String url;
	protected String id;
	protected String password;
	protected Date currnetTime;

	public SMTPConnector(String url, String id, String password, Date currnetTime) {
		super();
		this.url = url;
		this.id = id;
		this.password = password;
		this.currnetTime = currnetTime;
	}

	public abstract void connect();

	@Override
	public String toString() {
		return "SMTPConnector [url=" + url + ", id=" + id + ", password=" + password + ", currnetTime=" + currnetTime
				+ "]";
	}
}
