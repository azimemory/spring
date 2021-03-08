package strategy.client;

import strategy.library.dao.MemberDao;

public class Run {

	public static void main(String[] args) {
		String password = new MemberDao(new MyTemplate())
		.selectPassword("select password from tb_member where user_id = 'testTT'");
		System.out.println("찾은 비밀번호는 " + password + " 입니다.");
	}
}
