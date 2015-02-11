package domain.implementor;

import java.util.List;
/**
 * @deprecated
 * @author Fabio
 *
 */
public class ScuolaImp {

	private List<ClasseImp> classi;
	private List<DocenteImp> docenti;
	
	public ScuolaImp() {

	}
	
	/**Per le prove
	 * 
	 */
	public void setClassi( List<ClasseImp> classi){
		this.classi = classi;
	}
	
	/**Per le prove
	 * 
	 */
	public void setDocenti(List<DocenteImp> docenti){
		this.docenti = docenti;
	}
	

}