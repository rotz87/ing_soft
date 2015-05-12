package sviluppo;

import domain.model.Argomento;
import domain.model.compitoInClasse.CompitoInClasse;

public class Stampa {
	public static void stampaln(String stringa){
		System.out.println(stringa);
	}
	public static void stampaln(Object object){
		System.out.println(object);
	}
	public static void stampaln(){
		System.out.println();
	}
	public static void stampa(String stringa){
		System.out.print(stringa);
	}
	public static void stampa(Object object){
		System.out.print(object);
	}
	public static void stampaArgomenti(CompitoInClasse compito){
		stampaln();
		stampaln("Argomenti compito");
		for(Argomento arg : compito.getArgomentiEsaminati()){
			Stampa.stampaln("Argomento: "+ arg.getID() + ", nome: " + arg.getNome() + ", descrizione: "+arg.getDescrizione()+".");
		}
		stampaln();
	}

}
