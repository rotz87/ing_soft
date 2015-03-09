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

public class GiornoFestivoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final DateExpression data;
	
	public GiornoFestivoDetachedCriteria() {
		super(domain.model.GiornoFestivo.class, domain.model.GiornoFestivoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
	}
	
	public GiornoFestivoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.GiornoFestivoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
	}
	
	public GiornoFestivo uniqueGiornoFestivo(PersistentSession session) {
		return (GiornoFestivo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public GiornoFestivo[] listGiornoFestivo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (GiornoFestivo[]) list.toArray(new GiornoFestivo[list.size()]);
	}
}

