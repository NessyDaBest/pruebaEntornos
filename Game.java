package classes;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {		//2. MOVE A PROGRAM (no es una clase)

		try {
			// De sistema
			Scanner s = new Scanner(System.in);

			// Generador de palabras
			Words w = new Words();

			// Stats
			int tries = 10;		// 13. EXTRACT CONSTANT (selec. número y lo convierte en una const) - deshacer - // 14. CONVERT LOCAL VARIABLE TO FIELD (convierte a propiedad)
			GameResult gameCondition = GameResult.CONTINUE;
			String word = w.getWord();

			// Comienzo del juego
			System.out.println("- EMPIEZA EL JUEGO -\n (letras sin tildes)");

			while (gameCondition == GameResult.CONTINUE) {

				System.out.println("Tienes: " + tries + " intentos");
				System.out.println(w.getDashed(word));

				String response = s.nextLine().toLowerCase();

				// Comprobar si el texto NO es una letra
				if (response.matches("\\W") || response.matches("\\d") /*15. EXTRACT METHOD*/) {
					System.out.println("Introduce UNA sola LETRA, por favor");
				} else {
					// Comprobar que el caracter introducido está en la palabra
					if (word.contains(response)) {
						// Anula el intento porque ha acertado
						tries++;
						// Registra como mayúscula la letra acertada
						word = w.pushLetter(word, response);		//12. EXTRACT LOCAL VARIABLE - deshacer
						System.out.println("|_ ACIERTO\n");

						// Comprueba win condition
						if (word.toUpperCase().equals(word)) {
							gameCondition = GameResult.WIN;
						} else if (tries <= 0) {
							gameCondition = GameResult.LOSE;
						}
					}
					// Cuenta el intento
					tries--;
				}
				System.out.println(gameCondition.message);
				System.out.println();
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
