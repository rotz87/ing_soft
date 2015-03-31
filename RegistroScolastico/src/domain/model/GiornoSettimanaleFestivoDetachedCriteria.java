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

public class GiornoSettimanaleFestivoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _giorno;
	
	public GiornoSettimanaleFestivoDetachedCriteria() {
		super(domain.model.GiornoSettimanaleFestivo.class, domain.model.GiornoSettimanaleFestivoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_giorno = new IntegerExpression("_giorno", this.getDetachedCriteria());
	}
	
	public GiornoSettimanaleFestivoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.GiornoSettimanaleFestivoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_giorno = new IntegerExpression("_giorno", this.getDetachedCriteria());
	}
	
	public GiornoSettimanaleFestivo uniqueGiornoSettimanaleFestivo(PersistentSession session) {
		return (GiornoSettimanaleFestivo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public GiornoSettimanaleFestivo[] listGiornoSettimanaleFestivo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (GiornoSettimanaleFestivo[]) list.toArray(new GiornoSettimanaleFestivo[list.size()]);
	}
}

