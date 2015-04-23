package domain.model.mediaStrategy;

import java.util.Collection;

import domain.model.*;

public interface IMediaStrategy {

	/**
	 * 
	 * @param registroDocente
	 */
	public Voto calcolaMedia(Collection<Voto> voti);

}