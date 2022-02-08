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
	private Panel plStart;
	private Panel plSpiel;
	private Container cp;
	
	// Startobjekte
	private Label lbSpieler1, lbSpieler2;
	private TextField tfSpieler1, tfSpieler2;
	private Button btnNeuesSpiel;
	
	// Spielobjekte
	private Schachbrett schachbrett;
	private Button btnSpielBeenden, btnNurKoenig;
	private Label lbS1, lbS2;
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
		
		this.cp = this.getContentPane();
		this.cp.setLayout(new CardLayout());
		
		// Anfang Komponenten
		// Startoberfläche
		GUIObjektDaten guiStartPanel = new GUIObjektDaten(new Koordinaten(GUIObjektDaten.zentriertX(frameWidth, 200),30), 200, 100);
		
		this.plStart = new Panel();
		//this.plStart.setBounds(guiStartPanel.x(), guiStartPanel.y(), guiStartPanel.breite, guiStartPanel.hoehe);
		this.plStart.setBounds(0, 0, 100, 50);
		this.plStart.setLayout(new GridLayout(3,2,5,5));
		
		//GUIObjektDaten guiSpieler = new GUIObjektDaten(75, 35);
		this.lbSpieler1 = new Label("Spieler 1 (weiß):");
		this.plStart.add(this.lbSpieler1);
		
		this.tfSpieler1 = new TextField(64);
		this.tfSpieler1.setText("Weiß");
		//this.lbSpieler1.setLabelFor(tfSpieler1);
		this.plStart.add(this.tfSpieler1);
		
		this.lbSpieler2 = new Label("Spieler 2 (schwarz):");
		this.plStart.add(this.lbSpieler2);
		
		this.tfSpieler2 = new TextField(64);
		this.tfSpieler2.setText("Schwarz");
		//this.lbSpieler2.setLabelFor(tfSpieler2);
		this.plStart.add(this.tfSpieler2);
		
		this.btnNeuesSpiel = new Button("Spiel starten");
		
		this.btnNeuesSpiel.addActionListener(
			new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					NeuesSpiel();
				}
			}
		);
		
		this.plStart.add(this.btnNeuesSpiel);
		
		//SpringUtilities.makeCompactGrid(this.plStart, 3, 2, 0,0,6,6);
		
		this.cp.add(plStart, "plStart");
		
		// Spieloberfläche
		this.plSpiel = new Panel(null);
		
		this.lbS1 = new Label();
		this.lbS1.setBounds(30, 30, 75, 35);
		this.plSpiel.add(this.lbS1);
		
		this.lbS2 = new Label();
		this.lbS2.setBounds(850, 30, 75, 35);
		this.plSpiel.add(this.lbS2);
		
		// Schachbrett
		GUIObjektDaten guiSchachbrett = new GUIObjektDaten(new Koordinaten(GUIObjektDaten.zentriertX(frameWidth, 550),30), 550, 550);
		this.schachbrett = new Schachbrett();
		this.schachbrett.setBounds(guiSchachbrett.x(), guiSchachbrett.y(), guiSchachbrett.breite, guiSchachbrett.hoehe);
		this.plSpiel.add(this.schachbrett);
		
		// Buttons
		GUIObjektDaten guiNurKoenig = new GUIObjektDaten(guiSchachbrett.x(), guiSchachbrett.y() + guiSchachbrett.hoehe + 15, 100, 25);
		this.btnNurKoenig = new Button("Nur König");
		this.btnNurKoenig.setBounds(guiNurKoenig.x(), guiNurKoenig.y(), guiNurKoenig.breite, guiNurKoenig.hoehe);
		
		this.btnNurKoenig.addActionListener(
			new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					NurKoenig();
				}
			}
		);
		
		this.plSpiel.add(this.btnNurKoenig);
		
		this.cp.add(plSpiel, "plSpiel");
		
		// Ende Komponenten

		this.setVisible(true);
		
		//this.NeuesSpiel();
	}

	// Anfang Methoden
	public void NeuesSpiel()
	{
		Spiel.setInstance(this.schachbrett, this, this.tfSpieler2.getText(), this.tfSpieler1.getText());
		Spiel.getInstance().starten();
		
		this.lbS1.setText(Spiel.getInstance().s2.name);
		this.lbS2.setText(Spiel.getInstance().s1.name);
		
		CardLayout cl = (CardLayout)this.cp.getLayout();
		cl.show(this.cp, "plSpiel");
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
