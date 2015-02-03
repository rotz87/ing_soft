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

public class ScuolaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression classi;
	public final CollectionExpression docenti;
	
	public ScuolaDetachedCriteria() {
		super(domain.persistent.Scuola.class, domain.persistent.ScuolaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		classi = new CollectionExpression("classi", this.getDetachedCriteria());
		docenti = new CollectionExpression("docenti", this.getDetachedCriteria());
	}
	
	public ScuolaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.persistent.ScuolaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		classi = new CollectionExpression("classi", this.getDetachedCriteria());
		docenti = new CollectionExpression("docenti", this.getDetachedCriteria());
	}
	
	public ClasseDetachedCriteria createClassiCriteria() {
		return new ClasseDetachedCriteria(createCriteria("classi"));
	}
	
	public DocenteDetachedCriteria createDocentiCriteria() {
		return new DocenteDetachedCriteria(createCriteria("docenti"));
	}
	
	public Scuola uniqueScuola(PersistentSession session) {
		return (Scuola) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Scuola[] listScuola(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Scuola[]) list.toArray(new Scuola[list.size()]);
	}
}

