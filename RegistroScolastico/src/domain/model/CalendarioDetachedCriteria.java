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

public class CalendarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression giorniFestivi;
	public final CollectionExpression giorniSettimanaliFestivi;
	
	public CalendarioDetachedCriteria() {
		super(domain.model.Calendario.class, domain.model.CalendarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		giorniFestivi = new CollectionExpression("giorniFestivi", this.getDetachedCriteria());
		giorniSettimanaliFestivi = new CollectionExpression("giorniSettimanaliFestivi", this.getDetachedCriteria());
	}
	
	public CalendarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.CalendarioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		giorniFestivi = new CollectionExpression("giorniFestivi", this.getDetachedCriteria());
		giorniSettimanaliFestivi = new CollectionExpression("giorniSettimanaliFestivi", this.getDetachedCriteria());
	}
	
	public GiornoDetachedCriteria createGiorniFestiviCriteria() {
		return new GiornoDetachedCriteria(createCriteria("giorniFestivi"));
	}
	
	public GiornoSettimanaleDetachedCriteria createGiorniSettimanaliFestiviCriteria() {
		return new GiornoSettimanaleDetachedCriteria(createCriteria("giorniSettimanaliFestivi"));
	}
	
	public Calendario uniqueCalendario(PersistentSession session) {
		return (Calendario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Calendario[] listCalendario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Calendario[]) list.toArray(new Calendario[list.size()]);
	}
}

