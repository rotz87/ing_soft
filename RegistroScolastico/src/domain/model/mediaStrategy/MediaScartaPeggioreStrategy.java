package domain.model.mediaStrategy;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import sviluppo.Stampa;
import domain.model.Voto;

public class MediaScartaPeggioreStrategy implements IMediaStrategy {

	@Override
	public Voto calcolaMedia(Collection<Voto> voti) {
		
//		Stampa.stampaln("sono in scarta il peggiore! ");
		Voto min;
		Collection<Voto> votos = new LinkedList<Voto>();
		
//		Stampa.stampaln("size voti "+voti.size());
		votos.addAll(voti);
		if(votos.size()>1){
			min = Collections.min(votos);
			votos.remove(min);
		}
		
//		Stampa.stampaln("size votos "+votos.size());
		
		Voto rit;
		float acc = 0;
		int count = 0;
		float media;
		
		for(Voto voto: votos){
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
