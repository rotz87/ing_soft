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

public class ArgomentoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression _nome;
	public final StringExpression _descrizione;
	public final DateExpression _data;
	
	public ArgomentoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_nome = new StringExpression("_nome", this);
		_descrizione = new StringExpression("_descrizione", this);
		_data = new DateExpression("_data", this);
	}
	
	public ArgomentoCriteria(PersistentSession session) {
		this(session.createCriteria(Argomento.class));
	}
	
	public ArgomentoCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public Argomento uniqueArgomento() {
		return (Argomento) super.uniqueResult();
	}
	
	public Argomento[] listArgomento() {
		java.util.List list = super.list();
		return (Argomento[]) list.toArray(new Argomento[list.size()]);
	}
}

