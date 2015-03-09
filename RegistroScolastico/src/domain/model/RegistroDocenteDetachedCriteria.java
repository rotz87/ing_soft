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

public class RegistroDocenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression materiaId;
	public final AssociationExpression materia;
	public final IntegerExpression classeId;
	public final AssociationExpression classe;
	public final CollectionExpression compitiInClasse;
	public final CollectionExpression argomentiSvolti;
	
	public RegistroDocenteDetachedCriteria() {
		super(domain.model.RegistroDocente.class, domain.model.RegistroDocenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		materiaId = new IntegerExpression("materia.ID", this.getDetachedCriteria());
		materia = new AssociationExpression("materia", this.getDetachedCriteria());
		classeId = new IntegerExpression("classe.ID", this.getDetachedCriteria());
		classe = new AssociationExpression("classe", this.getDetachedCriteria());
		compitiInClasse = new CollectionExpression("compitiInClasse", this.getDetachedCriteria());
		argomentiSvolti = new CollectionExpression("argomentiSvolti", this.getDetachedCriteria());
	}
	
	public RegistroDocenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.RegistroDocenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		materiaId = new IntegerExpression("materia.ID", this.getDetachedCriteria());
		materia = new AssociationExpression("materia", this.getDetachedCriteria());
		classeId = new IntegerExpression("classe.ID", this.getDetachedCriteria());
		classe = new AssociationExpression("classe", this.getDetachedCriteria());
		compitiInClasse = new CollectionExpression("compitiInClasse", this.getDetachedCriteria());
		argomentiSvolti = new CollectionExpression("argomentiSvolti", this.getDetachedCriteria());
	}
	
	public MateriaDetachedCriteria createMateriaCriteria() {
		return new MateriaDetachedCriteria(createCriteria("materia"));
	}
	
	public ClasseDetachedCriteria createClasseCriteria() {
		return new ClasseDetachedCriteria(createCriteria("classe"));
	}
	
	public CompitoInClasseDetachedCriteria createCompitiInClasseCriteria() {
		return new CompitoInClasseDetachedCriteria(createCriteria("compitiInClasse"));
	}
	
	public ArgomentoDetachedCriteria createArgomentiSvoltiCriteria() {
		return new ArgomentoDetachedCriteria(createCriteria("argomentiSvolti"));
	}
	
	public RegistroDocente uniqueRegistroDocente(PersistentSession session) {
		return (RegistroDocente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RegistroDocente[] listRegistroDocente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RegistroDocente[]) list.toArray(new RegistroDocente[list.size()]);
	}
}

