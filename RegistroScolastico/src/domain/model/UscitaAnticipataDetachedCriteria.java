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
	public final IntegerExpression _appelloId;
	public final AssociationExpression _appello;
	public final IntegerExpression _permessoId;
	public final AssociationExpression _permesso;
	
	public UscitaAnticipataDetachedCriteria() {
		super(domain.model.UscitaAnticipata.class, domain.model.UscitaAnticipataCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_appelloId = new IntegerExpression("_appello.ID", this.getDetachedCriteria());
		_appello = new AssociationExpression("_appello", this.getDetachedCriteria());
		_permessoId = new IntegerExpression("_permesso.ID", this.getDetachedCriteria());
		_permesso = new AssociationExpression("_permesso", this.getDetachedCriteria());
	}
	
	public UscitaAnticipataDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.UscitaAnticipataCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_appelloId = new IntegerExpression("_appello.ID", this.getDetachedCriteria());
		_appello = new AssociationExpression("_appello", this.getDetachedCriteria());
		_permessoId = new IntegerExpression("_permesso.ID", this.getDetachedCriteria());
		_permesso = new AssociationExpression("_permesso", this.getDetachedCriteria());
	}
	
	public AppelloDetachedCriteria create_appelloCriteria() {
		return new AppelloDetachedCriteria(createCriteria("_appello"));
	}
	
	public PermessoUscitaDetachedCriteria create_permessoCriteria() {
		return new PermessoUscitaDetachedCriteria(createCriteria("_permesso"));
	}
	
	public UscitaAnticipata uniqueUscitaAnticipata(PersistentSession session) {
		return (UscitaAnticipata) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public UscitaAnticipata[] listUscitaAnticipata(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (UscitaAnticipata[]) list.toArray(new UscitaAnticipata[list.size()]);
	}
}

