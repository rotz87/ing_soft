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

public class StudenteDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public StudenteDetachedCriteria() {
		super(domain.model.Studente.class, domain.model.StudenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_indirizzoId = new IntegerExpression("_indirizzo.ID", this.getDetachedCriteria());
		_indirizzo = new AssociationExpression("_indirizzo", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_cognome = new StringExpression("_cognome", this.getDetachedCriteria());
		_codiceFiscale = new StringExpression("_codiceFiscale", this.getDetachedCriteria());
		_dataNascita = new DateExpression("_dataNascita", this.getDetachedCriteria());
		_librettoVotiId = new IntegerExpression("_librettoVoti.ID", this.getDetachedCriteria());
		_librettoVoti = new AssociationExpression("_librettoVoti", this.getDetachedCriteria());
		_librettoAssenzeId = new IntegerExpression("_librettoAssenze.ID", this.getDetachedCriteria());
		_librettoAssenze = new AssociationExpression("_librettoAssenze", this.getDetachedCriteria());
	}
	
	public StudenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.StudenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_indirizzoId = new IntegerExpression("_indirizzo.ID", this.getDetachedCriteria());
		_indirizzo = new AssociationExpression("_indirizzo", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_cognome = new StringExpression("_cognome", this.getDetachedCriteria());
		_codiceFiscale = new StringExpression("_codiceFiscale", this.getDetachedCriteria());
		_dataNascita = new DateExpression("_dataNascita", this.getDetachedCriteria());
		_librettoVotiId = new IntegerExpression("_librettoVoti.ID", this.getDetachedCriteria());
		_librettoVoti = new AssociationExpression("_librettoVoti", this.getDetachedCriteria());
		_librettoAssenzeId = new IntegerExpression("_librettoAssenze.ID", this.getDetachedCriteria());
		_librettoAssenze = new AssociationExpression("_librettoAssenze", this.getDetachedCriteria());
	}
	
	public LibrettoVotiDetachedCriteria create_librettoVotiCriteria() {
		return new LibrettoVotiDetachedCriteria(createCriteria("_librettoVoti"));
	}
	
	public LibrettoAssenzeDetachedCriteria create_librettoAssenzeCriteria() {
		return new LibrettoAssenzeDetachedCriteria(createCriteria("_librettoAssenze"));
	}
	
	public IndirizzoDetachedCriteria create_indirizzoCriteria() {
		return new IndirizzoDetachedCriteria(createCriteria("_indirizzo"));
	}
	
	public Studente uniqueStudente(PersistentSession session) {
		return (Studente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Studente[] listStudente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Studente[]) list.toArray(new Studente[list.size()]);
	}
}

