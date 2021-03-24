package builder;

public class Run {
	
	public static void main(String[] args) {
		Book book = Book.builder()
					.title("홍길동")
					.author("김애란")
					.publisher("신사임당")
					.page(1000)
					.build();
		
		System.out.println(book);
		
		System.out.println("///////////////////////////////////");
		
		Calculator cal = new Calculator();
		System.out.println(cal.add(4).add(5).substract(3).out());
	}
}
