package domain.model.mediaStrategy;

public class MediaStrategyFactory {
	static private MediaStrategyFactory instance;

	private MediaStrategyFactory() {
	}

	static public MediaStrategyFactory getInstance() {
		if (MediaStrategyFactory.instance == null) {
			MediaStrategyFactory.instance = new MediaStrategyFactory();
		}
		return MediaStrategyFactory.instance;
	}
	public IMediaStrategy create(String strategia){
		return new MediaAritmeticaStrategy();
	}
}