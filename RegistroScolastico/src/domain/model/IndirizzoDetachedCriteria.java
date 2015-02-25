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

public class IndirizzoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public IndirizzoDetachedCriteria() {
		super(domain.model.Indirizzo.class, domain.model.IndirizzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public IndirizzoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.IndirizzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public Indirizzo uniqueIndirizzo(PersistentSession session) {
		return (Indirizzo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Indirizzo[] listIndirizzo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Indirizzo[]) list.toArray(new Indirizzo[list.size()]);
	}
}

