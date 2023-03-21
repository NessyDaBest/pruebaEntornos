package classes;

public enum GameResult {
	WIN("HAS GANADO!!!"), LOSE("HAS PERDIDO..."), CONTINUE("ÁNIMO");
	
	public final String message;		//16. ENCAPSULATE FIELD - deshacer
	
	private GameResult(String m) {
		message = m;
	}
}
