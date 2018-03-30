package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Romanos{

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String respuesta = "";
		String romano = "";
		do {
			System.out.println("Introduce un numero entero a convertir :");
			String numero = br.readLine();
			numero = numero.trim();
			numero = numero.replaceAll("\\s{2,}","");
			try {
				if ((Integer.parseInt(numero) > 0) && (Integer.parseInt(numero) <= 1000)) {
					int tamaño = numero.length();
					switch (tamaño) {
					case 1:
						romano = convertirUnidades(Integer.parseInt(""+numero.charAt(0)));
						break;
					case 2:
						romano =convertirDecenas(Integer.parseInt(""+numero.charAt(0)))+convertirUnidades(Integer.parseInt(""+numero.charAt(1)));
						break;
					case 3:
						romano =convertirCentenas(Integer.parseInt(""+numero.charAt(0)))+convertirDecenas(Integer.parseInt(""+numero.charAt(1)))+convertirUnidades(Integer.parseInt(""+numero.charAt(2)));
						break;
					case 4:
						romano =convertirMilesimas(Integer.parseInt(""+numero.charAt(0)))+convertirCentenas(Integer.parseInt(""+numero.charAt(1)))+convertirDecenas(Integer.parseInt(""+numero.charAt(2)))+convertirUnidades(Integer.parseInt(""+numero.charAt(3)));
						break;
					default:
						break;
					}
					System.out.println("----------------------------------------------------------------------");
					System.out.println("*                             ROMANO                                 *");
					System.out.println("----------------------------------------------------------------------");
					System.out.println("\n"+numero+" = "+romano+"\n");
					System.out.println("----------------------------------------------------------------------");
				} else {
					System.out.println("El numero debe estar dentro del rango [1 a 1000]");
				}
				System.out.println("Deseas ingresar otro numero ? [ S |N ] :");
				respuesta = br.readLine();
			} catch (Exception e) {
				System.out.println("Debes introducir un numero entero :( \n");
			}
		} while (!respuesta.equalsIgnoreCase("N"));
		System.out.println("Ustede decidio salir, Hasta luego :)");
		System.out.println("Programa Terminado");
	}
		
	public static String convertirMilesimas(int mil) {
		
		String milesimas = "";
		switch (mil) {
		case 1:
			milesimas = "M";
			break;
		default:
			milesimas = "";
			break;
		}
		return milesimas;
	}
	
	
	public static String convertirCentenas(int cen) {
		String centenas = "";
		
		switch (cen) {
		case 1:
			centenas = "C";
			break;
		case 2:
			centenas = "CC";
			break;
		case 3:
			centenas = "CCC";
			break;
		case 4:
			centenas = "CD";
			break;
		case 5:
			centenas = "D";
			break;
		case 6:
			centenas = "DC";
			break;
		case 7:
			centenas = "DCC";
			break;
		case 8:
			centenas = "DCCC";
			break;
		case 9:
			centenas = "CM";
			break;
		default:
			break;
		}
		
		return centenas;
	}
	
	
	public static String convertirDecenas(int dec) {
		String decenas = "";
		switch (dec) {
		case 1:
			decenas = "X";
			break;
		case 2:
			decenas = "XX";
			break;
		case 3:
			decenas = "XXX";
			break;
		case 4:
			decenas = "LX";
			break;
		case 5:
			decenas = "L";
			break;
		case 6:
			decenas = "LX";
			break;
		case 7:
			decenas = "LXX";
			break;
		case 8:
			decenas = "LXX";
			break;
		case 9:
			decenas = "XC";
			break;
		default:
			break;
		}
		return decenas;
	}
	
	
	public static String convertirUnidades(int uni) {
		String unidades = "";
		switch (uni) {
		case 1:
			unidades = "I";
			break;
		case 2:
			unidades = "II";
			break;
		case 3:
			unidades = "III";
			break;
		case 4:
			unidades = "IV";
			break;
		case 5:
			unidades = "V";
			break;
		case 6:
			unidades = "VI";
			break;
		case 7:
			unidades = "VII";
			break;
		case 8:
			unidades = "VIII";
			break;
		case 9:
			unidades = "IX";
			break;
		default:
			unidades = "";
			break;
		}
		return unidades;
	}
	
}
