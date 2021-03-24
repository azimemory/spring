package strategy.client;

import strategy.framework.dao.MemberDao;

public class Run {

	public static void main(String[] args) {
		String password = new MemberDao(new MyTemplate()).selectPassword("test");
		System.out.println("찾은 비밀번호는 " + password + " 입니다.");
	}
}
