import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 07.01.2012
  * @author
  */

public class Schachspiel extends JFrame {
	// Anfang Attribute
	private Schachbrett schachbrett;
	// Ende Attribute

	public Schachspiel(String title) {
		// Frame-Initialisierung
		super(title);
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		int frameWidth = 700;
		int frameHeight = 700;
		this.setSize(frameWidth, frameHeight);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		
		this.setLocation(x, y);
		this.setResizable(false);
		
		Container cp = this.getContentPane();
		cp.setLayout(null);
		
		// Anfang Komponenten
		this.schachbrett = new Schachbrett();
		this.schachbrett.setBounds(75, 75, frameWidth - 200, frameHeight - 200);
		//this.schachbrett.setLayout(new GridLayout(10,10,1,1));
		cp.add(schachbrett);
		
		// Ende Komponenten

		this.setVisible(true);
		
		this.NeuesSpiel();
	}

	// Anfang Methoden
	public void NeuesSpiel()
	{
		Spiel.setInstance(this.schachbrett);
		Spiel.getInstance().starten();
	}
	// Ende Methoden

	public static void main(String[] args) {
		new Schachspiel("Schachspiel");
	}
}
