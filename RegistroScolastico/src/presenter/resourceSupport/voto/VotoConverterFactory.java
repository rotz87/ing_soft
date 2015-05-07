package presenter.resourceSupport.voto;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.reflections.Reflections;

import domain.error.DomainCheckedException;
import domain.error.ErrorMessage;

public class VotoConverterFactory {
	static private VotoConverterFactory instance;
	
	private VotoConverter votoConverter = VotoDecimalConverter.getInstance();
	

	private final String packageName = VotoConverter.class.getPackage().getName();

	private VotoConverterFactory() {
	}

	static public VotoConverterFactory getInstance() {
		if (VotoConverterFactory.instance == null) {
			VotoConverterFactory.instance = new VotoConverterFactory();
		}
		return VotoConverterFactory.instance;
	}
	
	public VotoConverter create(){
		return votoConverter;
	}

	public Set<Class<? extends VotoConverter>> getVotoConverterSubclasses(){
		
	      Reflections reflections;
	      Set<Class<? extends VotoConverter>> subTypes;
	      
	      reflections = new Reflections(this.packageName);
	      subTypes = reflections.getSubTypesOf(VotoConverter.class);
	      
	      return subTypes;
	      
	}
	
	public void setConverterSubclass(String nomeConverter) throws DomainCheckedException{
		Object obj = null;

			try {
				obj = Class.forName(this.packageName+"."+nomeConverter).getDeclaredMethod("getInstance").invoke(null);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException
					| SecurityException | ClassNotFoundException e) {
				throw new DomainCheckedException(ErrorMessage.CONVERTER_UNISTANZIABLE); 
			}

		this.votoConverter = (VotoConverter)obj;
	}
	
	public String classToString(Class<? extends VotoConverter> aClass){
		return aClass.getSimpleName();
	}
	
}
