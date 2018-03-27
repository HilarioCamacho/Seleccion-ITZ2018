package modelo;

public class Cuadrado {

	private float lado;
	
	public Cuadrado(float lado) {
		this.lado = lado;
	}

	public float getLado() {
		return lado;
	}

	public void setLado(float lado) {
		this.lado = lado;
	}

	public float calcularArea() {
		return lado * lado;
	}
	
	public float calcularPerimetro() {
		return lado + lado + lado + lado;
	}
	
}
