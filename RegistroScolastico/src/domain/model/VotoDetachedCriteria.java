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

public class VotoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final ByteExpression _voto;
	
	public VotoDetachedCriteria() {
		super(domain.model.Voto.class, domain.model.VotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_voto = new ByteExpression("_voto", this.getDetachedCriteria());
	}
	
	public VotoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.VotoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_voto = new ByteExpression("_voto", this.getDetachedCriteria());
	}
	
	public Voto uniqueVoto(PersistentSession session) {
		return (Voto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Voto[] listVoto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Voto[]) list.toArray(new Voto[list.size()]);
	}
}

