package templateCallback.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import templateCallback.framework.MemberDao;

public class Run {

	public static void main(String[] args) {
		
		//람다식
		//Functional Interface : 추상 메서드가 하나만 존재하는 인터페이스
		//						, 인터페이스 위에 @FunctionalInterface 어노테이션을 작성
		//Functional Interface의 추상메서드는 화살표함수의 형태로 표현이 가능
		//Functional Interface의 익명클래스를 생성해, 하나만 존재하는 Functional Interface를 override 한 뒤
		//						  해당 익명클래스의 인스턴스를 메서드의 매개변수로 전달.
		
		// * 자바의 화살표함수도 매개변수의 타입을 생략 가능
		// * 화살표함수의 메서드 block을 생략할 경우 마침표도 함께 생략
		
		// 매개변수가 하나밖에 없는 메서드	 
		// arg -> {...}
		
		// return 밖에 없는 경우, 메서드 block 생략, return문 생략
		// () -> a + b
		
		// 메서드의 구문이 1줄일 경우 메서드의 block을 생략
		
		String password = new MemberDao().selectPassword("dev", () -> {
				Connection conn = null;
				try {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
							 , "bookmanager", "1234");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return conn;
		});
		
		System.out.println("dev 님의 비밀번호는 " + password + "입니다.");

	}

}
