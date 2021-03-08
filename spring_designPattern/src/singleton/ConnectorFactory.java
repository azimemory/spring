package singleton;

import java.sql.Date;

public class ConnectorFactory {
	
	private String url;
	private String id;
	private String password;
	private Date currnetTime;
	//singleton 패턴 적용을 위한 static 레퍼런스
	private static ConnectorFactory instanse;
	
	private ConnectorFactory(ConnectorFactoryBuilder builder) {
		super();
		this.url = builder.url;
		this.id = builder.id;
		this.password = builder.password;
		this.currnetTime = new Date(new java.util.Date().getTime());
	}
	
	//singleton 패턴 적용
	private static ConnectorFactory getInstance(ConnectorFactoryBuilder builder) {
		if(instanse == null) {
			instanse = new ConnectorFactory(builder);
		}
		
		return instanse;
	}
	
    public static ConnectorFactoryBuilder builder() { 
	    return new ConnectorFactoryBuilder(); 
    }
    
	public static class ConnectorFactoryBuilder{
		private String url;
		private String id;
		private String password;
		
		public ConnectorFactoryBuilder url(String url) {
			this.url = url;
			return this;
		}
		
		public ConnectorFactoryBuilder id(String id) {
			this.id = id;
			return this;
		}
		
		public ConnectorFactoryBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public ConnectorFactory build() {
			return getInstance(this);
		}
	}

	public SMTPConnector getConnector(String mailName) {
		
		if(mailName.equalsIgnoreCase("google")) {
			return new GoogleMail(url,id,password,currnetTime);
		}else if(mailName.equalsIgnoreCase("daum")) {
			return new DaumMail(url,id,password,currnetTime);
		}else if(mailName.equalsIgnoreCase("naver")) {
			return new NaverMail(url,id,password,currnetTime);
		}else {
			System.out.println("잘못된 메일서버 이름을 입력하셨습니다.");
			return null;
		}
	}
}
