package presenter;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.EntrypointRS;

@RestController
@RequestMapping("/")
public class ApiEntryPointPresenter {
	

	/**
	 * Non utilizza un controller del dominio, accede direttamente al DB per prendere il docente.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public EntrypointRS getEntrypoint() {
		
		return new EntrypointRS();

	}

	
}