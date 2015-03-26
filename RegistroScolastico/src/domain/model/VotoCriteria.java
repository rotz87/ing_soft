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

public class VotoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final ByteExpression _voto;
	
	public VotoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_voto = new ByteExpression("_voto", this);
	}
	
	public VotoCriteria(PersistentSession session) {
		this(session.createCriteria(Voto.class));
	}
	
	public VotoCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public Voto uniqueVoto() {
		return (Voto) super.uniqueResult();
	}
	
	public Voto[] listVoto() {
		java.util.List list = super.list();
		return (Voto[]) list.toArray(new Voto[list.size()]);
	}
}

