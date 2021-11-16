package templateMethod.client;

public class Run {

	public static void main(String[] args) {
		
		String password = new MemberDao().selectPassword("dev");
		System.out.println("dev 님의 비밀번호는 " + password + "입니다.");

	}

}
