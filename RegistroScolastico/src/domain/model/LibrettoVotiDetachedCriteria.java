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

public class LibrettoVotiDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression _libVotiLineItems;
	
	public LibrettoVotiDetachedCriteria() {
		super(domain.model.LibrettoVoti.class, domain.model.LibrettoVotiCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_libVotiLineItems = new CollectionExpression("_libVotiLineItems", this.getDetachedCriteria());
	}
	
	public LibrettoVotiDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.LibrettoVotiCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_libVotiLineItems = new CollectionExpression("_libVotiLineItems", this.getDetachedCriteria());
	}
	
	public LibrettoVotiLineItemDetachedCriteria create_libVotiLineItemsCriteria() {
		return new LibrettoVotiLineItemDetachedCriteria(createCriteria("_libVotiLineItems"));
	}
	
	public LibrettoVoti uniqueLibrettoVoti(PersistentSession session) {
		return (LibrettoVoti) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public LibrettoVoti[] listLibrettoVoti(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (LibrettoVoti[]) list.toArray(new LibrettoVoti[list.size()]);
	}
}

