import emppack.Employee;
import emppack.EngineerAware;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

public class StubOnFinalMethod {
	private Employee emp;
	private static final String FIRST_NAME = "Joe";
	private static final String LAST_NAME = "M";
	private static final int AGE = 35;
	QA qa = new QA();
	
	@BeforeMethod
	public void buildSpy() {
		emp = spy(new Employee(FIRST_NAME, LAST_NAME, AGE));
	}
	
	@Test(expectedExceptions=RuntimeException.class)
	public void stubNonFinalMoveTo() {
		doThrow(new RuntimeException("Can't move to a different department")).when(emp).moveTo(qa);
		emp.moveTo(qa);
	}
	
	@Test(expectedExceptions=RuntimeException.class)
	public void stubFinalMoveTo() {
		doThrow(new RuntimeException("Can't move to a different department")).when(emp).finalMoveTo(qa);
		emp.finalMoveTo(qa);
	}
	
	private class QA implements EngineerAware {
		@Override
		public Engineer getDesignation() {
			return Engineer.QA;
		}		
	}
}
