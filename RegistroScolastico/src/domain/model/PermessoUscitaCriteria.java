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

public class PermessoUscitaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public PermessoUscitaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public PermessoUscitaCriteria(PersistentSession session) {
		this(session.createCriteria(PermessoUscita.class));
	}
	
	public PermessoUscitaCriteria() throws PersistentException {
		this(domain.model.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public PermessoUscita uniquePermessoUscita() {
		return (PermessoUscita) super.uniqueResult();
	}
	
	public PermessoUscita[] listPermessoUscita() {
		java.util.List list = super.list();
		return (PermessoUscita[]) list.toArray(new PermessoUscita[list.size()]);
	}
}

