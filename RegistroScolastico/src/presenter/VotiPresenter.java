package presenter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.apache.zookeeper.server.quorum.Vote;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.voto.VotoConverter;
import presenter.resourceSupport.voto.VotoConverterFactory;
import domain.error.DomainCheckedException;
import domain.error.ErrorMessage;
import domain.model.mediaStrategy.IMediaStrategy;

@RestController
@RequestMapping(ApiPath.VOTI)
public class VotiPresenter {

	  @RequestMapping(value = ApiPath.FORMATO_VOTI, method = RequestMethod.GET)
	  public Map<Integer, Collection<String>> getFormatoVoti () {
		 
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
	  
	  @RequestMapping(value = ApiPath.VOTI_CONVERTER_ATTUALE, method = RequestMethod.GET)
	  public String[] getVotiConverterAttuale(){
		  String[] array = new String[1];
		  
		  array[0] = VotoConverterFactory.getInstance().create().getClass().getSimpleName();
		  
		  return array;
	  }
	  
}
