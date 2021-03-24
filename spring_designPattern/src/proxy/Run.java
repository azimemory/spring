package proxy;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Developer man = new Aspect(sc.nextLine());
		Developer woman = new Aspect(sc.nextLine());
		Developer child = new Aspect(sc.nextLine());
		
		man.develop();
		System.out.println("=============================");
		woman.develop();
		System.out.println("=============================");
		child.develop();
	}
}
