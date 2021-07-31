package org.tonylin.powermock;

public class Example {

	public Example(){
		
	}
	
	public void doSomething(){
		System.out.println("do something.");
	}
	
	public static void main(String[] args) {
		try {
			new Example().doSomething();
			System.exit(0);
		} catch( Exception e ){
			System.exit(1);
		} 
	}

}
