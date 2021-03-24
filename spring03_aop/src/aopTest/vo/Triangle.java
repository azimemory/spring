package aopTest.vo;

public class Triangle implements Shape{
	
	private String name;
	private int width;
	private int height;
	
	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(String name, int width, int height) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
	}

	public int getArea() {
		System.out.println("넓이 : " + width*height/2);
		return width*height/2;
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
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Triangle [name=" + name + ", width=" + width + ", height=" + height + "]";
	}
	
	

}
