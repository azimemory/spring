package beanTest;

public class Score {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the kor
	 */
	public int getKor() {
		return kor;
	}

	/**
	 * @param kor the kor to set
	 */
	public void setKor(int kor) {
		this.kor = kor;
	}

	/**
	 * @return the eng
	 */
	public int getEng() {
		return eng;
	}

	/**
	 * @param eng the eng to set
	 */
	public void setEng(int eng) {
		this.eng = eng;
	}

	/**
	 * @return the math
	 */
	public int getMath() {
		return math;
	}

	/**
	 * @param math the math to set
	 */
	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
	
	

}
