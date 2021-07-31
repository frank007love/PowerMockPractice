package org.tonylin.powermock.staticmethod;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.powermock.api.mockito.PowerMockito.*;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DOC.class})
public class SUTTest {
	@Test
	public void shouldReturnMockData_WhenDelegateExecutionToStaticMockDOC() {
		// Given
		String expectData = "MockData";
		mockStatic(DOC.class);
		doReturn(expectData).when(DOC.class);
		DOC.delegatedMethod();
		
		// When
		SUT sut = new SUT();
		String realData = sut.testMethod();
		
		// Then
		assertEquals(expectData, realData);
	}
}
