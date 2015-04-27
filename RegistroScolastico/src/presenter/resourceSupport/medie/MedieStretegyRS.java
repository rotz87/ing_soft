package presenter.resourceSupport.medie;

import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.ResourceSupport;

import domain.model.mediaStrategy.IMediaStrategy;
import domain.model.mediaStrategy.MediaStrategyFactory;
import domain.model.mediaStrategy.LabelStrategyHandler;

public class MedieStretegyRS extends ResourceSupport {

	private String className;
	private String label;
	
	public MedieStretegyRS(){
		
	}
	
	public MedieStretegyRS(Class<? extends IMediaStrategy> aStrategySubClass){
		this.className = MediaStrategyFactory.getInstance().create(aStrategySubClass);

		this.label = LabelStrategyHandler.getInstance().getLabels().get(this.className);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
