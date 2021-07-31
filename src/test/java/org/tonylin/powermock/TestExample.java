//package org.tonylin.powermock;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.easymock.PowerMock;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({Example.class})
//public class TestExample {
//	@Test
//	public void testMain(){
//		PowerMock.mockStatic(System.class);
//		
//		System.exit(0);
//		
//		PowerMock.expectLastCall().times(1);
//		
//		PowerMock.replayAll();
//		
//		Example.main(new String[0]);
//	}
//	
//	@Test
//	public void testMainWithException1() throws Exception{
//		// mock System.exit
//		PowerMock.mockStatic(System.class);
//		System.exit(1);
//		PowerMock.expectLastCall().times(1);
//		
//		// mock constructor
//		Example example = PowerMock.createMockAndExpectNew(Example.class);
//		example.doSomething();
//		PowerMock.expectLastCall().andStubThrow(new RuntimeException());
//		
//		PowerMock.replayAll();
//		
//		Example.main(new String[0]);
//	}
//	
//	@Test
//	public void testMainWithException2() throws Exception{
//		// mock System.exit
//		PowerMock.mockStatic(System.class);
//		System.exit(1);
//		PowerMock.expectLastCall().times(1);
//		
//		// mock constructor
//		Example example = PowerMock.createNiceMock(Example.class);
//		PowerMock.expectNew(Example.class).andReturn(example);
//		example.doSomething();
//		PowerMock.expectLastCall().andStubThrow(new RuntimeException());
//		
//		PowerMock.replayAll();
//		
//		Example.main(new String[0]);
//	}
//}
//
//
//
