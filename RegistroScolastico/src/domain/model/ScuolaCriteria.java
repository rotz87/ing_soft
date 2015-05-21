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
	public final StringExpression _nome;
	public final CollectionExpression _classi;
	public final CollectionExpression _docenti;
	
	public ScuolaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_nome = new StringExpression("_nome", this);
		_classi = new CollectionExpression("_classi", this);
		_docenti = new CollectionExpression("_docenti", this);
	}
	
	public ScuolaCriteria(PersistentSession session) {
		this(session.createCriteria(Scuola.class));
	}
	
	public ScuolaCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public ClasseCriteria create_classiCriteria() {
		return new ClasseCriteria(createCriteria("_classi"));
	}
	
	public DocenteCriteria create_docentiCriteria() {
		return new DocenteCriteria(createCriteria("_docenti"));
	}
	
	public Scuola uniqueScuola() {
		return (Scuola) super.uniqueResult();
	}
	
	public Scuola[] listScuola() {
		java.util.List list = super.list();
		return (Scuola[]) list.toArray(new Scuola[list.size()]);
	}
}

