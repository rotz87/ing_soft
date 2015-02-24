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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.DateExpression;
import org.orm.criteria.IntegerExpression;

public class GiornoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final DateExpression data;
	
	public GiornoDetachedCriteria() {
		super(domain.model.Giorno.class, domain.model.GiornoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
	}
	
	public GiornoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.GiornoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
	}
	
	public Giorno uniqueGiorno(PersistentSession session) {
		return (Giorno) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Giorno[] listGiorno(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Giorno[]) list.toArray(new Giorno[list.size()]);
	}
}

