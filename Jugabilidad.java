package brickBreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

class Jugabilidad extends JPanel implements KeyListener, ActionListener {

	private boolean jugar = false;
	private int puntaje = 0;

	private int ladrillosTotales = 21;

	private Timer timer;
	private int delay = 8;

	private int jugadorX = 310;

	private int pelotaX = 120;
	private int pelotaY = 350;
	private int pelotaXDirec = -1;
	private int pelotaYDirec = -2;
	private MapGenerator mapa;

	public Jugabilidad() {
		mapa = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		timer = new Timer(delay, this);
		timer.start();

	}

	public void paint(Graphics g) {
		// fondo
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);

		// bordes
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);

		// mapa
		mapa.dibujar((Graphics2D) g);

		// base
		g.setColor(Color.green);
		g.fillRect(jugadorX, 550, 100, 8);

		// pelota
		g.setColor(Color.yellow);
		g.fillOval(pelotaX, pelotaY, 20, 20);

		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();

		if (jugar) {

			pelotaX += pelotaXDirec;
			pelotaY += pelotaYDirec;

			if (new Rectangle(pelotaX, pelotaY, 20, 20).intersects(new Rectangle(jugadorX, 550, 100, 8))) {
				pelotaYDirec = -pelotaYDirec;
			}

			if (pelotaX < 0) {
				pelotaXDirec = -pelotaXDirec;
			}

			if (pelotaY < 0) {
				pelotaYDirec = -pelotaYDirec;
			}

			if (pelotaX > 670) {
				pelotaXDirec = -pelotaXDirec;

			}
		}
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (jugadorX >= 600) {
				jugadorX = 600;
			} else {
				moveRight();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (jugadorX < 10) {
				jugadorX = 10;
			} else {
				moveLeft();
			}
		}

	}

	public void moveRight() {
		jugar = true;
		jugadorX += 20;
	}

	public void moveLeft() {
		jugar = true;
		jugadorX -= 20;
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

}