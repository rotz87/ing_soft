package presenter;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.DatesInfoRS;
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
	
	
}