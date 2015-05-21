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

public class GiustificazioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression _confermata;
	
	public GiustificazioneCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_confermata = new BooleanExpression("_confermata", this);
	}
	
	public GiustificazioneCriteria(PersistentSession session) {
		this(session.createCriteria(Giustificazione.class));
	}
	
	public GiustificazioneCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public Giustificazione uniqueGiustificazione() {
		return (Giustificazione) super.uniqueResult();
	}
	
	public Giustificazione[] listGiustificazione() {
		java.util.List list = super.list();
		return (Giustificazione[]) list.toArray(new Giustificazione[list.size()]);
	}
}

