/**
 **DESCRIPCION: Triqui.
 **NOMBRE:Javier Santiago Borbón
 **FECHA: 25 de Octubre de 2019
 **VERSION:1.0
 */
package punto2;
public class Comprobar {

	private int ganador; // 0=Juego en curso //1=Gana player 1 //2= Gana player 2 //3=Empate
	private boolean empate;
	private int turn;

	public int asignarTurno() { //1=Jugador 1	0=Jugador 2
		if(turn==0) {
			turn=1;
		}else {
			turn=0;
		}
		return turn;

	}

	public int comprobarPartida(int[][] datos) {
		// COMPROBAR SI GANO ALGUNO
		if (datos[0][0] == datos[0][1] && datos[0][0] == datos[0][2]&&datos[0][0] !=5) { // FILA 0
			if (datos[0][0] == 0) {
				ganador = 1;
			} else {
				ganador = 2;
			}
		} else if (datos[1][0] == datos[1][1] && datos[1][0] == datos[1][2]&&datos[1][0] !=5) { // FILA 1

			if (datos[1][0] == 0) {
				ganador = 1;
			} else {
				ganador = 2;
			}
		} else if (datos[2][0] == datos[2][1] && datos[2][0] == datos[2][2]&&datos[2][0] !=5) { // FILA 2
			if (datos[2][0] == 0) {
				ganador = 1;
			} else {
				ganador = 2;
			}
		} else if (datos[0][0] == datos[1][0] && datos[0][0] == datos[2][0]&&datos[0][0] !=5) { // COLUMNA 0
			if (datos[0][0] == 0) {
				ganador = 1;
			} else {
				ganador = 2;
			}
		} else if (datos[0][1] == datos[1][1] && datos[0][1] == datos[2][1]&&datos[0][1] !=5) { // COLUMNA 1
			if (datos[0][1] == 0) {
				ganador = 1;
			} else {
				ganador = 2;
			}
		} else if (datos[0][2] == datos[1][2] && datos[0][2] == datos[2][2]&&datos[0][2] !=5) { // COLUMNA 2
			if (datos[0][2] == 0) {
				ganador = 1;
			} else {
				ganador = 2;
			}
		} else if (datos[0][0] == datos[1][1] && datos[0][0] == datos[2][2]&&datos[0][0] !=5) { // DIAGONAL [0][0]-[2][2]
			if (datos[0][0] == 0) {
				ganador = 1;
			} else {
				ganador = 2;
			}
		} else if (datos[2][0] == datos[1][1] && datos[2][0] == datos[0][2]&&datos[2][0] !=5) { // DIAGONAL [2][0]-[0][2]
			if (datos[2][0] == 0) {
				ganador = 1;
			} else {
				ganador = 2;
			}
		} else {
			// COMPROBAR SI NO HAY CASILLAS DESOCUPADAS
			empate = true;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (datos[i][j] == 5) {
						empate = false;
					}
				}
			}
			if (empate == true) {
				ganador = 3;
			}
		}
		return ganador;

	}

	public Comprobar(int turno) {
		this.ganador = 0;
		this.empate = true;
		this.turn=turno;
	}

}
