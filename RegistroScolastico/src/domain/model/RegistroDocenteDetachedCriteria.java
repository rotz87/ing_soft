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

public class RegistroDocenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression classeId;
	public final AssociationExpression classe;
	
	public RegistroDocenteDetachedCriteria() {
		super(domain.model.RegistroDocente.class, domain.model.RegistroDocenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		classeId = new IntegerExpression("classe.ID", this.getDetachedCriteria());
		classe = new AssociationExpression("classe", this.getDetachedCriteria());
	}
	
	public RegistroDocenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.RegistroDocenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		classeId = new IntegerExpression("classe.ID", this.getDetachedCriteria());
		classe = new AssociationExpression("classe", this.getDetachedCriteria());
	}
	
	public ClasseDetachedCriteria createClasseCriteria() {
		return new ClasseDetachedCriteria(createCriteria("classe"));
	}
	
	public RegistroDocente uniqueRegistroDocente(PersistentSession session) {
		return (RegistroDocente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RegistroDocente[] listRegistroDocente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RegistroDocente[]) list.toArray(new RegistroDocente[list.size()]);
	}
}

