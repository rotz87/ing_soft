package domain.model.mediaStrategy;

import java.util.Set;

import org.reflections.Reflections;

import domain.error.DomainCheckedException;
import domain.error.ErrorMessage;

public class MediaStrategyFactory {
	static private MediaStrategyFactory instance;
	
	private final String packageName = IMediaStrategy.class.getPackage().getName();
	

	private MediaStrategyFactory() {
	}

	static public MediaStrategyFactory getInstance() {
		if (MediaStrategyFactory.instance == null) {
			MediaStrategyFactory.instance = new MediaStrategyFactory();
		}
		return MediaStrategyFactory.instance;
	}
	
	public IMediaStrategy create(String className) throws DomainCheckedException {
		Object obj = null;
		try {
			obj = Class.forName(this.packageName+"."+className).newInstance();
		} catch (IllegalAccessException | IllegalArgumentException | SecurityException | ClassNotFoundException | InstantiationException e) {
			throw new DomainCheckedException(ErrorMessage.STRATEGIA_UNISTANZIABLE);
		}
		return (IMediaStrategy)obj;
	}
	
	public String create(Class<? extends IMediaStrategy> aClass){
		return aClass.getSimpleName().toString();
	}
	
	public String create(IMediaStrategy aStrategy){
		return aStrategy.getClass().getSimpleName().toString();
	}
	
	public Set<Class<? extends IMediaStrategy>> getStrategySubclasses(){
		
	      Reflections reflections;
	      Set<Class<? extends IMediaStrategy>> subTypes;
	      
	      reflections = new Reflections(this.packageName);
	      subTypes = reflections.getSubTypesOf(IMediaStrategy.class);
	      
	      return subTypes;
	      
	}
}