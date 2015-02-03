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

public class CalendarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression instanceId;
	public final AssociationExpression instance;
	public final DateExpression dataOdierna;
	
	public CalendarioCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		instanceId = new IntegerExpression("instance.ID", this);
		instance = new AssociationExpression("instance", this);
		dataOdierna = new DateExpression("dataOdierna", this);
	}
	
	public CalendarioCriteria(PersistentSession session) {
		this(session.createCriteria(Calendario.class));
	}
	
	public CalendarioCriteria() throws PersistentException {
		this(domain.persistent.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public CalendarioCriteria createInstanceCriteria() {
		return new CalendarioCriteria(createCriteria("instance"));
	}
	
	public Calendario uniqueCalendario() {
		return (Calendario) super.uniqueResult();
	}
	
	public Calendario[] listCalendario() {
		java.util.List list = super.list();
		return (Calendario[]) list.toArray(new Calendario[list.size()]);
	}
}

