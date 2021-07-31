package org.tonylin.powermock.fields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PowerMockUtil {

	static public void removeFinal(Field field) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field modifiersField = Field.class.getDeclaredField("modifiers"); 
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
	}
	
}
