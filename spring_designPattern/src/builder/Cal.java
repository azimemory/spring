package builder;

public class Cal {
	
	private int res;
	
	public Cal add(int val) {
		res += val;
		return this;
	}
	
	public Cal substract(int val) {
		res -= val;
		return this;
	}
	
	public int out() {
		return res;
	}

}
