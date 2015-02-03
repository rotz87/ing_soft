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
package domain.persistent;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AppelloCriteria extends AbstractORMCriteria {
	public final LongExpression idAppello;
	public final DateExpression data;
	public final BooleanExpression assenzePrese;
	
	public AppelloCriteria(Criteria criteria) {
		super(criteria);
		idAppello = new LongExpression("idAppello", this);
		data = new DateExpression("data", this);
		assenzePrese = new BooleanExpression("assenzePrese", this);
	}
	
	public AppelloCriteria(PersistentSession session) {
		this(session.createCriteria(Appello.class));
	}
	
	public AppelloCriteria() throws PersistentException {
		this(domain.persistent.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public Appello uniqueAppello() {
		return (Appello) super.uniqueResult();
	}
	
	public Appello[] listAppello() {
		java.util.List list = super.list();
		return (Appello[]) list.toArray(new Appello[list.size()]);
	}
}

