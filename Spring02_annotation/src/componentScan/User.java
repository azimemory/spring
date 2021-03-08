package componentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	//Autowired : ApplicationContext에 등록된 bean 중 어노테이션이 적용된 변수와 같은 타입의
	//			 bean이 있는 지 찾아서 넣어준다. 만약 찾지 못하면 예외가 발생된다.
	//Qualifier : Autowired를 적용한 변수 타입의 빈이 두 개 이상 ApplicationContext에 등록된 경우
	//			 어떤 bean을 사용 할 지 bean의 id로 지정하는 어노테이션
	@Autowired
	@Qualifier("dev")
	private Job job;
	
	public User() {
		System.out.println("User 인스턴스 생성");
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "User [job=" + job.getJobInfo() + "]";
	}
}
