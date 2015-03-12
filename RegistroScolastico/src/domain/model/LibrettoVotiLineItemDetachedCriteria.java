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

public class LibrettoVotiLineItemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression votoId;
	public final AssociationExpression voto;
	public final IntegerExpression compitoInClasseId;
	public final AssociationExpression compitoInClasse;
	
	public LibrettoVotiLineItemDetachedCriteria() {
		super(domain.model.LibrettoVotiLineItem.class, domain.model.LibrettoVotiLineItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		votoId = new IntegerExpression("voto.ID", this.getDetachedCriteria());
		voto = new AssociationExpression("voto", this.getDetachedCriteria());
		compitoInClasseId = new IntegerExpression("compitoInClasse.ID", this.getDetachedCriteria());
		compitoInClasse = new AssociationExpression("compitoInClasse", this.getDetachedCriteria());
	}
	
	public LibrettoVotiLineItemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.LibrettoVotiLineItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		votoId = new IntegerExpression("voto.ID", this.getDetachedCriteria());
		voto = new AssociationExpression("voto", this.getDetachedCriteria());
		compitoInClasseId = new IntegerExpression("compitoInClasse.ID", this.getDetachedCriteria());
		compitoInClasse = new AssociationExpression("compitoInClasse", this.getDetachedCriteria());
	}
	
	public VotoDetachedCriteria createVotoCriteria() {
		return new VotoDetachedCriteria(createCriteria("voto"));
	}
	
	public CompitoInClasseDetachedCriteria createCompitoInClasseCriteria() {
		return new CompitoInClasseDetachedCriteria(createCriteria("compitoInClasse"));
	}
	
	public LibrettoVotiLineItem uniqueLibrettoVotiLineItem(PersistentSession session) {
		return (LibrettoVotiLineItem) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public LibrettoVotiLineItem[] listLibrettoVotiLineItem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (LibrettoVotiLineItem[]) list.toArray(new LibrettoVotiLineItem[list.size()]);
	}
}

