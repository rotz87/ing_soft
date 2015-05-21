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

public class RegistroDocenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _materiaId;
	public final AssociationExpression _materia;
	public final IntegerExpression _classeId;
	public final AssociationExpression _classe;
	public final CollectionExpression _compitiInClasse;
	public final CollectionExpression _argomentiSvolti;
	
	public RegistroDocenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_materiaId = new IntegerExpression("_materia.ID", this);
		_materia = new AssociationExpression("_materia", this);
		_classeId = new IntegerExpression("_classe.ID", this);
		_classe = new AssociationExpression("_classe", this);
		_compitiInClasse = new CollectionExpression("_compitiInClasse", this);
		_argomentiSvolti = new CollectionExpression("_argomentiSvolti", this);
	}
	
	public RegistroDocenteCriteria(PersistentSession session) {
		this(session.createCriteria(RegistroDocente.class));
	}
	
	public RegistroDocenteCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public MateriaCriteria create_materiaCriteria() {
		return new MateriaCriteria(createCriteria("_materia"));
	}
	
	public ClasseCriteria create_classeCriteria() {
		return new ClasseCriteria(createCriteria("_classe"));
	}
	
	public domain.model.compitoInClasse.CompitoInClasseCriteria create_compitiInClasseCriteria() {
		return new domain.model.compitoInClasse.CompitoInClasseCriteria(createCriteria("_compitiInClasse"));
	}
	
	public ArgomentoCriteria create_argomentiSvoltiCriteria() {
		return new ArgomentoCriteria(createCriteria("_argomentiSvolti"));
	}
	
	public RegistroDocente uniqueRegistroDocente() {
		return (RegistroDocente) super.uniqueResult();
	}
	
	public RegistroDocente[] listRegistroDocente() {
		java.util.List list = super.list();
		return (RegistroDocente[]) list.toArray(new RegistroDocente[list.size()]);
	}
}

