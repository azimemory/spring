package configure;

public class Book {
	
	private String title;
	private String author;
	private String publisher;
	private int page;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String publisher, int page) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.page = page;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", page=" + page + "]";
	}
	
	

}
