package factory;

import java.sql.Date;

//Factory 패턴(생성패턴)
// 장점 1 : 인스턴스를 생성하는 코드가 Factory 클래스에 모여 있다.
//		   인스턴스를 생성하기 위한 코드가 변경 되었을 때
//		   인스턴스를 생성하는 코드가 Factory 클래스에만 있음으로, 수정사항의 영향이 Factory 클래스로 한정된다.
public class ConnectorFactory {
	
	private String url;
	private String id;
	private String password;
	private Date currnetTime;
	
	private ConnectorFactory(ConnectorFactoryBuilder builder) {
		super();
		this.url = builder.url;
		this.id = builder.id;
		this.password = builder.password;
		this.currnetTime = new Date(new java.util.Date().getTime());
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
			return new ConnectorFactory(this);
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
