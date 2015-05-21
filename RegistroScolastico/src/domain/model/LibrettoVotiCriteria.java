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

public class LibrettoVotiCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression _libVotiLineItems;
	
	public LibrettoVotiCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_libVotiLineItems = new CollectionExpression("_libVotiLineItems", this);
	}
	
	public LibrettoVotiCriteria(PersistentSession session) {
		this(session.createCriteria(LibrettoVoti.class));
	}
	
	public LibrettoVotiCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public LibrettoVotiLineItemCriteria create_libVotiLineItemsCriteria() {
		return new LibrettoVotiLineItemCriteria(createCriteria("_libVotiLineItems"));
	}
	
	public LibrettoVoti uniqueLibrettoVoti() {
		return (LibrettoVoti) super.uniqueResult();
	}
	
	public LibrettoVoti[] listLibrettoVoti() {
		java.util.List list = super.list();
		return (LibrettoVoti[]) list.toArray(new LibrettoVoti[list.size()]);
	}
}

