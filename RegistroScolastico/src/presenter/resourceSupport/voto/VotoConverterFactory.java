package presenter.resourceSupport.voto;

import java.lang.reflect.InvocationTargetException;

import domain.error.ErrorMessage;
import domain.error.DomainCheckedException;

public class VotoConverterFactory {
	static private VotoConverterFactory instance;
	
//	private Class converterClass = VotoDecimalConveter.class;
//	private Class converterClass = VotoLettereConverter.class;
	private Class converterClass = VotoNumeroEIncrementiConverter.class;
	
	private VotoConverterFactory() {
	}

	static public VotoConverterFactory getInstance() {
		if (VotoConverterFactory.instance == null) {
			VotoConverterFactory.instance = new VotoConverterFactory();
		}
		return VotoConverterFactory.instance;
	}
	
	public VotoConverter create() throws DomainCheckedException{
		VotoConverter votoConverter;
		votoConverter = null;
		try {
			votoConverter = (VotoConverter) converterClass.getDeclaredMethod("getInstance").invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new DomainCheckedException(ErrorMessage.CONVERTER_UNISTANZIABLE);
		}
	return votoConverter;
	}

}
