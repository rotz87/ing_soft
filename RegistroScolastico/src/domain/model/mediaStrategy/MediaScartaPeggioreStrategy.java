package domain.model.mediaStrategy;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import domain.model.Voto;

public class MediaScartaPeggioreStrategy implements IMediaStrategy {

	@Override
	public Voto calcolaMedia(Collection<Voto> voti) {
		Voto min;
		Collection<Voto> votos;
		
		if(voti.size()>1){
			votos = new LinkedList<Voto>();
			votos.addAll(voti);
			min = Collections.min(votos);
			votos.remove(min);
		}
		
		Voto rit;
		float acc = 0;
		int count = 0;
		float media;
		
		for(Voto voto: voti){
			acc +=voto.getVoto();
			count++;
		}
		
		if(count != 0){
			media = acc / count;
		}else{
			media = -1;
		}
		rit = new Voto();//FIXME 
		rit.setVoto((byte)media);
		
		return rit;
	}
	

}
