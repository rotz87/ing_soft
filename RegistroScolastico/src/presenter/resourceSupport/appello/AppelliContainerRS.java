package presenter.resourceSupport.appello;

import java.util.Collection;
import java.sql.Date;

import org.springframework.hateoas.ResourceSupport;

public class AppelliContainerRS extends ResourceSupport {
	
	private boolean appelloAvviabile;
	private Long dataAppelloOdierno;
	private Collection<AppelloRS> appelli;
	
	public AppelliContainerRS(boolean appelloAvviabile, Date dataAppelloAvviabile, Collection<AppelloRS> appelli) {
		setAppelloAvviabile(appelloAvviabile);
		setDataAppelloAvviabile(dataAppelloAvviabile.getTime());
		setAppelli(appelli);
	}
	
	public boolean isAppelloAvviabile() {
		return appelloAvviabile;
	}
	
	
	public void setAppelloAvviabile(boolean appelloAvviabile) {
		this.appelloAvviabile = appelloAvviabile;
	}
	
	
	public Long getDataAppelloAvviabile() {
		return dataAppelloOdierno;
	}
	
	
	public void setDataAppelloAvviabile(Long dataAppelloAvviabile) {
		this.dataAppelloOdierno = dataAppelloAvviabile;
	}
	
	public Collection<AppelloRS> getAppelli() {
		return appelli;
	}
	
	
	public void setAppelli(Collection<AppelloRS> appelli) {
		this.appelli = appelli;
	}

}
