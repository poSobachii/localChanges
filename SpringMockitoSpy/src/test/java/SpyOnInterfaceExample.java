import emppack.EngineerAware.Engineer;
import emppack.EngineerAware;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SpyOnInterfaceExample {
	@Test
	public void spyOnInterface() {
		EngineerAware engineerAware = spy(new Dev());
		assertEquals(Engineer.DEV, engineerAware.getDesignation());
		when(engineerAware.getDesignation()).thenReturn(Engineer.QA);
		assertEquals(Engineer.QA, engineerAware.getDesignation());
	}	
	private class Dev implements EngineerAware {
		@Override
		public Engineer getDesignation() {
			return Engineer.DEV;
		}
		
	}
}
