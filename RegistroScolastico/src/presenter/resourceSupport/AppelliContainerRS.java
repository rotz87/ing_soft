package presenter.resourceSupport;

import java.util.Collection;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class AppelliContainerRS extends ResourceSupport {
	
	private boolean appelloAvviabile;
	private long dataAppelloOdierno;
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
	
	
	public long getDataAppelloAvviabile() {
		return dataAppelloOdierno;
	}
	
	
	public void setDataAppelloAvviabile(long dataAppelloAvviabile) {
		this.dataAppelloOdierno = dataAppelloAvviabile;
	}
	
	public Collection<AppelloRS> getAppelli() {
		return appelli;
	}
	
	
	public void setAppelli(Collection<AppelloRS> appelli) {
		this.appelli = appelli;
	}

}
