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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class StudenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression id;
	public final IntegerExpression indrizzoId;
	public final AssociationExpression indrizzo;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression codiceFiscale;
	
	public StudenteDetachedCriteria() {
		super(domain.persistent.Studente.class, domain.persistent.StudenteCriteria.class);
		id = new LongExpression("id", this.getDetachedCriteria());
		indrizzoId = new IntegerExpression("indrizzo.ID", this.getDetachedCriteria());
		indrizzo = new AssociationExpression("indrizzo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
	}
	
	public StudenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.persistent.StudenteCriteria.class);
		id = new LongExpression("id", this.getDetachedCriteria());
		indrizzoId = new IntegerExpression("indrizzo.ID", this.getDetachedCriteria());
		indrizzo = new AssociationExpression("indrizzo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
	}
	
	public IndirizzoDetachedCriteria createIndrizzoCriteria() {
		return new IndirizzoDetachedCriteria(createCriteria("indrizzo"));
	}
	
	public Studente uniqueStudente(PersistentSession session) {
		return (Studente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Studente[] listStudente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Studente[]) list.toArray(new Studente[list.size()]);
	}
}

