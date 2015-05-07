package presenter.resourceSupport.voto;

import java.util.Map;

import org.springframework.hateoas.ResourceSupport;

import domain.error.DomainCheckedException;
import domain.model.Voto;

public class VotoRS extends ResourceSupport {
	private  Map<Integer, String> label;

	public VotoRS() {
		
	}
	
	public VotoRS(Voto voto) throws DomainCheckedException {
		putVoto(voto);
	}


	public Voto takeVoto() throws DomainCheckedException{
		VotoConverter votoConverter;
		
		votoConverter = VotoConverterFactory.getInstance().create();

		return votoConverter.getVoto(this);
	}

	public void putVoto(Voto voto) throws DomainCheckedException{
		VotoConverter votoConverter;
		
		votoConverter = VotoConverterFactory.getInstance().create();
		
		votoConverter.setLabel(this, voto);
	}
	
	public FormatoVoti takeFormato() throws DomainCheckedException{
		VotoConverter votoConverter;
		
		votoConverter = VotoConverterFactory.getInstance().create();
		
		return votoConverter.getFormato();
	}

	public Map<Integer, String> getLabel() {
		return label;
	}

	public void setLabel(Map<Integer, String> label) {
		this.label = label;
	}
	
	
}
