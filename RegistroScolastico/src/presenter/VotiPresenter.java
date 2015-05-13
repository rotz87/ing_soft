package presenter;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controller.votoConverter.FormatoVoti;
import controller.votoConverter.VotoConverter;
import controller.votoConverter.VotoConverterFactory;
import domain.error.DomainCheckedException;
import domain.error.ErrorMessage;

@RestController
@RequestMapping(ApiPath.VOTI)
public class VotiPresenter {

	  @RequestMapping(value = ApiPath.FORMATO_VOTI, method = RequestMethod.GET)
	  public FormatoVoti getFormatoVoti () {
		 
			return VotoConverterFactory.getInstance().create().getFormato();

	  }
	  
	  @RequestMapping(value = ApiPath.VOTI_CONVERTERS, method = RequestMethod.GET)
	  public Collection<String> getVotiConverterSubclasses(){
		  Collection<String> rit;
		  
		  rit = new LinkedList<String>();
		  
		  for(Class<? extends VotoConverter> aClass : VotoConverterFactory.getInstance().getVotoConverterSubclasses()){
			  rit.add(aClass.getSimpleName());
		  }
		  
		  return rit;
	  }
	  
	  
	  /*
	   *  gli array servono per questioni di compatibilità deglli oggetti json con AngularJS
	   */
	  @RequestMapping(value = ApiPath.VOTI_CONVERTER_ATTUALE, method = RequestMethod.PUT)
	  public ResponseEntity<?> setVotiConverterSubclass(@RequestBody String[] nomeConverter){
		  try {
			VotoConverterFactory.getInstance().setConverterSubclass(nomeConverter[0]);
		} catch (DomainCheckedException e) {
			throw new RuntimeException(ErrorMessage.CONVERTER_UNISTANZIABLE);
		}
		  
		  HttpHeaders httpHeaders;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.OK;
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	  }
	  
	  /*
	   *  gli array servono per questioni di compatibilità deglli oggetti json con AngularJS
	   */
	  @RequestMapping(value = ApiPath.VOTI_CONVERTER_ATTUALE, method = RequestMethod.GET)
	  public String[] getVotiConverterAttuale(){
		  String[] array = new String[1];
		  
		  array[0] = VotoConverterFactory.getInstance().create().getClass().getSimpleName();
		  
		  return array;
	  }
	  
}
