package configure;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Rent {

	private Date rentDate = new Date();
	
	@Autowired
	private Book rentBook;
	
	public Rent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Rent [rentDate=" + rentDate + ", rentBook=" + rentBook + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
