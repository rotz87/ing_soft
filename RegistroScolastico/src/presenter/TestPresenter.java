package presenter;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.voto.VotoRS;
import sviluppo.Stampa;
import domain.error.DomainCheckedException;
import domain.model.Voto;


@RestController
@RequestMapping("/test")
public class TestPresenter {
	
	@RequestMapping(value = "/provaMap", method = RequestMethod.GET)
	public Map<Integer, Collection<String>> getMap(){// FIXME DA TOGLIERE
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
	public void putMap( @RequestBody Map<Integer, LinkedList<String>> collPippo){// FIXME DA TOGLIERE
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
	public VotoRS getVotoRS(){// FIXME DA TOGLIERE
		Voto voto = new Voto(10.7f);
		VotoRS votoRS = null;
		try {
			votoRS = new VotoRS(voto);
		} catch (DomainCheckedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return votoRS;
		
	}
	
}