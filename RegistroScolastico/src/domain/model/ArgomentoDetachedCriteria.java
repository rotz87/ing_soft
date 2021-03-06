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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ArgomentoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression _nome;
	public final StringExpression _descrizione;
	public final DateExpression _data;
	
	public ArgomentoDetachedCriteria() {
		super(domain.model.Argomento.class, domain.model.ArgomentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_descrizione = new StringExpression("_descrizione", this.getDetachedCriteria());
		_data = new DateExpression("_data", this.getDetachedCriteria());
	}
	
	public ArgomentoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.ArgomentoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_descrizione = new StringExpression("_descrizione", this.getDetachedCriteria());
		_data = new DateExpression("_data", this.getDetachedCriteria());
	}
	
	public Argomento uniqueArgomento(PersistentSession session) {
		return (Argomento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Argomento[] listArgomento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Argomento[]) list.toArray(new Argomento[list.size()]);
	}
}

