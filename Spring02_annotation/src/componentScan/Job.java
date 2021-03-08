package componentScan;

public abstract class Job {
	
	public Job() {
		System.out.println("Job 인스턴스 생성");
	}
	
	public abstract String getJobInfo();
	
}
