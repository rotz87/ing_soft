package presenter;

public class ApiPath {
	private static final String _CLASSI = "/classi";
	private static final String _ID_CLASSE = "/{idClasse}";
	private static final String _APPELLI = "/appelli";
	private static final String _ID_APPELLO = "/{idAppello}";
	private static final String _ASSENTI = "/assenti";
	private static final String _CALENDARIO = "/calendario";
	private static final String _STUDENTI = "/studenti";
	private static final String _DATE_FESTIVE = "/dateFestive";
	private static final String _REGISTRI_DOCENTE = "/registriDocente";
	private static final String _ID_REGISTRO_DOCENTE ="/{idRegistroDocente}";
	private static final String _COMPITI = "/compiti";
	private static final String _ID_COMPITO_IN_CLASSE = "/{idCompitoInClasse}";
	private static final String _STATE = "/state";
	private static final String _ARGOMENTI_SVOLTI = "/argomentiSvolti";
	private static final String _MEDIE = "/medie";
	private static final String _STRATEGIE = "/strategie";
	private static final String _FORMATO_VOTI = "/formatoVoti";
	private static final String _VOTI = "/voti";
	private static final String _VOTI_CONVERTERS = "/votiConverters";
	private static final String _VOTI_CONVERTER_ATTUALE = "/attuale";
	

	public static final String  CLASSE_APPELLI = _CLASSI+_ID_CLASSE+_APPELLI;
	public static final String  ID_APPELLO = _ID_APPELLO;
	public static final String  APPELLO_ASSENTI =_ID_APPELLO+_ASSENTI;
	public static final String  CALENDARIO = _CALENDARIO;
	public static final String CLASSI = _CLASSI;
	public static final String CLASSE_STUDENTI = _ID_CLASSE+_STUDENTI;
	public static final String CLASSE_FESTIVI = _ID_CLASSE+_DATE_FESTIVE;
	public static final String CLASSE_REGISTRI_DOCENTE = _ID_CLASSE+_REGISTRI_DOCENTE;
	public static final String REGISTRO_DOCENTE_COMPITI = _CLASSI+_ID_CLASSE+_REGISTRI_DOCENTE+_ID_REGISTRO_DOCENTE+_COMPITI;
	public static final String ID_COMPITO = _ID_COMPITO_IN_CLASSE;
	public static final String COMPITO_STATE = _ID_COMPITO_IN_CLASSE+_STATE;
	public static final String COMPITO_STUDENTI = _ID_COMPITO_IN_CLASSE+_STUDENTI;
	public static final String REGISTRO_DOCENTE = _CLASSI+_ID_CLASSE+_REGISTRI_DOCENTE+_ID_REGISTRO_DOCENTE;
	public static final String ARGOMENTI_SVOLTI = _ARGOMENTI_SVOLTI;
	public static final String MEDIE = _MEDIE ;
	public static final String STRATEGIE = _MEDIE+_STRATEGIE;
	public static final String FORMATO_VOTI = _FORMATO_VOTI;
	public static final String VOTI = _VOTI;
	public static final String VOTI_CONVERTERS = _VOTI_CONVERTERS;
	public static final  String VOTI_CONVERTER_ATTUALE = _VOTI_CONVERTERS + _VOTI_CONVERTER_ATTUALE;
	
	
	
	
	
	
	
	
	
}
