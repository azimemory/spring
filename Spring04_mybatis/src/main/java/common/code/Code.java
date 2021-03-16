package common.code;

public enum Code {
	
	//DOMAIN("http://www.pclass.com"),
	DOMAIN("http://localhost:9797"),
	EMAIL("killsky2014@naver.com"),
	UPLOAD("C:\\CODE\\afternoon\\E_SERVLET\\resources\\upload\\");
	
	public String desc;
	
	Code(String desc){
		this.desc = desc;
	}
	
	public String toString() {
		return desc;
	}
}
