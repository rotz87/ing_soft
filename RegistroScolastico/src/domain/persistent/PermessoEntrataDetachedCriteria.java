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
package domain.persistent;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PermessoEntrataDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public PermessoEntrataDetachedCriteria() {
		super(domain.persistent.PermessoEntrata.class, domain.persistent.PermessoEntrataCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public PermessoEntrataDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.persistent.PermessoEntrataCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public PermessoEntrata uniquePermessoEntrata(PersistentSession session) {
		return (PermessoEntrata) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PermessoEntrata[] listPermessoEntrata(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PermessoEntrata[]) list.toArray(new PermessoEntrata[list.size()]);
	}
}

