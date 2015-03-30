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

public class ClasseDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _registroAssenzeId;
	public final AssociationExpression _registroAssenze;
	public final StringExpression _nome;
	public final CollectionExpression _studenti;
	
	public ClasseDetachedCriteria() {
		super(domain.model.Classe.class, domain.model.ClasseCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_registroAssenzeId = new IntegerExpression("_registroAssenze.ID", this.getDetachedCriteria());
		_registroAssenze = new AssociationExpression("_registroAssenze", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_studenti = new CollectionExpression("_studenti", this.getDetachedCriteria());
	}
	
	public ClasseDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.ClasseCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_registroAssenzeId = new IntegerExpression("_registroAssenze.ID", this.getDetachedCriteria());
		_registroAssenze = new AssociationExpression("_registroAssenze", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_studenti = new CollectionExpression("_studenti", this.getDetachedCriteria());
	}
	
	public RegistroAssenzeDetachedCriteria create_registroAssenzeCriteria() {
		return new RegistroAssenzeDetachedCriteria(createCriteria("_registroAssenze"));
	}
	
	public StudenteDetachedCriteria create_studentiCriteria() {
		return new StudenteDetachedCriteria(createCriteria("_studenti"));
	}
	
	public Classe uniqueClasse(PersistentSession session) {
		return (Classe) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Classe[] listClasse(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Classe[]) list.toArray(new Classe[list.size()]);
	}
}

