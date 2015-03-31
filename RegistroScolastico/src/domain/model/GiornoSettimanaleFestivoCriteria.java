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

public class GiornoSettimanaleFestivoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _giorno;
	
	public GiornoSettimanaleFestivoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_giorno = new IntegerExpression("_giorno", this);
	}
	
	public GiornoSettimanaleFestivoCriteria(PersistentSession session) {
		this(session.createCriteria(GiornoSettimanaleFestivo.class));
	}
	
	public GiornoSettimanaleFestivoCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public GiornoSettimanaleFestivo uniqueGiornoSettimanaleFestivo() {
		return (GiornoSettimanaleFestivo) super.uniqueResult();
	}
	
	public GiornoSettimanaleFestivo[] listGiornoSettimanaleFestivo() {
		java.util.List list = super.list();
		return (GiornoSettimanaleFestivo[]) list.toArray(new GiornoSettimanaleFestivo[list.size()]);
	}
}

