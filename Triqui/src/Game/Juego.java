/**
 **DESCRIPCION: Triqui.
 **NOMBRE:Javier Santiago Borbón
 **FECHA: 25 de Octubre de 2019
 **VERSION:1.0
 */
package punto2;

import javax.swing.JOptionPane;

public class Juego {

	public static void main(String args[]) {

		// DECLARACION DE VARIABLES
		String name;
		//DECLARACION DE OBJETOS
		Ventana frame;
		Jugador[] player;

		// NUEVO JUEGO
		
		frame = new Ventana();
		frame.setVisible(true);
		player=new Jugador[2];
		for (int i = 1; i < 3; i++) {
			name=JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador "+i, "Player "+i);
			if(name==null) {
				name="Player "+i;
			}
			player[i-1]=new Jugador(name,0);
		}
		
		frame.getLblPlayer().setText(player[0].getName());
		frame.getLblPlayer2().setText(player[1].getName());
		frame.getLblScore1().setText(String.valueOf(player[0].getVictorias()));
		frame.getLblScore2().setText(String.valueOf(player[1].getVictorias()));
	}
}
