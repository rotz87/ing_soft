package presenter.resourceSupport;

import java.util.Collection;
import java.util.LinkedList;

import org.joda.time.LocalDate;
import org.springframework.hateoas.ResourceSupport;

import domain.model.GiornoSettimanaleFestivo;

public class DateFestiveRS  extends ResourceSupport{
	
	private Collection<Long> giorniFestivi = new LinkedList<Long>();
	private Collection<Integer> giorniSettimanaliFestivi = new LinkedList<Integer>();
	
	
	
	public DateFestiveRS(Collection<LocalDate> date, Collection<GiornoSettimanaleFestivo> giorniSettimanali) {
		for(LocalDate data : date){
			this.giorniFestivi.add(data.toDate().getTime());
		}
		for(GiornoSettimanaleFestivo gg : giorniSettimanali){
			this.giorniSettimanaliFestivi.add(gg.getGiorno()%7);
		}
	}
	public Collection<Long> getGiorniFestivi() {
		return giorniFestivi;
	}
	public void setGiorniFestivi(Collection<Long> giorniFestivi) {
		this.giorniFestivi = giorniFestivi;
	}
	public Collection<Integer> getGiorniSettimanaliFestivi() {
		return giorniSettimanaliFestivi;
	}
	public void setGiorniSettimanaliFestivi(
			Collection<Integer> giorniSettimanaliFestivi) {
		this.giorniSettimanaliFestivi = giorniSettimanaliFestivi;
	}
	
	

}
