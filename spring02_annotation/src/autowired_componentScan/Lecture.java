package autowired_componentScan;

import org.springframework.stereotype.Component;

@Component
public class Lecture {
	
	public String getJobInfo() {
		return "강사";
	}
}
