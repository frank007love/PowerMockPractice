package org.tonylin.powermock.staticmethod;

public class SUT {

	public String testMethod() {
		return DOC.delegatedMethod();
	}
	
}
