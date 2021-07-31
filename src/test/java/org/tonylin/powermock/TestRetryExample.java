//package org.tonylin.powermock;
//
//import org.easymock.IAnswer;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.powermock.api.easymock.PowerMock;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({RetryExample.class, DaoUtil.class})
//public class TestRetryExample {
//	
//	@Test
//	public void testReadUser_failureAtFirstTime(){
//		User mockUser = PowerMock.createMock(User.class);
//		PowerMock.mockStaticStrict(DaoUtil.class);
//
//		DaoUtil.readUserFromDB();
//		PowerMock.expectLastCall().andThrow(new RuntimeException()).once();
//		
//		DaoUtil.readUserFromFile();
//		PowerMock.expectLastCall().andReturn(mockUser).once();
//		
//		PowerMock.replayAll();
//		
//		RetryExample retryExample = new RetryExample();
//		User user = retryExample.readUser();
//		assertEquals(mockUser, user);
//		PowerMock.verifyAll();
//	}
//	
//	@Test
//	public void testReadUser_failure2Times(){
//		final User mockUser = PowerMock.createMock(User.class);
//		PowerMock.mockStaticStrict(DaoUtil.class);
//
//		DaoUtil.readUserFromDB();
//		PowerMock.expectLastCall().andThrow(new RuntimeException()).once();
//		
//		DaoUtil.readUserFromFile();
//		PowerMock.expectLastCall().andAnswer(new IAnswer<User>() {
//			private int mTimes = 0;
//			@Override
//			public User answer() throws Throwable {
//				mTimes++;
//				if( mTimes == 1 ){
//					throw new RuntimeException();
//				}
//				return mockUser;
//			}
//			
//		}).times(2);
//		
//		PowerMock.replayAll();
//		
//		RetryExample retryExample = new RetryExample();
//		User user = retryExample.readUser();
//		assertEquals(mockUser, user);
//		PowerMock.verifyAll();
//	}
//	
//	@Test
//	public void testReadUser_failure3Time(){
//		PowerMock.mockStaticStrict(DaoUtil.class);
//
//		DaoUtil.readUserFromDB();
//		PowerMock.expectLastCall().andThrow(new RuntimeException()).once();
//		
//		DaoUtil.readUserFromFile();
//		PowerMock.expectLastCall().andThrow(new RuntimeException()).times(2);
//		
//		PowerMock.replayAll();
//		
//		RetryExample retryExample = new RetryExample();
//		
//		try {
//			retryExample.readUser();
//			fail();
//		} catch( Exception e ){
//			PowerMock.verifyAll();	
//		}
//	}
//}
