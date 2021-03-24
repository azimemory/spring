package builder;

public class Calculator {
	
	private int res;
	
	public Calculator add(int val) {
		res += val;
		return this;
	}
	
	public Calculator substract(int val) {
		res -= val;
		return this;
	}
	
	public int out() {
		return res;
	}
}
