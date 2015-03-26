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
	public final IntegerExpression _materiaId;
	public final AssociationExpression _materia;
	public final IntegerExpression _classeId;
	public final AssociationExpression _classe;
	public final CollectionExpression _compitiInClasse;
	public final CollectionExpression _argomentiSvolti;
	
	public RegistroDocenteDetachedCriteria() {
		super(domain.model.RegistroDocente.class, domain.model.RegistroDocenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_materiaId = new IntegerExpression("_materia.ID", this.getDetachedCriteria());
		_materia = new AssociationExpression("_materia", this.getDetachedCriteria());
		_classeId = new IntegerExpression("_classe.ID", this.getDetachedCriteria());
		_classe = new AssociationExpression("_classe", this.getDetachedCriteria());
		_compitiInClasse = new CollectionExpression("_compitiInClasse", this.getDetachedCriteria());
		_argomentiSvolti = new CollectionExpression("_argomentiSvolti", this.getDetachedCriteria());
	}
	
	public RegistroDocenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.RegistroDocenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_materiaId = new IntegerExpression("_materia.ID", this.getDetachedCriteria());
		_materia = new AssociationExpression("_materia", this.getDetachedCriteria());
		_classeId = new IntegerExpression("_classe.ID", this.getDetachedCriteria());
		_classe = new AssociationExpression("_classe", this.getDetachedCriteria());
		_compitiInClasse = new CollectionExpression("_compitiInClasse", this.getDetachedCriteria());
		_argomentiSvolti = new CollectionExpression("_argomentiSvolti", this.getDetachedCriteria());
	}
	
	public MateriaDetachedCriteria create_materiaCriteria() {
		return new MateriaDetachedCriteria(createCriteria("_materia"));
	}
	
	public ClasseDetachedCriteria create_classeCriteria() {
		return new ClasseDetachedCriteria(createCriteria("_classe"));
	}
	
	public domain.model.compitoInClasse.CompitoInClasseDetachedCriteria create_compitiInClasseCriteria() {
		return new domain.model.compitoInClasse.CompitoInClasseDetachedCriteria(createCriteria("_compitiInClasse"));
	}
	
	public ArgomentoDetachedCriteria create_argomentiSvoltiCriteria() {
		return new ArgomentoDetachedCriteria(createCriteria("_argomentiSvolti"));
	}
	
	public RegistroDocente uniqueRegistroDocente(PersistentSession session) {
		return (RegistroDocente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RegistroDocente[] listRegistroDocente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RegistroDocente[]) list.toArray(new RegistroDocente[list.size()]);
	}
}

