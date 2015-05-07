package presenter.resourceSupport;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;

public class ErrorInfo {
	
	static final String defaultMsg = "Error occurred";
	
    public final String url;
    public final String exMsg;
    public final String stackTrace;
    public final String status;

    public ErrorInfo(String url, Exception ex, HttpStatus status) {
    	StringWriter sw = new StringWriter();
    	ex.printStackTrace(new PrintWriter(sw));
    	String msg;
        
        msg = ex.getLocalizedMessage();
        if(msg == null || msg == ""){
        	msg = ErrorInfo.defaultMsg;
        }
        
        this.url = url;
        this.exMsg = msg;
        this.stackTrace = sw.toString();
        this.status = status.toString();
    }
}
