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
import org.orm.criteria.*;

public class GiornoSettimanaleDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression giorno;
	
	public GiornoSettimanaleDetachedCriteria() {
		super(domain.model.GiornoSettimanale.class, domain.model.GiornoSettimanaleCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		giorno = new IntegerExpression("giorno", this.getDetachedCriteria());
	}
	
	public GiornoSettimanaleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.GiornoSettimanaleCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		giorno = new IntegerExpression("giorno", this.getDetachedCriteria());
	}
	
	public GiornoSettimanale uniqueGiornoSettimanale(PersistentSession session) {
		return (GiornoSettimanale) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public GiornoSettimanale[] listGiornoSettimanale(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (GiornoSettimanale[]) list.toArray(new GiornoSettimanale[list.size()]);
	}
}

