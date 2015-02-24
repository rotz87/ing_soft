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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;

public class LibrettoAssenzeCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression studenteId;
	public final AssociationExpression studente;
	public final CollectionExpression giustificate;
	public final CollectionExpression nonGiustificate;
	public final CollectionExpression ritardi;
	public final CollectionExpression uscite;
	
	public LibrettoAssenzeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		studenteId = new IntegerExpression("studente.ID", this);
		studente = new AssociationExpression("studente", this);
		giustificate = new CollectionExpression("giustificate", this);
		nonGiustificate = new CollectionExpression("nonGiustificate", this);
		ritardi = new CollectionExpression("ritardi", this);
		uscite = new CollectionExpression("uscite", this);
	}
	
	public LibrettoAssenzeCriteria(PersistentSession session) {
		this(session.createCriteria(LibrettoAssenze.class));
	}
	
	public LibrettoAssenzeCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public StudenteCriteria createStudenteCriteria() {
		return new StudenteCriteria(createCriteria("studente"));
	}
	
	public AssenzaCriteria createGiustificateCriteria() {
		return new AssenzaCriteria(createCriteria("giustificate"));
	}
	
	public AssenzaCriteria createNonGiustificateCriteria() {
		return new AssenzaCriteria(createCriteria("nonGiustificate"));
	}
	
	public RitardoCriteria createRitardiCriteria() {
		return new RitardoCriteria(createCriteria("ritardi"));
	}
	
	public UscitaAnticipataCriteria createUsciteCriteria() {
		return new UscitaAnticipataCriteria(createCriteria("uscite"));
	}
	
	public LibrettoAssenze uniqueLibrettoAssenze() {
		return (LibrettoAssenze) super.uniqueResult();
	}
	
	public LibrettoAssenze[] listLibrettoAssenze() {
		java.util.List list = super.list();
		return (LibrettoAssenze[]) list.toArray(new LibrettoAssenze[list.size()]);
	}
}

