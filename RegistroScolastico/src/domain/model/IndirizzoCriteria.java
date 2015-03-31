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

public class IndirizzoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression _via;
	
	public IndirizzoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_via = new StringExpression("_via", this);
	}
	
	public IndirizzoCriteria(PersistentSession session) {
		this(session.createCriteria(Indirizzo.class));
	}
	
	public IndirizzoCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public Indirizzo uniqueIndirizzo() {
		return (Indirizzo) super.uniqueResult();
	}
	
	public Indirizzo[] listIndirizzo() {
		java.util.List list = super.list();
		return (Indirizzo[]) list.toArray(new Indirizzo[list.size()]);
	}
}

