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

public class RegistroDocenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression classeId;
	public final AssociationExpression classe;
	
	public RegistroDocenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		classeId = new IntegerExpression("classe.ID", this);
		classe = new AssociationExpression("classe", this);
	}
	
	public RegistroDocenteCriteria(PersistentSession session) {
		this(session.createCriteria(RegistroDocente.class));
	}
	
	public RegistroDocenteCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public ClasseCriteria createClasseCriteria() {
		return new ClasseCriteria(createCriteria("classe"));
	}
	
	public RegistroDocente uniqueRegistroDocente() {
		return (RegistroDocente) super.uniqueResult();
	}
	
	public RegistroDocente[] listRegistroDocente() {
		java.util.List list = super.list();
		return (RegistroDocente[]) list.toArray(new RegistroDocente[list.size()]);
	}
}

