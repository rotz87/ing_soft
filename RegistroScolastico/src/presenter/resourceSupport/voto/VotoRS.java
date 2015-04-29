package presenter.resourceSupport.voto;

import org.springframework.hateoas.ResourceSupport;
import java.util.Collection;
import java.util.Map;

public abstract class VotoRS extends ResourceSupport {
	private static Map<Integer, Collection<String>> labelAmmissibili;
	private static final int i = initializeI();
	
	private static int initializeI(){
		return 5;
	}
	
}
