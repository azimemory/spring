package componentScan;

import org.springframework.stereotype.Component;

@Component
public class Lecture extends Job{
	@Override
	public String getJobInfo() {
		return "강사";
	}
}
