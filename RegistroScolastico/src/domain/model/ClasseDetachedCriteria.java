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
	public final IntegerExpression idClasse;
	public final IntegerExpression registroAssenzeId;
	public final AssociationExpression registroAssenze;
	public final StringExpression nome;
	
	public ClasseDetachedCriteria() {
		super(domain.model.Classe.class, domain.model.ClasseCriteria.class);
		idClasse = new IntegerExpression("idClasse", this.getDetachedCriteria());
		registroAssenzeId = new IntegerExpression("registroAssenze.ID", this.getDetachedCriteria());
		registroAssenze = new AssociationExpression("registroAssenze", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public ClasseDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.ClasseCriteria.class);
		idClasse = new IntegerExpression("idClasse", this.getDetachedCriteria());
		registroAssenzeId = new IntegerExpression("registroAssenze.ID", this.getDetachedCriteria());
		registroAssenze = new AssociationExpression("registroAssenze", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public RegistroAssenzeDetachedCriteria createRegistroAssenzeCriteria() {
		return new RegistroAssenzeDetachedCriteria(createCriteria("registroAssenze"));
	}
	
	public Classe uniqueClasse(PersistentSession session) {
		return (Classe) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Classe[] listClasse(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Classe[]) list.toArray(new Classe[list.size()]);
	}
}

