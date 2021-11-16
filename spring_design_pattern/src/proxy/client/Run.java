package proxy.client;

import proxy.framework.Aspect;

public class Run {
	
	public static void main(String[] args) {
		
		new Aspect("proxy.client.Man").develop();
		System.out.println("========================");
		new Aspect("proxy.client.Woman").develop();
		System.out.println("========================");
		new Aspect("proxy.client.Child").develop();
	}

}
