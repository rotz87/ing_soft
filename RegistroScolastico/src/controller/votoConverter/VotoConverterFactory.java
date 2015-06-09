package controller.votoConverter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.reflections.Reflections;

import service.SystemPropertiesHandler;
import domain.error.DomainCheckedException;
import domain.error.ErrorMessage;

public class VotoConverterFactory {
	
	static private VotoConverterFactory instance;

	private final String packageName = VotoConverter.class.getPackage().getName();
	public final String converterPropertyKey = "VotoConverter.class.name";

	private VotoConverterFactory() {
	}

	static public VotoConverterFactory getInstance() {
		if (VotoConverterFactory.instance == null) {
			VotoConverterFactory.instance = new VotoConverterFactory();
		}
		return VotoConverterFactory.instance;
	}
	
	public VotoConverter create() throws DomainCheckedException{
		//legge la proprietà di sistema
//		return votoConverter;
		Object obj = null;
		String nomeConverter = System.getProperty(this.converterPropertyKey);
		
		try {
			obj = Class.forName(this.packageName+"."+nomeConverter).getDeclaredMethod("getInstance").invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException e) {
			throw new DomainCheckedException(ErrorMessage.CONVERTER_UNISTANZIABLE); 
		}
		
		return (VotoConverter)obj;
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
			
		//scrivere la proprietà di sistema
//		this.votoConverter = (VotoConverter)obj;
		try {
			SystemPropertiesHandler.getInstance().storeProperty(this.converterPropertyKey, nomeConverter);
		} catch (IOException e) {
			throw new DomainCheckedException(ErrorMessage.CONVERTER_UNISTANZIABLE); 
		}
		
	}
	
	public String classToString(Class<? extends VotoConverter> aClass){
		return aClass.getSimpleName();
	}
	
}
