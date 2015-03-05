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

public class UscitaAnticipataDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression appelloId;
	public final AssociationExpression appello;
	public final IntegerExpression permessoId;
	public final AssociationExpression permesso;
	
	public UscitaAnticipataDetachedCriteria() {
		super(domain.model.UscitaAnticipata.class, domain.model.UscitaAnticipataCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		appelloId = new IntegerExpression("appello.ID", this.getDetachedCriteria());
		appello = new AssociationExpression("appello", this.getDetachedCriteria());
		permessoId = new IntegerExpression("permesso.ID", this.getDetachedCriteria());
		permesso = new AssociationExpression("permesso", this.getDetachedCriteria());
	}
	
	public UscitaAnticipataDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.UscitaAnticipataCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		appelloId = new IntegerExpression("appello.ID", this.getDetachedCriteria());
		appello = new AssociationExpression("appello", this.getDetachedCriteria());
		permessoId = new IntegerExpression("permesso.ID", this.getDetachedCriteria());
		permesso = new AssociationExpression("permesso", this.getDetachedCriteria());
	}
	
	public AppelloDetachedCriteria createAppelloCriteria() {
		return new AppelloDetachedCriteria(createCriteria("appello"));
	}
	
	public PermessoUscitaDetachedCriteria createPermessoCriteria() {
		return new PermessoUscitaDetachedCriteria(createCriteria("permesso"));
	}
	
	public UscitaAnticipata uniqueUscitaAnticipata(PersistentSession session) {
		return (UscitaAnticipata) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public UscitaAnticipata[] listUscitaAnticipata(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (UscitaAnticipata[]) list.toArray(new UscitaAnticipata[list.size()]);
	}
}

