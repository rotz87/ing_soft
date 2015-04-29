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

public class PersonaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _indirizzoId;
	public final AssociationExpression _indirizzo;
	public final StringExpression _nome;
	public final StringExpression _cognome;
	public final StringExpression _codiceFiscale;
	public final DateExpression _dataNascita;
	
	public PersonaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_indirizzoId = new IntegerExpression("_indirizzo.ID", this);
		_indirizzo = new AssociationExpression("_indirizzo", this);
		_nome = new StringExpression("_nome", this);
		_cognome = new StringExpression("_cognome", this);
		_codiceFiscale = new StringExpression("_codiceFiscale", this);
		_dataNascita = new DateExpression("_dataNascita", this);
	}
	
	public PersonaCriteria(PersistentSession session) {
		this(session.createCriteria(Persona.class));
	}
	
	public PersonaCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public IndirizzoCriteria create_indirizzoCriteria() {
		return new IndirizzoCriteria(createCriteria("_indirizzo"));
	}
	
	public Persona uniquePersona() {
		return (Persona) super.uniqueResult();
	}
	
	public Persona[] listPersona() {
		java.util.List list = super.list();
		return (Persona[]) list.toArray(new Persona[list.size()]);
	}
}

