package builder;

public class Run {

	public static void main(String[] args) {
		Book book = Book
				.builder()
				.title("장길산")
				.author("홍길동")
				.publisher("신사임당")
				.page(1000)
				.build();
		System.out.println(book);
		
		/////////////////////// 면접문제  ////////////////////////
		
		Cal cal = new Cal();
		int res = cal.add(4).add(5).substract(3).out();
		System.out.println(res);
	}
}
