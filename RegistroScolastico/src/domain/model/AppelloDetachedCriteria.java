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

public class AppelloDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final DateExpression data;
	public final BooleanExpression assenzePrese;
	
	public AppelloDetachedCriteria() {
		super(domain.model.Appello.class, domain.model.AppelloCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
		assenzePrese = new BooleanExpression("assenzePrese", this.getDetachedCriteria());
	}
	
	public AppelloDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.AppelloCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
		assenzePrese = new BooleanExpression("assenzePrese", this.getDetachedCriteria());
	}
	
	public Appello uniqueAppello(PersistentSession session) {
		return (Appello) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Appello[] listAppello(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Appello[]) list.toArray(new Appello[list.size()]);
	}
}

