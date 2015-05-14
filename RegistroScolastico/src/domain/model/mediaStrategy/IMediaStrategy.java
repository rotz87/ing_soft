package domain.model.mediaStrategy;

import java.util.Collection;

import domain.model.LibrettoVotiLineItem;
import domain.model.Voto;

public interface IMediaStrategy {

	/**
	 * 
	 * @param registroDocente
	 */
	public Voto calcolaMedia(Collection<LibrettoVotiLineItem> libVotiLineItems);

}