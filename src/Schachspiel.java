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
		int frameWidth = 850;
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
		
		this.plStart = new Panel(null);
		//this.plStart.setBounds(guiStartPanel.x(), guiStartPanel.y(), guiStartPanel.breite, guiStartPanel.hoehe);
		
		GUIObjektDaten guiStartPanel = new GUIObjektDaten(new Koordinaten(GUIObjektDaten.zentriertX(frameWidth, 250),200), 250, 75);
		
		Panel tempPanel = new Panel(new GridLayout(3,2,5,5));
		tempPanel.setBounds(guiStartPanel.x(), guiStartPanel.y(), guiStartPanel.breite, guiStartPanel.hoehe);
		
		//GUIObjektDaten guiSpieler = new GUIObjektDaten(75, 35);
		this.lbSpieler1 = new Label("Spieler 1 (weiß):");
		tempPanel.add(this.lbSpieler1);
		
		this.tfSpieler1 = new TextField(64);
		this.tfSpieler1.setText("Weiß");
		//this.lbSpieler1.setLabelFor(tfSpieler1);
		tempPanel.add(this.tfSpieler1);
		
		this.lbSpieler2 = new Label("Spieler 2 (schwarz):");
		tempPanel.add(this.lbSpieler2);
		
		this.tfSpieler2 = new TextField(64);
		this.tfSpieler2.setText("Schwarz");
		//this.lbSpieler2.setLabelFor(tfSpieler2);
		tempPanel.add(this.tfSpieler2);
		
		this.btnNeuesSpiel = new Button("Spiel starten");
		
		this.btnNeuesSpiel.addActionListener(
			new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					NeuesSpiel();
				}
			}
		);
		
		tempPanel.add(this.btnNeuesSpiel);
		
		this.plStart.add(tempPanel);
		
		this.cp.add(plStart, "plStart");
		
		// Spieloberfläche
		this.plSpiel = new Panel(null);
		
		this.lbS1 = new Label();
		this.lbS1.setBounds(30, 30, 75, 35);
		this.plSpiel.add(this.lbS1);
		
		this.lbS2 = new Label();
		this.lbS2.setBounds(725, 30, 75, 35);
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
		JOptionPane.showMessageDialog(this,((Spieler)o).name + " hat verloren.","Spielende", JOptionPane.PLAIN_MESSAGE);
		
		if(0 == JOptionPane.showConfirmDialog(this, "Zurück zur Hauptseite?", "Zurück", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE))
		{
			this.schachbrett.loescheAlleFiguren();
			
			CardLayout cl = (CardLayout)this.cp.getLayout();
			cl.show(this.cp, "plStart");
		}
	}
	
	public String BauerTausch()
	{
		String[] strings = {"Turm", "Springer", "Laeufer", "Dame"};
		Object[] options = {"OK"};
		String auswahl = Tools.auswahlbox("Wähle eine Figur aus:", "Figurauswahl", strings, options, 3);
		
		return auswahl;
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
