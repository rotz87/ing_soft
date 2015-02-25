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
	public final IntegerExpression permessoEntrataId;
	public final AssociationExpression permessoEntrata;
	public final IntegerExpression appelloId;
	public final AssociationExpression appello;
	
	public RitardoDetachedCriteria() {
		super(domain.model.Ritardo.class, domain.model.RitardoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permessoEntrataId = new IntegerExpression("permessoEntrata.ID", this.getDetachedCriteria());
		permessoEntrata = new AssociationExpression("permessoEntrata", this.getDetachedCriteria());
		appelloId = new IntegerExpression("appello.ID", this.getDetachedCriteria());
		appello = new AssociationExpression("appello", this.getDetachedCriteria());
	}
	
	public RitardoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.RitardoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permessoEntrataId = new IntegerExpression("permessoEntrata.ID", this.getDetachedCriteria());
		permessoEntrata = new AssociationExpression("permessoEntrata", this.getDetachedCriteria());
		appelloId = new IntegerExpression("appello.ID", this.getDetachedCriteria());
		appello = new AssociationExpression("appello", this.getDetachedCriteria());
	}
	
	public PermessoEntrataDetachedCriteria createPermessoEntrataCriteria() {
		return new PermessoEntrataDetachedCriteria(createCriteria("permessoEntrata"));
	}
	
	public AppelloDetachedCriteria createAppelloCriteria() {
		return new AppelloDetachedCriteria(createCriteria("appello"));
	}
	
	public Ritardo uniqueRitardo(PersistentSession session) {
		return (Ritardo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ritardo[] listRitardo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ritardo[]) list.toArray(new Ritardo[list.size()]);
	}
}

