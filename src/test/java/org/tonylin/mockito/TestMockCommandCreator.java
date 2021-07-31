package org.tonylin.mockito;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.MockingDetails;
import org.mockito.internal.util.MockUtil;

import static org.mockito.Mockito.*;

public class TestMockCommandCreator {

	private <T extends BatchCommandImpl> CommandCreator mockCommandCreator(T mockCommand){
		CommandCreator cmdCreator = mock(CommandCreator.class);
		
		Class<? extends BatchCommandImpl> mockType = null;
		if(mockingDetails(mockCommand).isMock()){
			mockType = (Class<? extends BatchCommandImpl>)mockCommand.getClass().getSuperclass();
		} else {
			mockType = mockCommand.getClass();
		}
		
		doReturn(mockCommand).when(cmdCreator);
		cmdCreator.createCommand(mockType);
		
		return cmdCreator;
	}
	
	
	private <T extends Command> CommandCreator mockCommandCreator(T mockCommand){
		CommandCreator cmdCreator = mock(CommandCreator.class);
		
		doReturn(mockCommand).when(cmdCreator);
		cmdCreator.createCommand(mockCommand.getClass());
		
		return cmdCreator;
	}

	@Test
	public void test() {
		// interface
		BatchCommand mockCommand = 	mock(BatchCommand.class); 
		System.out.println(mockCommand.getClass());
		System.out.println(mockCommand.getClass().getSuperclass());
		System.out.println(mockingDetails(mockCommand).getMockCreationSettings().getTypeToMock());
		
		// concrete class
		BatchCommand mockCommand2 = 	mock(BatchCommandImpl.class); 
		System.out.println(mockCommand2.getClass());
		System.out.println(mockCommand2.getClass().getSuperclass());
		
		System.out.println(mockingDetails(mockCommand).isMock());
		System.out.println(mockingDetails(new BatchCommandImpl()).isMock());
	}

}
