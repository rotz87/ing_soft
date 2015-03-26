package presenter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import presenter.resourceSupport.ErrorInfo;

@ControllerAdvice
class GlobalControllerExceptionHandler {
	
	/**
	 * 
	 * @param req
	 * @param ex
	 */
	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorInfo> defaultHandler(HttpServletRequest req, Exception ex){
    	
       	HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
       	ErrorInfo errorInfo = new ErrorInfo(req.getRequestURL().toString(), ex, httpStatus);
       	ex.printStackTrace();
       	return new ResponseEntity(errorInfo, new HttpHeaders(), httpStatus);
       	
    }
    
    /**
	 * 
	 * @param req
	 * @param ex
	 */
	@ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorInfo> handleForbiddenOperation(HttpServletRequest req, Exception ex) {
    	
       	HttpStatus httpStatus = HttpStatus.FORBIDDEN;
       	ErrorInfo errorInfo = new ErrorInfo(req.getRequestURL().toString(), ex, httpStatus);
       	ex.printStackTrace();
       	return new ResponseEntity(errorInfo, new HttpHeaders(), httpStatus);
       	
    }

}