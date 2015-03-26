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

public class ScuolaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression _nome;
	public final CollectionExpression _classi;
	public final CollectionExpression _docenti;
	
	public ScuolaDetachedCriteria() {
		super(domain.model.Scuola.class, domain.model.ScuolaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_classi = new CollectionExpression("_classi", this.getDetachedCriteria());
		_docenti = new CollectionExpression("_docenti", this.getDetachedCriteria());
	}
	
	public ScuolaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.ScuolaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_classi = new CollectionExpression("_classi", this.getDetachedCriteria());
		_docenti = new CollectionExpression("_docenti", this.getDetachedCriteria());
	}
	
	public ClasseDetachedCriteria create_classiCriteria() {
		return new ClasseDetachedCriteria(createCriteria("_classi"));
	}
	
	public DocenteDetachedCriteria create_docentiCriteria() {
		return new DocenteDetachedCriteria(createCriteria("_docenti"));
	}
	
	public Scuola uniqueScuola(PersistentSession session) {
		return (Scuola) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Scuola[] listScuola(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Scuola[]) list.toArray(new Scuola[list.size()]);
	}
}

