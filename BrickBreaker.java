package brickBreaker;

import javax.swing.JFrame;

public class BrickBreaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana = new Ventana();

	}

}

class Ventana extends JFrame {

	public Ventana() {

		Jugabilidad jugabilidad = new Jugabilidad();
		setBounds(10, 10, 700, 600);
		setTitle("La bolita loca");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(jugabilidad);

		setVisible(true);
	}
}