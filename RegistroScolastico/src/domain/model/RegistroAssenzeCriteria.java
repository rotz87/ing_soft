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

public class RegistroAssenzeCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression _appelli;
	
	public RegistroAssenzeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_appelli = new CollectionExpression("_appelli", this);
	}
	
	public RegistroAssenzeCriteria(PersistentSession session) {
		this(session.createCriteria(RegistroAssenze.class));
	}
	
	public RegistroAssenzeCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public AppelloCriteria create_appelliCriteria() {
		return new AppelloCriteria(createCriteria("_appelli"));
	}
	
	public RegistroAssenze uniqueRegistroAssenze() {
		return (RegistroAssenze) super.uniqueResult();
	}
	
	public RegistroAssenze[] listRegistroAssenze() {
		java.util.List list = super.list();
		return (RegistroAssenze[]) list.toArray(new RegistroAssenze[list.size()]);
	}
}

