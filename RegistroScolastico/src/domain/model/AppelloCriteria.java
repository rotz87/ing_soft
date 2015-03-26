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

public class AppelloCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DateExpression _data;
	public final BooleanExpression _assenzePrese;
	
	public AppelloCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_data = new DateExpression("_data", this);
		_assenzePrese = new BooleanExpression("_assenzePrese", this);
	}
	
	public AppelloCriteria(PersistentSession session) {
		this(session.createCriteria(Appello.class));
	}
	
	public AppelloCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public Appello uniqueAppello() {
		return (Appello) super.uniqueResult();
	}
	
	public Appello[] listAppello() {
		java.util.List list = super.list();
		return (Appello[]) list.toArray(new Appello[list.size()]);
	}
}

