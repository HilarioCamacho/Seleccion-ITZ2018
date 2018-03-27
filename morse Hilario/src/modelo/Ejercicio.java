package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Ejercicio {


	// Objeto el cual es utilizado para interpretar un caracter con su valor en morse
	public static class Morse{
		
		private char caracter;
		private String codigo;
		
		public Morse(char caracter, String codigo) {
			super();
			this.caracter = caracter;
			this.codigo = codigo;
		}

		public char getCaracter() {
			return caracter;
		}
		
		public void setCaracter(char caracter) {
			this.caracter = caracter;
		}
		
		public String getCodigo() {
			return codigo;
		}
		
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		// Clase e que nos permite leer entradas de teclado en consola
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int opcion = 0;
		String cadena = "";
		String respuesta = "";
		do {
			System.out.println("Introduce la cadena a traducir:");
			cadena = br.readLine();
			// Comprueba la cadena mediante el metodo y almacena la opcion que ejecutara
			opcion = comprobar(cadena);
			String traduccion = "";
			switch (opcion) {
			case 0:
				System.out.println("Cadena Invalida Intenta de Nuevo \n");
				break;
			case 1:
				traduccion = traducir_a_Morse(cadena);
				if (!cadena.equalsIgnoreCase("salir")) {
					System.out.println("--------- Traduccion --------- \n");
					System.out.println(cadena.toUpperCase()+" = "+traduccion+"\n");
					System.out.println("------------------------------");
				}
				break;
			case 2:
				traduccion = traducir_a_Texto(cadena);
				if (!cadena.equalsIgnoreCase("salir")) {
					System.out.println("--------- Traduccion --------- \n");
					System.out.println(cadena+" = "+traduccion+"\n");
					System.out.println("------------------------------");
				}
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
			// Pregunta al usuario si desea continuar ingresando palabras a traducir
			System.out.println("Continuar? [S | N] :");
			respuesta = br.readLine();
			// En caso de ser No (N) el programa finalizara
		} while (!respuesta.toUpperCase().equalsIgnoreCase("N"));
		System.out.println("Usted Decidio Salir, Hasta Luego :)");
		System.out.println("Programa Terminado");

	}
	
	public static String traducir_a_Morse(String cadena) {
		ArrayList<Morse> claves1 = getClavesEstatico();
		String traduccion = "";
		//Verificamos que nuestra cadena no venga nula o vacia
		if ((cadena != "") && (cadena != null)) {
			// Remplazamos espacios de tamño 2 en adelante por un solo espacio en blanco
			cadena = cadena.replaceAll("\\s{2,}", " ");
			// Separamos en tokens por medio del espacio en blanco
			StringTokenizer tokens = new StringTokenizer(cadena, " ");
			while(tokens.hasMoreTokens()){
				char[] caracteres = tokens.nextToken().toUpperCase().toCharArray();
				// Evaluamos caracter por caracter para encontrar su valor en morse
				for (int i = 0; i < caracteres.length; i++) {
					for (Morse morse : claves1) {
						if (caracteres[i] == morse.getCaracter()) {
							traduccion+=morse.getCodigo()+" ";
							break;
						}
					}
				}
				traduccion+="   ";
			}
			traduccion = traduccion.trim();
		}else {
			traduccion = "NO DIGITASTE NINGUNA PLABRA";
		}
		return traduccion;
	}
	
	public static String traducir_a_Texto(String cadena) {
		ArrayList<Morse> claves1 = getClavesEstatico();
		String traduccion = "";
		//Verificamos que nuestra cadena no venga nula o vacia
		if ((cadena != "") && (cadena != null)) {
			// Quitamos espacios en los bordes de las cadenas
			String caux = cadena.trim();
			// Remplazamos espacios de tamño 2 en adelante por un caracter especifico
			caux = caux.replaceAll("\\s{2,}", "@");
			// Separamos en tokens por medio del caracter antes mencionado
			String[] tokens = caux.split("@");
			// Recorremos nuestro vector de cadenas para comenzar la traduccion
			for (int i = 0; i < tokens.length; i++) {
				char[] aux = (tokens[i]+" ").toCharArray();
				String cadAux = "";
				// Concatenamos hasta encontrar un espacio en blanco para despues compararlo y transformalo a su valor en caracter
				for (int j = 0; j < aux.length; j++) {
					if (aux[j] != ' ') {
						cadAux += aux[j];
					}else {
						for (Morse morse : claves1) {
							if (cadAux.equalsIgnoreCase(morse.getCodigo())) {
								traduccion += morse.getCaracter();
								cadAux = "";
								break;
							}
						}
					}
				}
				traduccion+=" ";
			}
			traduccion = traduccion.trim();
		}else {
			traduccion = "NO DIGITASTE NINGUNA PLABRA";
		}
		return traduccion;
	}
	
	
	// Metodo que sirve para evaluar una palabra y determinar si corresponde a un lenguaje u otro
	public static int comprobar(String cadena){
		boolean alfabeto = false;
		boolean otros = false;
		ArrayList<Morse> aux = getClavesEstatico();
		for (Morse morse : aux) {
			if (cadena.toUpperCase().contains(""+morse.getCaracter())) {
				alfabeto =  true;
			}
			if (cadena.contains(".") || cadena.contains("-")) {
				otros = true;
			}
		}
		if (alfabeto && otros) {
			return 0;
		} else {
			if (alfabeto) {
				return 1;
			} else {
				return 2;
			}
		}
		
	}
	
	public static ArrayList<Morse> getClavesEstatico(){
		
		// Creo un array list en el cual se introudcen todo los objetos Morse con los cuales
		// se evaluaran para traducir el texto en ambos casos
		ArrayList<Morse> claves = new ArrayList<>();
		// Letras del Alfabeto
		claves.add(new Morse('A',".-"));
		claves.add(new Morse('B',"-..."));
		claves.add(new Morse('C',"-.-."));
		claves.add(new Morse('D',"-.."));
		claves.add(new Morse('E',"."));
		claves.add(new Morse('F',"..-."));
		claves.add(new Morse('G',"--."));
		claves.add(new Morse('H',"...."));
		claves.add(new Morse('I',".."));
		claves.add(new Morse('J',".---"));
		claves.add(new Morse('K',"-.-"));
		claves.add(new Morse('L',".-.."));
		claves.add(new Morse('M',"--"));
		claves.add(new Morse('N',"-."));
		claves.add(new Morse('O',"---"));
		claves.add(new Morse('P',".--."));
		claves.add(new Morse('Q',"--.-"));
		claves.add(new Morse('R',".-."));
		claves.add(new Morse('S',"..."));
		claves.add(new Morse('T',"-"));
		claves.add(new Morse('U',"..-"));
		claves.add(new Morse('V',"...-"));
		claves.add(new Morse('W',".--"));
		claves.add(new Morse('X',"-..-"));
		claves.add(new Morse('Y',"-.--"));
		claves.add(new Morse('Z',"--.."));
		// Numeros
		claves.add(new Morse('1',".----"));
		claves.add(new Morse('2',"..---"));
		claves.add(new Morse('3',"...--"));
		claves.add(new Morse('4',"....-"));
		claves.add(new Morse('5',"....."));
		claves.add(new Morse('6',"-...."));
		claves.add(new Morse('7',"--..."));
		claves.add(new Morse('8',"---.."));
		claves.add(new Morse('9',"----."));
		claves.add(new Morse('0',"-----"));
		
		return claves;
	}

}
