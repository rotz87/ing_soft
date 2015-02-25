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

public class DocenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final CollectionExpression classi;
	
	public DocenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		cognome = new StringExpression("cognome", this);
		classi = new CollectionExpression("classi", this);
	}
	
	public DocenteCriteria(PersistentSession session) {
		this(session.createCriteria(Docente.class));
	}
	
	public DocenteCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public ClasseCriteria createClassiCriteria() {
		return new ClasseCriteria(createCriteria("classi"));
	}
	
	public Docente uniqueDocente() {
		return (Docente) super.uniqueResult();
	}
	
	public Docente[] listDocente() {
		java.util.List list = super.list();
		return (Docente[]) list.toArray(new Docente[list.size()]);
	}
}

