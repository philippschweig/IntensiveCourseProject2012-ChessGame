import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Schachspiel
  *
  * @version 1.0 vom 07.01.2012
  * @author Philipp Schweig
  */

public class Schachspiel extends JFrame implements IGameCallback
{
	// Anfang Attribute
	private JPanel plStart;
	private Panel plSpiel;
	
	// Startobjekte
	private JLabel lbSpieler1, lbSpieler2;
	private JTextField tfSpieler1, tfSpieler2;
	
	// Spielobjekte
	private Schachbrett schachbrett;
	private JButton btnNeuesSpiel, btnSpielBeenden, btnNurKoenig;
	// Ende Attribute

	public Schachspiel(String title) {
		// Frame-Initialisierung
		super(title);
		
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		//int frameWidth = 700;
		int frameWidth = 1000;
		//int frameHeight = 700;
		int frameHeight = 700;
		this.setSize(frameWidth, frameHeight);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		
		this.setLocation(x, y);
		this.setResizable(false);
		
		Container cp = this.getContentPane();
		cp.setLayout(new CardLayout());
		
		// Anfang Komponenten
		// Startoberfläche
		GUIObjektDaten guiStartPanel = new GUIObjektDaten(new Koordinaten(GUIObjektDaten.zentriertX(frameWidth, 200),30), 200, 100);
		
		this.plStart = new JPanel(new SpringLayout());
		this.plStart.setBounds(guiStartPanel.x(), guiStartPanel.y(), guiStartPanel.breite, guiStartPanel.hoehe);
		
		//GUIObjektDaten guiSpieler = new GUIObjektDaten(75, 35);
		this.lbSpieler1 = new JLabel("Spieler 1 (weiß):");
		this.plStart.add(this.lbSpieler1);
		
		this.tfSpieler1 = new JTextField(64);
		lbSpieler1.setLabelFor(tfSpieler1);
		this.plStart.add(this.tfSpieler1);
		
		this.lbSpieler2 = new JLabel("Spieler 2 (schwarz):");
		this.plStart.add(this.lbSpieler1);
		
		this.tfSpieler2 = new JTextField(64);
		lbSpieler2.setLabelFor(tfSpieler2);
		this.plStart.add(this.tfSpieler2);
		
		SpringUtilities.makeCompactGrid(this.plStart, 3, 2, 6,6,6,6);
		
		cp.add(plStart, "plStart");
		
		// Spieloberfläche
		this.plSpiel = new Panel(null);
		
		// Schachbrett
		GUIObjektDaten guiSchachbrett = new GUIObjektDaten(new Koordinaten(GUIObjektDaten.zentriertX(frameWidth, 550),30), 550, 550);
		this.schachbrett = new Schachbrett();
		this.schachbrett.setBounds(guiSchachbrett.x(), guiSchachbrett.y(), guiSchachbrett.breite, guiSchachbrett.hoehe);
		this.plSpiel.add(this.schachbrett);
		
		// Buttons
		GUIObjektDaten guiNurKoenig = new GUIObjektDaten(guiSchachbrett.x(), guiSchachbrett.y() + guiSchachbrett.hoehe + 15, 100, 25);
		this.btnNurKoenig = new JButton("Nur König");
		this.btnNurKoenig.setBounds(guiNurKoenig.x(), guiNurKoenig.y(), guiNurKoenig.breite, guiNurKoenig.hoehe);
		
		this.btnNurKoenig.addActionListener(
			new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					NurKoenig();
				}
			}
		);
		
		this.plSpiel.add(this.btnNurKoenig);
		
		cp.add(plSpiel, "plSpiel");
		
		// Ende Komponenten

		this.setVisible(true);
		
		this.NeuesSpiel();
	}

	// Anfang Methoden
	public void NeuesSpiel()
	{
		Spiel.setInstance(this.schachbrett, this);
		Spiel.getInstance().starten();
	}
	
	// IGameCallback # anfang #
	public void KoenigImSchach(Object o)
	{
		
	}
	
	public void KoenigSchachMatt(Object o)
	{
		
	}
	
	public void GameOver(Object o)
	{
		JOptionPane.showMessageDialog(null,((Spieler)o).name + " hat verloren.","Spielende", JOptionPane.PLAIN_MESSAGE);
		
		JOptionPane.showInternalConfirmDialog(this, "Wollen Sie das Dokument vor dem Beenden speichern?", "Speichern", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
	// IGameCallback # ende #
	
	public void NurKoenig()
	{
		for(int x = 0; x < Spiel.getInstance().aktuellerSpieler().schachfiguren.size(); x++)
		{
			if(!(Spiel.getInstance().aktuellerSpieler().schachfiguren.get(x) instanceof F_Koenig))
			{
				System.out.println("Schachspiel/NurKoenig # ");
				this.schachbrett.loescheFigur(Spiel.getInstance().aktuellerSpieler().schachfiguren.get(x));
				Spiel.getInstance().aktuellerSpieler().schachfiguren.remove(x);
				x--;
			}
		}
		
		this.NurDame();
		
		//Spiel.getInstance().aktuellerSpieler().aktiviereZug();
	}
	
	public void NurDame()
	{
		for(int x = 0; x < Spiel.getInstance().gegnerischerSpieler().schachfiguren.size(); x++)
		{
			if(!(Spiel.getInstance().gegnerischerSpieler().schachfiguren.get(x) instanceof F_Dame))
			{
				System.out.println("Schachspiel/NurDame # ");
				this.schachbrett.loescheFigur(Spiel.getInstance().gegnerischerSpieler().schachfiguren.get(x));
				Spiel.getInstance().gegnerischerSpieler().schachfiguren.remove(x);
				x--;
			}
		}
	}
	
	// Ende Methoden

	public static void main(String[] args) {
		new Schachspiel("Schachspiel");
	}
}
