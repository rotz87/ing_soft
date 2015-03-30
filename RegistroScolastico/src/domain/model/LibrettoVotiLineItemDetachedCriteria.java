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
	public final IntegerExpression _votoId;
	public final AssociationExpression _voto;
	public final IntegerExpression _compitoInClasseId;
	public final AssociationExpression _compitoInClasse;
	
	public LibrettoVotiLineItemDetachedCriteria() {
		super(domain.model.LibrettoVotiLineItem.class, domain.model.LibrettoVotiLineItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_votoId = new IntegerExpression("_voto.ID", this.getDetachedCriteria());
		_voto = new AssociationExpression("_voto", this.getDetachedCriteria());
		_compitoInClasseId = new IntegerExpression("_compitoInClasse.ID", this.getDetachedCriteria());
		_compitoInClasse = new AssociationExpression("_compitoInClasse", this.getDetachedCriteria());
	}
	
	public LibrettoVotiLineItemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.LibrettoVotiLineItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_votoId = new IntegerExpression("_voto.ID", this.getDetachedCriteria());
		_voto = new AssociationExpression("_voto", this.getDetachedCriteria());
		_compitoInClasseId = new IntegerExpression("_compitoInClasse.ID", this.getDetachedCriteria());
		_compitoInClasse = new AssociationExpression("_compitoInClasse", this.getDetachedCriteria());
	}
	
	public VotoDetachedCriteria create_votoCriteria() {
		return new VotoDetachedCriteria(createCriteria("_voto"));
	}
	
	public domain.model.compitoInClasse.CompitoInClasseDetachedCriteria create_compitoInClasseCriteria() {
		return new domain.model.compitoInClasse.CompitoInClasseDetachedCriteria(createCriteria("_compitoInClasse"));
	}
	
	public LibrettoVotiLineItem uniqueLibrettoVotiLineItem(PersistentSession session) {
		return (LibrettoVotiLineItem) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public LibrettoVotiLineItem[] listLibrettoVotiLineItem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (LibrettoVotiLineItem[]) list.toArray(new LibrettoVotiLineItem[list.size()]);
	}
}

