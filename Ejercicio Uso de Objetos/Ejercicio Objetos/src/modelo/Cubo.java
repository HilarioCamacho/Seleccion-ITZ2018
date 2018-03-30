package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Cubo extends Cuadrado {

	public Cubo(float lado) {
		super(lado);
	}
	
	public float calcularVolumen(){
		return (getLado() * getLado() * getLado());
	}

}
