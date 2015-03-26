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
	public final IntegerExpression ID;
	public final IntegerExpression _indirizzoId;
	public final AssociationExpression _indirizzo;
	public final StringExpression _nome;
	public final StringExpression _cognome;
	public final StringExpression _codiceFiscale;
	public final DateExpression _dataNascita;
	public final IntegerExpression _librettoVotiId;
	public final AssociationExpression _librettoVoti;
	public final IntegerExpression _librettoAssenzeId;
	public final AssociationExpression _librettoAssenze;
	
	public StudenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_indirizzoId = new IntegerExpression("_indirizzo.ID", this);
		_indirizzo = new AssociationExpression("_indirizzo", this);
		_nome = new StringExpression("_nome", this);
		_cognome = new StringExpression("_cognome", this);
		_codiceFiscale = new StringExpression("_codiceFiscale", this);
		_dataNascita = new DateExpression("_dataNascita", this);
		_librettoVotiId = new IntegerExpression("_librettoVoti.ID", this);
		_librettoVoti = new AssociationExpression("_librettoVoti", this);
		_librettoAssenzeId = new IntegerExpression("_librettoAssenze.ID", this);
		_librettoAssenze = new AssociationExpression("_librettoAssenze", this);
	}
	
	public StudenteCriteria(PersistentSession session) {
		this(session.createCriteria(Studente.class));
	}
	
	public StudenteCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public LibrettoVotiCriteria create_librettoVotiCriteria() {
		return new LibrettoVotiCriteria(createCriteria("_librettoVoti"));
	}
	
	public LibrettoAssenzeCriteria create_librettoAssenzeCriteria() {
		return new LibrettoAssenzeCriteria(createCriteria("_librettoAssenze"));
	}
	
	public IndirizzoCriteria create_indirizzoCriteria() {
		return new IndirizzoCriteria(createCriteria("_indirizzo"));
	}
	
	public Studente uniqueStudente() {
		return (Studente) super.uniqueResult();
	}
	
	public Studente[] listStudente() {
		java.util.List list = super.list();
		return (Studente[]) list.toArray(new Studente[list.size()]);
	}
}

