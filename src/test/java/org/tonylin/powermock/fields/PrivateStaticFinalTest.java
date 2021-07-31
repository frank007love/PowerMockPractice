package org.tonylin.powermock.fields;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;

import org.junit.Test;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(PrivateStaticFinal.class)
public class PrivateStaticFinalTest {
	
    @Test
    public void testMethod2() throws Exception {
    	PowerMock.reset(PrivateStaticFinal.class);
    	System.out.println(PrivateStaticFinal.method());
    }
	
    @Test
    public void testMethod1() throws Exception {
		
		Field field = PowerMock.field(PrivateStaticFinal.class, "variable");
		field.setAccessible(true);
		 
		Field modifiersField = Field.class.getDeclaredField("modifiers"); 
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		
		field.set(null, Integer.valueOf(2));

		PowerMock.replayAll();
    	
    	
    	System.out.println(PrivateStaticFinal.method());
    }
    
    @Test
    public void testAddService() throws Exception {
    	ServiceHolder tested = new ServiceHolder();
    	final Object service = new Object();

    	tested.addService(service);

            // This is how you get the private services set using PowerMock
    	Set<String> services = Whitebox.getInternalState(tested,
    			"services");

    	assertEquals("Size of the \"services\" Set should be 1", 1, services
    			.size());
    	assertSame("The services Set should didn't contain the expect service",
    			service, services.iterator().next());
    }
    
    @Test
    public void testReportGeneratorStatic() {
    	ReportTemplateService docService = PowerMockito.mock(ReportTemplateService.class);
    	Whitebox.setInternalState(ReportGenerator.class, docService);
    	ReportTemplateService realService = Whitebox.getInternalState(ReportGenerator.class, ReportTemplateService.class);
    	
    	assertEquals(docService, realService);
    }
    
    @Test
    public void testReportGeneratorWithFieldName() {
    	ReportTemplateService docService = PowerMockito.mock(ReportTemplateService.class);
    	ReportGenerator sutGenerator = new ReportGenerator();
    	
    	Whitebox.setInternalState(sutGenerator, "reportTemplateService", docService);
    	ReportTemplateService realService = Whitebox.getInternalState(sutGenerator, "reportTemplateService");
    	
    	assertEquals(docService, realService);
    }
    

    @Test
    public void testReportGeneratorAutowire() {
    	ReportTemplateService docService = PowerMockito.mock(ReportTemplateService.class);
    	ReportGenerator sutGenerator = new ReportGenerator();
    	
    	Whitebox.setInternalState(sutGenerator, docService);
    	ReportTemplateService realService = Whitebox.getInternalState(sutGenerator, ReportTemplateService.class);
    	assertEquals(docService, realService);
    }
}

