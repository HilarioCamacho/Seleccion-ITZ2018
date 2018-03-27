package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	
public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String opcionMenu = "";
		String opcionResultado = "";
		
		do {
			System.out.println("Introduce el lado del cubo :");
			String dato = br.readLine();
			try {
				float numero = Float.parseFloat(dato);
				Cubo cubo = new Cubo(numero);
				
				do {
					System.out.println("\n El dato introducido es:"+cubo.getLado());
					System.out.println("\n 1) Area \n 2) Perimetro \n 3) Volumen \n 4)Ingresar Dato Nuevo \n 5)Salir \n Introduce la opcion :");
					opcionMenu = br.readLine();
					switch (Integer.parseInt(opcionMenu)) {
						case 1:
							System.out.println("\n El area del cubo es: "+cubo.calcularArea()+" m^2 \n");
							do {
								System.out.println("\n 1)Menu Principal \n 2)Ingresar un nuevo Dato \n Introduce la opcion :");
								opcionResultado =  br.readLine();
								if (!opcionResultado.equalsIgnoreCase("1") && !opcionResultado.equalsIgnoreCase("2")) {
									System.out.println("\n Debes Introducir una de las opciones Mencionadas :(");
								}
							} while (!opcionResultado.equalsIgnoreCase("1") && !opcionResultado.equalsIgnoreCase("2"));
							break;
						case 2:
							System.out.println("\n El perimetro del cubo es: "+cubo.calcularPerimetro()+" cm \n");
							do {
								System.out.println("\n 1)Menu Principal \n 2)Ingresar un nuevo Dato \n Introduce la opcion :");
								opcionResultado =  br.readLine();
								if (!opcionResultado.equalsIgnoreCase("1") && !opcionResultado.equalsIgnoreCase("2")) {
									System.out.println("\n Debes Introducir una de las opciones Mencionadas :(");
								}
							} while (!opcionResultado.equalsIgnoreCase("1") && !opcionResultado.equalsIgnoreCase("2"));
							break;
						case 3:
							System.out.println("\n El volumen del cubo es: "+cubo.calcularVolumen()+" cm^3 \n");
							do {
								System.out.println("\n 1)Menu Principal \n 2)Ingresar un nuevo Dato \n Introduce la opcion :");
								opcionResultado =  br.readLine();
								if (!opcionResultado.equalsIgnoreCase("1") && !opcionResultado.equalsIgnoreCase("2")) {
									System.out.println("\n Debes Introducir una de las opciones Mencionadas :(");
								}
							} while (!opcionResultado.equalsIgnoreCase("1") && !opcionResultado.equalsIgnoreCase("2"));
							break;
						default:
							break;
					}
					if (opcionResultado.equals("2")) {
						opcionMenu="4";
					}
				} while (!opcionMenu.equalsIgnoreCase("4") && !opcionMenu.equalsIgnoreCase("5"));
			} catch (Exception e) {
				System.out.println("Introduce un numero entero o con punto decimal :(");
			}
			
		} while (!opcionMenu.equalsIgnoreCase("5"));
		System.out.println("Ejecucion Terminada");
		
	}

}
