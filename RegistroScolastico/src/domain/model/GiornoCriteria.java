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

public class GiornoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DateExpression data;
	
	public GiornoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		data = new DateExpression("data", this);
	}
	
	public GiornoCriteria(PersistentSession session) {
		this(session.createCriteria(Giorno.class));
	}
	
	public GiornoCriteria() throws PersistentException {
		this(domain.model.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public Giorno uniqueGiorno() {
		return (Giorno) super.uniqueResult();
	}
	
	public Giorno[] listGiorno() {
		java.util.List list = super.list();
		return (Giorno[]) list.toArray(new Giorno[list.size()]);
	}
}

