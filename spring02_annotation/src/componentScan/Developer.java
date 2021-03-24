package componentScan;

import org.springframework.stereotype.Component;

//@Component : Spring의 applicationContext가 생성되는 시점에 
//			@Component 어노테이션이 등록된 클래스의 인스턴스를 자동으로 빈에 추가 해준다.

//value : bean에 등록될 때 사용할 아이디를 지정
//		  만약 value 속성값을 지정하지 않으면 타입명으로 아이디가 지정된다.
@Component(value = "dev")
public class Developer {
	
	public String jobName;
	
	public Developer(String jobName) {
		System.out.println("매개변수가 있는 생성자 : " + jobName);
		this.jobName = jobName;
	}
	
	public String getJobInfo() {
		return "개발자";
	}
}
