package emppack;

public interface EngineerAware {
	Engineer getDesignation();
	
	enum Engineer {
		DEV,QA
	}
}
