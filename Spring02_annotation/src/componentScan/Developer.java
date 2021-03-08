package componentScan;

import org.springframework.stereotype.Component;

@Component(value="dev")
public class Developer extends Job{
	
	@Override
	public String getJobInfo() {
		// TODO Auto-generated method stub
		return "개발자";
	}
}
