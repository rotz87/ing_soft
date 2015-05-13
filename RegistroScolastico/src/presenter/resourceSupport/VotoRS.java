package presenter.resourceSupport;

import java.util.Map;

import org.springframework.hateoas.ResourceSupport;

import controller.votoConverter.FormatoVoti;
import controller.votoConverter.VotoConverter;
import controller.votoConverter.VotoConverterFactory;
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

		return votoConverter.labelToVoto(this.getLabel());
	}

	public void putVoto(Voto voto) throws DomainCheckedException{
		VotoConverter votoConverter;
		
		votoConverter = VotoConverterFactory.getInstance().create();
		
		this.setLabel(votoConverter.votoToLabel(voto));
	}

	public Map<Integer, String> getLabel() {
		return label;
	}

	public void setLabel(Map<Integer, String> label) {
		this.label = label;
	}
	
	
}
