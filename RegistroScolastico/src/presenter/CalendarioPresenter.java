package presenter;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.DatesInfoRS;
import presenter.resourceSupport.compito.CompitoInClasseRS;
import sviluppo.Stampa;
import domain.model.Calendario;


@RestController
//@RequestMapping("/calendario")
@RequestMapping(ApiPath.CALENDARIO)
public class CalendarioPresenter {
	

	@RequestMapping(method = RequestMethod.GET)
	public DatesInfoRS getDatesInfo() {
		
		DatesInfoRS datesInfoRS;
		
		datesInfoRS = new DatesInfoRS();
		
		datesInfoRS.setInizioAnno(Calendario.getInstance().getInizioLezioni().toDate().getTime());
		datesInfoRS.setFineAnno(Calendario.getInstance().getFineLezioni().toDate().getTime());
		datesInfoRS.setOggi(Calendario.getInstance().getDataOdierna().toDate().getTime());
		
		return datesInfoRS;
		
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
	
	
}