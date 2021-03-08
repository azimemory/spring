package builder;

public class Book {
	//객체 생성 패턴
	//1. 점층적 생성자 패턴
	//	 생성자의 매개변수를 사용해 객체를 초기화하고 생성하는 패턴
	//   단점 : 생성하는 코드에서, 생성자의 매개변수로 전달받는 인자가 어떤 속성을 의미하는 지 한 눈에 파악하기가 힘들다

	//2. 자바빈 패턴
	//	setter 메서드를 사용하기 때문에, 어떤 속성에 어떤 인자가 전달되는지 명확하다.
	//  단점 : 객체의 일관성이 깨진다.
	//	객체를 생성할 때 객체를 여러번 호출해야한다.
	//	setter 메서드의 존재로 변경 불가능한(immutable) 객체를 만들 수 없다
	//	스래드 세이프한 객체를 만들기 위해서 점층적 생성자 패턴보다 많은 일을 해야한다.
	
	//3. 빌더 패턴 : Effective Java의 Builder Pattern
	private String title;
	private String author;
	private String publisher;
	private int page;
	
	public static BookBuilder builder() {
		return new BookBuilder();
	}
	
	public static class BookBuilder{
		private String title;
		private String author;
		private String publisher;
		private int page;
		
		public BookBuilder title(String val) {
			this.title = val;
			return this;
		}
		
		public BookBuilder author(String val) {
			this.author = val;
			return this;
		}
		
		public BookBuilder publisher(String val) {
			this.publisher = val;
			return this;
		}
		
		public BookBuilder page(int val) {
			this.page = val;
			return this;
		}
		
		public Book build() {
			return new Book(this);
		}
	}
	
	private Book(BookBuilder builder) {
		this.title = builder.title;
		this.author = builder.author;
		this.publisher = builder.publisher;
		this.page = builder.page;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", page=" + page + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
