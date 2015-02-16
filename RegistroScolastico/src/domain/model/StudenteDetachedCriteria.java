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
	public final IntegerExpression id;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression codiceFiscale;
	public final IntegerExpression indrizzo;
	
	public StudenteDetachedCriteria() {
		super(domain.model.Studente.class, domain.model.StudenteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		indrizzo = new IntegerExpression("indrizzo", this.getDetachedCriteria());
	}
	
	public StudenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.StudenteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		indrizzo = new IntegerExpression("indrizzo", this.getDetachedCriteria());
	}
	
	public Studente uniqueStudente(PersistentSession session) {
		return (Studente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Studente[] listStudente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Studente[]) list.toArray(new Studente[list.size()]);
	}
}

