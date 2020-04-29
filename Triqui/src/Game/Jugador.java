/**
 **DESCRIPCION: Triqui.
 **NOMBRE:Javier Santiago Borbón
 **FECHA: 25 de Octubre de 2019
 **VERSION:1.0
 */
package punto2;

public class Jugador {

	//DECLARACIÓN ATRIBUTOS
	private String name;
	private int victorias;
	
	
	public Jugador(String name, int victorias) {
		this.name = name;
		this.victorias = victorias;
	}

	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public String getName() {
		return name;
	}


	
}
