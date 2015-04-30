package presenter;

import java.util.Collection;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.voto.VotoConverterFactory;
import domain.error.DomainCheckedException;
import domain.error.ErrorMessage;

@RestController
@RequestMapping(ApiPath.VOTI)
public class VotiPresenter {

	  @RequestMapping(value = ApiPath.FORMATO_VOTI, method = RequestMethod.GET)
	  public Map<Integer, Collection<String>> getFormatoVoti () {
		 
		  try {
			return VotoConverterFactory.getInstance().create().getFormato();
		} catch (DomainCheckedException e) {
			throw new RuntimeException(ErrorMessage.FORMATO_IRRECUPERABILE);
		}
	  }
}
