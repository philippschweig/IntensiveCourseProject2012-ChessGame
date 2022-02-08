import java.awt.*;
import java.awt.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 07.01.2012
  * @author
  */

public class Schachspiel extends Frame {
	// Anfang Attribute
	private Schachbrett schachbrett;
	private static Spiel spiel;
	private Panel gamePanel;
	// Ende Attribute

	public Schachspiel(String title) {
		// Frame-Initialisierung
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) { dispose(); }
		});
		
		int frameWidth = 700;
		int frameHeight = 700;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		Panel cp = new Panel(null);
		add(cp);
		
		// Anfang Komponenten
		this.gamePanel = new Panel();
		
		this.schachbrett = new Schachbrett(this.gamePanel);
		this.gamePanel.setLayout(this.schachbrett);
		
		//this.schachbrett.setBounds(110, 75, frameWidth - 200, frameHeight - 200);
		//this.schachbrett.setLayout(new GridLayout(10,10,1,1));
		cp.add(gamePanel);
		
		// Ende Komponenten

		setResizable(true);
		setVisible(true);
	}

	// Anfang Methoden
	// Ende Methoden

	public static void main(String[] args) {
		new Schachspiel("Schachspiel");
		
		spiel = new Spiel();
	}
}
