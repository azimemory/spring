package factory;

import java.util.Date;

//Factory패턴(생성패턴)
// 장점 1 : 인스턴스를 생성하는 코드가 한 곳에 모여있다.
//			인스턴스를 생성하기 위한 코드가 변경되었을 때
//			인스턴스를 생성하는 코드는 Factory 클래스에만 있음으로 변경의 영향이 한정된다.

// 장점 2 : 사용자에게 최소한의 정보만 입력받은 뒤 추가적인 속성들은 내부에서 초기화하여
//			인스턴스를 생성할 수 있다.
public class ConnectorFactory {
	private String url;
	private String id;
	private String password;
	private Date connectTime;
	
	private ConnectorFactory(ConnectorFactoryBuilder builder) {
		super();
		this.url = builder.url;
		this.id = builder.id;
		this.password = builder.password;
		this.connectTime = new Date();
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
			return new GoogleMail(url,id,password,connectTime);
		}else if(mailName.equalsIgnoreCase("naver")) {
			return new NaverMail(mailName, mailName, mailName, connectTime);
		}else if(mailName.equalsIgnoreCase("daum")) {
			return new DaumMail(mailName, mailName, mailName, connectTime);
		}else {
			System.out.println("잘못된 메일서버 이름을 입력하셨습니다.");
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
