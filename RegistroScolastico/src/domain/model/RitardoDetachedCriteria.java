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

public class RitardoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _permessoId;
	public final AssociationExpression _permesso;
	public final IntegerExpression _appelloId;
	public final AssociationExpression _appello;
	
	public RitardoDetachedCriteria() {
		super(domain.model.Ritardo.class, domain.model.RitardoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_permessoId = new IntegerExpression("_permesso.ID", this.getDetachedCriteria());
		_permesso = new AssociationExpression("_permesso", this.getDetachedCriteria());
		_appelloId = new IntegerExpression("_appello.ID", this.getDetachedCriteria());
		_appello = new AssociationExpression("_appello", this.getDetachedCriteria());
	}
	
	public RitardoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.RitardoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_permessoId = new IntegerExpression("_permesso.ID", this.getDetachedCriteria());
		_permesso = new AssociationExpression("_permesso", this.getDetachedCriteria());
		_appelloId = new IntegerExpression("_appello.ID", this.getDetachedCriteria());
		_appello = new AssociationExpression("_appello", this.getDetachedCriteria());
	}
	
	public PermessoEntrataDetachedCriteria create_permessoCriteria() {
		return new PermessoEntrataDetachedCriteria(createCriteria("_permesso"));
	}
	
	public AppelloDetachedCriteria create_appelloCriteria() {
		return new AppelloDetachedCriteria(createCriteria("_appello"));
	}
	
	public Ritardo uniqueRitardo(PersistentSession session) {
		return (Ritardo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ritardo[] listRitardo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ritardo[]) list.toArray(new Ritardo[list.size()]);
	}
}

