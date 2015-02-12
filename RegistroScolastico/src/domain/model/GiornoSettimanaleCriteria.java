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

public class GiornoSettimanaleCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression giorno;
	
	public GiornoSettimanaleCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		giorno = new IntegerExpression("giorno", this);
	}
	
	public GiornoSettimanaleCriteria(PersistentSession session) {
		this(session.createCriteria(GiornoSettimanale.class));
	}
	
	public GiornoSettimanaleCriteria() throws PersistentException {
		this(domain.model.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public GiornoSettimanale uniqueGiornoSettimanale() {
		return (GiornoSettimanale) super.uniqueResult();
	}
	
	public GiornoSettimanale[] listGiornoSettimanale() {
		java.util.List list = super.list();
		return (GiornoSettimanale[]) list.toArray(new GiornoSettimanale[list.size()]);
	}
}

