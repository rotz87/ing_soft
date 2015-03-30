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
import org.orm.criteria.*;

public class LibrettoAssenzeCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression _giustificate;
	public final CollectionExpression _nonGiustificate;
	public final CollectionExpression _ritardi;
	public final CollectionExpression _uscite;
	
	public LibrettoAssenzeCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_giustificate = new CollectionExpression("_giustificate", this);
		_nonGiustificate = new CollectionExpression("_nonGiustificate", this);
		_ritardi = new CollectionExpression("_ritardi", this);
		_uscite = new CollectionExpression("_uscite", this);
	}
	
	public LibrettoAssenzeCriteria(PersistentSession session) {
		this(session.createCriteria(LibrettoAssenze.class));
	}
	
	public LibrettoAssenzeCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public AssenzaCriteria create_giustificateCriteria() {
		return new AssenzaCriteria(createCriteria("_giustificate"));
	}
	
	public AssenzaCriteria create_nonGiustificateCriteria() {
		return new AssenzaCriteria(createCriteria("_nonGiustificate"));
	}
	
	public RitardoCriteria create_ritardiCriteria() {
		return new RitardoCriteria(createCriteria("_ritardi"));
	}
	
	public UscitaAnticipataCriteria create_usciteCriteria() {
		return new UscitaAnticipataCriteria(createCriteria("_uscite"));
	}
	
	public LibrettoAssenze uniqueLibrettoAssenze() {
		return (LibrettoAssenze) super.uniqueResult();
	}
	
	public LibrettoAssenze[] listLibrettoAssenze() {
		java.util.List list = super.list();
		return (LibrettoAssenze[]) list.toArray(new LibrettoAssenze[list.size()]);
	}
}

