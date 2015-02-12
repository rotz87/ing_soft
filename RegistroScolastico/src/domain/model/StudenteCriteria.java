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

public class StudenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression codiceFiscale;
	public final IntegerExpression indrizzo;
	
	public StudenteCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nome = new StringExpression("nome", this);
		cognome = new StringExpression("cognome", this);
		codiceFiscale = new StringExpression("codiceFiscale", this);
		indrizzo = new IntegerExpression("indrizzo", this);
	}
	
	public StudenteCriteria(PersistentSession session) {
		this(session.createCriteria(Studente.class));
	}
	
	public StudenteCriteria() throws PersistentException {
		this(domain.model.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public Studente uniqueStudente() {
		return (Studente) super.uniqueResult();
	}
	
	public Studente[] listStudente() {
		java.util.List list = super.list();
		return (Studente[]) list.toArray(new Studente[list.size()]);
	}
}

