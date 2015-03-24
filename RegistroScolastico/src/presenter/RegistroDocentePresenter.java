package presenter;


import java.net.URI;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.compito.ArgomentiContainerRS;
import presenter.resourceSupport.compito.ArgomentoRS;
import presenter.resourceSupport.compito.CompitoInClasseRS;
import presenter.resourceSupport.compito.StudenteCompitoRS;
import service.Stampa;
import domain.controller.CompitoInClasseController;
import domain.controller.DocenteController;
import domain.controller.RegistroDocenteController;
import domain.model.Argomento;
import domain.model.CompitoInClasse;
import domain.model.RegistroDocente;
import domain.model.Studente;
import domain.model.Voto;


@RestController
@RequestMapping("/classi/{idClasse}/registriDocente/{idRegistroDocente}")
public class RegistroDocentePresenter {
	
	@RequestMapping(value = "/argomentiSvolti",  method = RequestMethod.GET)
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
