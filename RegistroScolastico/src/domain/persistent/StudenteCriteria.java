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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class StudenteCriteria extends AbstractORMCriteria {
	public final LongExpression id;
	public final IntegerExpression indrizzoId;
	public final AssociationExpression indrizzo;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression codiceFiscale;
	
	public StudenteCriteria(Criteria criteria) {
		super(criteria);
		id = new LongExpression("id", this);
		indrizzoId = new IntegerExpression("indrizzo.ID", this);
		indrizzo = new AssociationExpression("indrizzo", this);
		nome = new StringExpression("nome", this);
		cognome = new StringExpression("cognome", this);
		codiceFiscale = new StringExpression("codiceFiscale", this);
	}
	
	public StudenteCriteria(PersistentSession session) {
		this(session.createCriteria(Studente.class));
	}
	
	public StudenteCriteria() throws PersistentException {
		this(domain.persistent.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public IndirizzoCriteria createIndrizzoCriteria() {
		return new IndirizzoCriteria(createCriteria("indrizzo"));
	}
	
	public Studente uniqueStudente() {
		return (Studente) super.uniqueResult();
	}
	
	public Studente[] listStudente() {
		java.util.List list = super.list();
		return (Studente[]) list.toArray(new Studente[list.size()]);
	}
}

