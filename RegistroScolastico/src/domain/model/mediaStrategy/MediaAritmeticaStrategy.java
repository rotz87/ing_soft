package domain.model.mediaStrategy;

import java.util.Collection;

import domain.model.Voto;

public class MediaAritmeticaStrategy implements IMediaStrategy{

	@Override
	public Voto calcolaMedia(Collection<Voto> voti) {
		Voto rit;
		float acc = 0;
		int count = 0;
		Float media;
		
		for(Voto voto: voti){
			acc +=voto.getValore();
			count++;
		}
		
		if(count != 0){
			media = acc / count;
		}else{
//			media = null;
			media = null;
		}
		rit = new Voto(); 
		rit.setValore(media);
		
		return rit;
	}

}
