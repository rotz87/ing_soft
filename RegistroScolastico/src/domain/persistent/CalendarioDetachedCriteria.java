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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CalendarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression instanceId;
	public final AssociationExpression instance;
	public final DateExpression dataOdierna;
	
	public CalendarioDetachedCriteria() {
		super(domain.persistent.Calendario.class, domain.persistent.CalendarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		instanceId = new IntegerExpression("instance.ID", this.getDetachedCriteria());
		instance = new AssociationExpression("instance", this.getDetachedCriteria());
		dataOdierna = new DateExpression("dataOdierna", this.getDetachedCriteria());
	}
	
	public CalendarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.persistent.CalendarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		instanceId = new IntegerExpression("instance.ID", this.getDetachedCriteria());
		instance = new AssociationExpression("instance", this.getDetachedCriteria());
		dataOdierna = new DateExpression("dataOdierna", this.getDetachedCriteria());
	}
	
	public CalendarioDetachedCriteria createInstanceCriteria() {
		return new CalendarioDetachedCriteria(createCriteria("instance"));
	}
	
	public Calendario uniqueCalendario(PersistentSession session) {
		return (Calendario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Calendario[] listCalendario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Calendario[]) list.toArray(new Calendario[list.size()]);
	}
}

