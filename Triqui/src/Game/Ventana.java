/**
 **DESCRIPCION: Triqui.
 **NOMBRE:Javier Santiago Borbón
 **FECHA: 25 de Octubre de 2019
 **VERSION:1.0
 */
package punto2;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ImageIcon cross;
	private ImageIcon circle;
	private ImageIcon icon;
	private JPanel table;
	private JButton[][] espacios;
	private int[][] datos;
	private JPanel lateral;
	private JLabel lblVecesGanadas;
	private JLabel lblPlayer;
	private JLabel lblScore1;
	private JLabel lblPlayer2;
	private JLabel lblScore2;
	private JButton btnSalir;
	private Comprobar check;
	private int figura;
	private int score1;
	private int score2;
	private JLabel lblS1;
	private JLabel lblS2;
	private JLabel lblIcon;
	private int turno;

	public Ventana() {
		circle = new ImageIcon(getClass().getResource("/recursos/circle.png"));
		cross = new ImageIcon(getClass().getResource("/recursos/cross.png"));
		icon = new ImageIcon(getClass().getResource("/recursos/ticTacToe.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		table = new JPanel();
		table.setBackground(Color.WHITE);
		table.setBounds(0, 0, 500, 500);
		contentPane.add(table);
		table.setLayout(new GridLayout(3, 3));

		lateral = new JPanel();
		lateral.setBackground(Color.DARK_GRAY);
		lateral.setBounds(500, 0, 200, 500);
		contentPane.add(lateral);
		lateral.setLayout(null);

		lblIcon = new JLabel("Icono");
		lblIcon.setBounds(10, 11, 180, 161);
		lblIcon.setIcon(icon);
		lateral.add(lblIcon);

		lblVecesGanadas = new JLabel("VECES GANADAS:");
		lblVecesGanadas.setForeground(Color.RED);
		lblVecesGanadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVecesGanadas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblVecesGanadas.setBounds(10, 183, 161, 14);
		lateral.add(lblVecesGanadas);

		lblPlayer = new JLabel("Player 1:");
		lblPlayer.setForeground(Color.LIGHT_GRAY);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayer.setBounds(10, 208, 122, 25);
		lateral.add(lblPlayer);

		lblScore1 = new JLabel("100");
		lblScore1.setForeground(Color.LIGHT_GRAY);
		lblScore1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScore1.setBounds(154, 207, 46, 25);
		lateral.add(lblScore1);

		lblPlayer2 = new JLabel("Player 2:");
		lblPlayer2.setForeground(Color.LIGHT_GRAY);
		lblPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayer2.setBounds(10, 244, 122, 25);
		lateral.add(lblPlayer2);

		lblScore2 = new JLabel("100");
		lblScore2.setForeground(Color.LIGHT_GRAY);
		lblScore2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScore2.setBounds(154, 243, 46, 25);
		lateral.add(lblScore2);

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(10, 415, 180, 49);
		lateral.add(btnSalir);

		lblS1 = new JLabel("");
		lblS1.setForeground(Color.RED);
		lblS1.setBounds(10, 231, 46, 14);
		lateral.add(lblS1);

		lblS2 = new JLabel("");
		lblS2.setForeground(Color.RED);
		lblS2.setBounds(10, 273, 46, 14);
		lateral.add(lblS2);
		score1 = 0;
		score2 = 0;
		turno = 0;

		espacios = new JButton[3][3];
		datos = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				espacios[i][j] = new JButton();
				table.add(espacios[i][j]);
				espacios[i][j].setBackground(Color.BLACK);
				espacios[i][j].setFont(new Font("Times New Roman", Font.BOLD, 0));
				espacios[i][j].addActionListener(this);
			}
		}

		crearNuevo();

	}

	public JLabel getLblPlayer() {
		return lblPlayer;
	}

	public void setLblPlayer(JLabel lblPlayer) {
		this.lblPlayer = lblPlayer;
	}

	public JLabel getLblScore1() {
		return lblScore1;
	}

	public void setLblScore1(JLabel lblScore1) {
		this.lblScore1 = lblScore1;
	}

	public JLabel getLblPlayer2() {
		return lblPlayer2;
	}

	public void setLblPlayer2(JLabel lblPlayer2) {
		this.lblPlayer2 = lblPlayer2;
	}

	public JLabel getLblScore2() {
		return lblScore2;
	}

	public void setLblScore2(JLabel lblScore2) {
		this.lblScore2 = lblScore2;
	}

	public void crearNuevo() {
		if(figura==2) {
		figura=1;}		//'X'=1		'O'=2
		else {
			figura=2;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				espacios[i][j].setIcon(null);
				espacios[i][j].setText("5");
				datos[i][j] = 5;
			}
		}
		if(turno==0) {
			turno=1;
		}else {
			turno=0;
		}
		mostrarSigno(turno);
		check = new Comprobar(turno);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnSalir)) {
			JOptionPane.showMessageDialog(null,"ESPERAMOS HAYA DISFRUTADO EL JUEGO\n\nGRACIAS!!");
			dispose();
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (e.getSource().equals(espacios[i][j])) {
					if (espacios[i][j].getText().equals("5")) {
						espacios[i][j].setText(String.valueOf(check.asignarTurno()));
						if (espacios[i][j].getText().equals("0")) {
							espacios[i][j].setIcon(asignarSigno(0));
						} else if (espacios[i][j].getText().equals("1")) {
							espacios[i][j].setIcon(asignarSigno(1));

						}
						asignarDatosAMatriz();

						check.comprobarPartida(datos);
						if (check.comprobarPartida(datos) == 1) {
							JOptionPane.showMessageDialog(null,
									"HA GANADO EL JUGADOR 1: \n\t" + lblPlayer.getText() + "\n");
							score1++;
							lblScore1.setText(String.valueOf(score1));
							crearNuevo();
						} else if (check.comprobarPartida(datos) == 2) {
							JOptionPane.showMessageDialog(null,
									"HA GANADO EL JUGADOR 2: \n\t" + lblPlayer2.getText() + "\n");
							crearNuevo();
							score2++;
							lblScore2.setText(String.valueOf(score2));
						} else if (check.comprobarPartida(datos) == 3) {
							JOptionPane.showMessageDialog(null, "\t\tEMPATE\n");
							crearNuevo();
						}

					}
				}
			}
		}
	}

	private ImageIcon asignarSigno(int num) {
		if (figura == 2) {
			if (num != 1) {
				return circle;

			} else {
				return cross;
			}
		} else {
			if (num != 1) {
				
				return cross;
			} else {
				lblS2.setText("O");
				return circle;
			}
		}
	}
	
	private void mostrarSigno(int turno) {
		if(turno==1) {
			lblS1.setText("O");
			lblS2.setText("X");
		}else {
			lblS1.setText("X");
			lblS2.setText("O");
		}
	}

	private void asignarDatosAMatriz() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				datos[i][j] = Integer.parseInt(espacios[i][j].getText());
			}
		}
	}

}
