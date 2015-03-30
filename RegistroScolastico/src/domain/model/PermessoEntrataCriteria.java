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

public class PermessoEntrataCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public PermessoEntrataCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public PermessoEntrataCriteria(PersistentSession session) {
		this(session.createCriteria(PermessoEntrata.class));
	}
	
	public PermessoEntrataCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public PermessoEntrata uniquePermessoEntrata() {
		return (PermessoEntrata) super.uniqueResult();
	}
	
	public PermessoEntrata[] listPermessoEntrata() {
		java.util.List list = super.list();
		return (PermessoEntrata[]) list.toArray(new PermessoEntrata[list.size()]);
	}
}

