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

public class PermessoUscitaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public PermessoUscitaDetachedCriteria() {
		super(domain.model.PermessoUscita.class, domain.model.PermessoUscitaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public PermessoUscitaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.PermessoUscitaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public PermessoUscita uniquePermessoUscita(PersistentSession session) {
		return (PermessoUscita) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PermessoUscita[] listPermessoUscita(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PermessoUscita[]) list.toArray(new PermessoUscita[list.size()]);
	}
}

