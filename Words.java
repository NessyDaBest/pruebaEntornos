package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Words {		//4. EXTRACT SUPERCLASS (para poder implementar las palabras de diferentes tipos), revisar la implementación de la interfaz + renombrar la ahora subclase a numberWords (cadenas de números, crear numbers.txt y sobreescribir el constructor para que use el otro archivo de texto) + 5. USE SUPERTYPE WHERE POSSIBLE. 6. y 7. HACER PULL DOWN Y PULL UP CON ESTE ATRIBUTO
	
	private BufferedReader words;	//8. EXTRACT CLASS, AUNQUE NO SEA VIABLE, PARA VISUALIZARLO - deshacer
	
	public Words() throws FileNotFoundException {
		words = new BufferedReader(new FileReader(new File("./src/files/words.txt")));	//1. RENAME A BufferedWords
	}
	
	public String getWord() {
		String word = "";
		try {
			String[] array = words.readLine().split(";");
			word = array[new Random().nextInt(0, array.length-1)];
		} catch (IOException e) {
			System.out.println(e);
		}
		return word.toLowerCase();
	}

	//9. CHANGE METHOD SIGNATURE - deshacer
	public String getDashed(String word) {
		String result = "";
		//Escribe todo guiones, menos las letras mayúsculas
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == word.toUpperCase().charAt(i)) {
				result += word.charAt(i);
			} else {
				result += "-";
			}
		}
		return result;
	}

	public String pushLetter(String word, String response /*11. INTRODUCE PARAMETER OBJECT - deshacer*/) {		//3. EXTRACT INTERFACE (método default de la interfaz wordInterface, el resto abstractos)
		String result = "";
		//Cambia por mayúsculas los caracteres acertados
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == response.charAt(0)) {
				result += Character.toUpperCase(word.charAt(i));
			} else {
				result += word.charAt(i);
			}
		}
		return result;
	}
	
	public BufferedReader getWords() {
		BufferedReader result /*10. INLINE - CLICK A LA VARIABLE */= words;
		return words;
	}
}
