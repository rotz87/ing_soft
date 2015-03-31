package presenter;


import java.util.Collection;
import java.util.LinkedList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.compito.ArgomentoRS;
import domain.controller.RegistroDocenteController;
import domain.model.Argomento;
import domain.model.RegistroDocente;


@RestController
//@RequestMapping("/classi/{idClasse}/registriDocente/{idRegistroDocente}")
@RequestMapping(ApiPath.REGISTRO_DOCENTE)
public class RegistroDocentePresenter {
	
//	@RequestMapping(value = "/argomentiSvolti",  method = RequestMethod.GET)
	@RequestMapping(value = ApiPath.ARGOMENTI_SVOLTI,  method = RequestMethod.GET)
	public Collection<ArgomentoRS> getArgomentiSvolti(@PathVariable int idClasse, @PathVariable int idRegistroDocente) {
		
		RegistroDocenteController registroDocenteController;
		RegistroDocente registroDocente;
		LinkedList<ArgomentoRS> argomentiRS;
		
		registroDocenteController = new RegistroDocenteController();
		registroDocente = registroDocenteController.getRegistroDocente(idRegistroDocente);
		argomentiRS = new LinkedList<ArgomentoRS>();
		
		for (Argomento argomento : registroDocente.getArgomentiSvolti()) {
			argomentiRS.add(new ArgomentoRS(argomento));
		}
		
		return argomentiRS;
	}

}
