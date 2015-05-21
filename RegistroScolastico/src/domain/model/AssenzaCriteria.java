/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.model;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AssenzaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _giustificazioneId;
	public final AssociationExpression _giustificazione;
	public final CollectionExpression _appelli;
	
	public AssenzaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_giustificazioneId = new IntegerExpression("_giustificazione.ID", this);
		_giustificazione = new AssociationExpression("_giustificazione", this);
		_appelli = new CollectionExpression("_appelli", this);
	}
	
	public AssenzaCriteria(PersistentSession session) {
		this(session.createCriteria(Assenza.class));
	}
	
	public AssenzaCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public GiustificazioneCriteria create_giustificazioneCriteria() {
		return new GiustificazioneCriteria(createCriteria("_giustificazione"));
	}
	
	public AppelloCriteria create_appelliCriteria() {
		return new AppelloCriteria(createCriteria("_appelli"));
	}
	
	public Assenza uniqueAssenza() {
		return (Assenza) super.uniqueResult();
	}
	
	public Assenza[] listAssenza() {
		java.util.List list = super.list();
		return (Assenza[]) list.toArray(new Assenza[list.size()]);
	}
}

