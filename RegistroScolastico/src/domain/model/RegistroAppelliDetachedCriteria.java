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

public class RegistroAppelliDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression _appelli;
	
	public RegistroAppelliDetachedCriteria() {
		super(domain.model.RegistroAppelli.class, domain.model.RegistroAppelliCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_appelli = new CollectionExpression("_appelli", this.getDetachedCriteria());
	}
	
	public RegistroAppelliDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.RegistroAppelliCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_appelli = new CollectionExpression("_appelli", this.getDetachedCriteria());
	}
	
	public AppelloDetachedCriteria create_appelliCriteria() {
		return new AppelloDetachedCriteria(createCriteria("_appelli"));
	}
	
	public RegistroAppelli uniqueRegistroAppelli(PersistentSession session) {
		return (RegistroAppelli) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RegistroAppelli[] listRegistroAppelli(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RegistroAppelli[]) list.toArray(new RegistroAppelli[list.size()]);
	}
}

