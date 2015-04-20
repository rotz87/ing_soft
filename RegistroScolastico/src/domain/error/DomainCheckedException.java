package domain.error;

public class DomainCheckedException extends Exception {
	
	public DomainCheckedException(){
		super();
	}
	
	public DomainCheckedException(String message){
		super(message);
	}
}
