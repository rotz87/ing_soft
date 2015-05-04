package domain.model.mediaStrategy;

import java.util.Collection;

import domain.model.Voto;

public class MediaAritmeticaStrategy implements IMediaStrategy{

	@Override
	public Voto calcolaMedia(Collection<Voto> voti) {
		Voto rit;
		float acc = 0;
		int count = 0;
		float media;
		
		for(Voto voto: voti){
			acc +=voto.getValore();
			count++;
		}
		
		if(count != 0){
			media = acc / count;
		}else{
			media = -1;
		}
		rit = new Voto(); 
		rit.setValore(media);
		
		return rit;
	}

}
