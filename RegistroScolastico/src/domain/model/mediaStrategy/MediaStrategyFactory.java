package domain.model.mediaStrategy;

import java.lang.reflect.InvocationTargetException;
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
			obj = Class.forName(this.packageName+"."+className).getDeclaredMethod("getInstance").invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new DomainCheckedException(ErrorMessage.STATO_UNISTANZIABLE);//FIXME creare un errore opportuno
		}
		return (IMediaStrategy)obj;
	}
	
	public String create(IMediaStrategy aClass){
		return aClass.getClass().getSimpleName().toString();
	}
	
	public Set<Class<? extends IMediaStrategy>> getStrategySubclasses(){
		
	      Reflections reflections;
	      Set<Class<? extends IMediaStrategy>> subTypes;
	      
	      reflections = new Reflections(this.packageName);
	      subTypes = reflections.getSubTypesOf(IMediaStrategy.class);
	      
	      return subTypes;
	      
	}
}