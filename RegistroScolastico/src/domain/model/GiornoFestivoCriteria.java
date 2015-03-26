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

public class GiornoFestivoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DateExpression _data;
	
	public GiornoFestivoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_data = new DateExpression("_data", this);
	}
	
	public GiornoFestivoCriteria(PersistentSession session) {
		this(session.createCriteria(GiornoFestivo.class));
	}
	
	public GiornoFestivoCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public GiornoFestivo uniqueGiornoFestivo() {
		return (GiornoFestivo) super.uniqueResult();
	}
	
	public GiornoFestivo[] listGiornoFestivo() {
		java.util.List list = super.list();
		return (GiornoFestivo[]) list.toArray(new GiornoFestivo[list.size()]);
	}
}

