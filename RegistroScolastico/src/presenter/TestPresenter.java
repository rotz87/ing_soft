package presenter;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.VotoRS;
import sviluppo.Stampa;
import controller.RegistroDocenteController;
import domain.error.DomainCheckedException;
import domain.model.RegistroDocente;
import domain.model.Voto;


@RestController
@RequestMapping("/test")
public class TestPresenter {
	
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public String getStrategy(){
		String strategyStr;
		
		RegistroDocenteController registroDocenteController = new RegistroDocenteController();
		
		RegistroDocente registroDocente = registroDocenteController.getRegistroDocente(1);
		
		strategyStr = registroDocente.getMediaStrategy().getClass().getSimpleName();
		
		return strategyStr;
		
	}
	
	@RequestMapping(value = "/provaMap", method = RequestMethod.GET)
	public Map<Integer, Collection<String>> getMap(){
		Map<Integer, Collection<String>> rit = new HashMap<Integer, Collection<String>>();
		Collection<String> collPippo = new LinkedList<String>();
		collPippo.add("s1");
		collPippo.add("s2");

		rit.put(1, collPippo);
		rit.put(2, collPippo);
		rit.put(3, collPippo);
		return rit;
		
	}
	
	@RequestMapping(value = "/provaMap", method = RequestMethod.POST)
	public void putMap( @RequestBody Map<Integer, LinkedList<String>> collPippo){
		Stampa.stampaln("colPippo: "+ collPippo);
		
		for (Integer i : collPippo.keySet())
		{
			Stampa.stampaln("i: "+i);
			for (String s : collPippo.get(i))
			{
				Stampa.stampaln("s: "+s);
			}
		}
	}
	
	@RequestMapping(value = "/votoRS", method = RequestMethod.GET)
	public VotoRS getVotoRS(){
		Voto voto = new Voto(10.7f);
		VotoRS votoRS = null;
		try {
			votoRS = new VotoRS(voto);
		} catch (DomainCheckedException e) {
			e.printStackTrace();
		}
		
		return votoRS;
		
	}
	
}