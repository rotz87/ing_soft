package service;

public class FactoryHandler {
	
	static private FactoryHandler instance;
	
	private RegistroAssenzeFactory registroAssenzeFactory;


	private FactoryHandler(){
		
		this.registroAssenzeFactory = TestRegistroAssenzeFactory.getInstance();
		
	}

	static public FactoryHandler getInstance() {
		if (FactoryHandler.instance == null) {
			FactoryHandler.instance = new FactoryHandler();
		}
		return FactoryHandler.instance;
	}

	public RegistroAssenzeFactory getRegistroAssenzeFactory() {
		return registroAssenzeFactory;
	}
	
}
