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
	public final CollectionExpression libVotiLineItems;
	
	public LibrettoVotiCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		libVotiLineItems = new CollectionExpression("libVotiLineItems", this);
	}
	
	public LibrettoVotiCriteria(PersistentSession session) {
		this(session.createCriteria(LibrettoVoti.class));
	}
	
	public LibrettoVotiCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public LibrettoVotiLineItemCriteria createLibVotiLineItemsCriteria() {
		return new LibrettoVotiLineItemCriteria(createCriteria("libVotiLineItems"));
	}
	
	public LibrettoVoti uniqueLibrettoVoti() {
		return (LibrettoVoti) super.uniqueResult();
	}
	
	public LibrettoVoti[] listLibrettoVoti() {
		java.util.List list = super.list();
		return (LibrettoVoti[]) list.toArray(new LibrettoVoti[list.size()]);
	}
}

