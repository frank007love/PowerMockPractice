package org.tonylin.powermock.fields;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

public class ConstantsTest {

	@Test
	public void testDoubleObject() throws Exception {
		Field field = PowerMock.field(Constants2.class, "PI_DOUBLE");
		field.setAccessible(true);
		 
		PowerMockUtil.removeFinal(field);
		
		field.set(null, Double.valueOf(3.3));
		
		assertEquals(3.3, Constants2.PI_DOUBLE, 0.001);
	}

	@Test
	public void testStringObject() throws Exception {
		Field field = PowerMock.field(Constants2.class, "PI_STRING");
		field.setAccessible(true);
		 
		PowerMockUtil.removeFinal(field);
		
		field.set(null, "Shit");
		
		assertEquals("Shit", Constants2.PI_STRING);
	}

	@Test
	public void testStringObject2() throws Exception {
		Field field = PowerMock.field(Constants2.class, "PI_CONST_STRING");
		field.setAccessible(true);
		 
		PowerMockUtil.removeFinal(field);
		
		field.set(null, "Shit");
		
		assertEquals("Shit", Constants2.PI_CONST_STRING);
	}
}
