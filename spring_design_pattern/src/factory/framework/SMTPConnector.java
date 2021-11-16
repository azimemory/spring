package factory.framework;

import java.util.Date;

public abstract class SMTPConnector {
	
	protected String url;
	protected String id;
	protected String password;
	protected Date connectTime;
	
	public SMTPConnector(String url, String id, String password, Date connectTime) {
		super();
		this.url = url;
		this.id = id;
		this.password = password;
		this.connectTime = connectTime;
	}
	
	public abstract void connect();

	@Override
	public String toString() {
		return "SMTPConnector [url=" + url + ", id=" + id + ", password=" + password + ", connectTime=" + connectTime
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}
