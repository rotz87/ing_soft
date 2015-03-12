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

public class ScuolaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final CollectionExpression classi;
	public final CollectionExpression docenti;
	
	public ScuolaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		classi = new CollectionExpression("classi", this);
		docenti = new CollectionExpression("docenti", this);
	}
	
	public ScuolaCriteria(PersistentSession session) {
		this(session.createCriteria(Scuola.class));
	}
	
	public ScuolaCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public ClasseCriteria createClassiCriteria() {
		return new ClasseCriteria(createCriteria("classi"));
	}
	
	public DocenteCriteria createDocentiCriteria() {
		return new DocenteCriteria(createCriteria("docenti"));
	}
	
	public Scuola uniqueScuola() {
		return (Scuola) super.uniqueResult();
	}
	
	public Scuola[] listScuola() {
		java.util.List list = super.list();
		return (Scuola[]) list.toArray(new Scuola[list.size()]);
	}
}

