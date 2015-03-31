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

public class MateriaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression _nome;
	
	public MateriaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_nome = new StringExpression("_nome", this);
	}
	
	public MateriaCriteria(PersistentSession session) {
		this(session.createCriteria(Materia.class));
	}
	
	public MateriaCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public Materia uniqueMateria() {
		return (Materia) super.uniqueResult();
	}
	
	public Materia[] listMateria() {
		java.util.List list = super.list();
		return (Materia[]) list.toArray(new Materia[list.size()]);
	}
}

