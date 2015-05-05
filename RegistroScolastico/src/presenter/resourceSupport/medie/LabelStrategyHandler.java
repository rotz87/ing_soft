package presenter.resourceSupport.medie;

import java.util.HashMap;
import java.util.Map;

import domain.model.mediaStrategy.MediaAritmeticaStrategy;
import domain.model.mediaStrategy.MediaScartaPeggioreStrategy;
import domain.model.mediaStrategy.MediaStrategyFactory;

public class LabelStrategyHandler {	
	static private LabelStrategyHandler instance;
	private Map<String, String> labels;

	private LabelStrategyHandler() {
		labels = new HashMap<String, String>();
		
		labels.put(MediaStrategyFactory.getInstance().create(MediaAritmeticaStrategy.class), "Media aritmetica");
		labels.put(MediaStrategyFactory.getInstance().create(MediaScartaPeggioreStrategy.class), "Scarta il peggiore");
		
	}

	static public LabelStrategyHandler getInstance() {
		if (LabelStrategyHandler.instance == null) {
			LabelStrategyHandler.instance = new LabelStrategyHandler();
		}
		return LabelStrategyHandler.instance;
	}
	
	

	public Map<String, String> getLabels() {
		return labels;
	}

}
