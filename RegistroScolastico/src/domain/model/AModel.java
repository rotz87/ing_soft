package domain.model;

import domain.persistent.IPersistentModel;

public abstract class AModel <T extends IPersistentModel>{
	
	protected T persistentModel;
	
	public AModel(){
		
	}
	public AModel(T pModel){
		setPersistentModel(pModel);
	}
	
	public T getPersistentModel(){
		return this.persistentModel;
	}
	
	public void setPersistentModel(T pModel){
		this.persistentModel = pModel;
	}

}
