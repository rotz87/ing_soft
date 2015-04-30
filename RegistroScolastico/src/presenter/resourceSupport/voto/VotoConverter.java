package presenter.resourceSupport.voto;

import java.util.Collection;
import java.util.Map;

import domain.model.Voto;

public interface VotoConverter {

	public  Map<Integer, Collection<String>> getFormato();
	
	public Voto getVoto(VotoRS votoRS);
	
	public void setLabel(VotoRS votoRS, Voto voto);
	
	
}
