import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Schachfeld
{
	//
	// Eigenschaften
	//
	private Schachbrett b;
	public Figur figur = null;
	
	public JButton btFeld = null;
	private JLabel lbFeld = null;
	private ImageIcon icon = new ImageIcon(getClass().getResource("/Images/Leer.gif"));
	
	private Position pos;
	private boolean statusAuswahl;
	
	//
	// Konstruktor
	//
	public Schachfeld(String feldbeschreibung, Schachbrett bTemp, int spalte, int zeile, boolean figurfeld)
	{
		// Referenziert das Schachbrett
		this.b = bTemp;
		
		// Setzt das Label
		
		// Prüft ob das Feld ein Figurenfeld ist
		if(figurfeld)
		{
			this.lbFeld = new JLabel(this.icon);
			this.lbFeld.setHorizontalAlignment(JLabel.CENTER);
			
			this.pos = new Position(spalte, zeile);
			
			this.lbFeld.setOpaque(true);
			this.lbFeld.setVisible(true);
			
			//this.btFeld = new JButton("B: " + spalte + ", Z: " + zeile);
			this.btFeld = new JButton(this.icon);
			this.btFeld.setMargin(new Insets(2, 2, 2, 2));
			this.btFeld.setVisible(false);
			
			if( this.schwarzesFeld(spalte, zeile) )
			{
				this.lbFeld.setBackground(Color.BLACK);
				this.lbFeld.setForeground(Color.WHITE);
				
				this.btFeld.setBackground(Color.BLACK);
				this.btFeld.setForeground(Color.WHITE);
			}
			else
			{
				this.btFeld.setBackground(Color.WHITE);
				this.btFeld.setForeground(Color.BLACK);
				
				this.lbFeld.setBackground(Color.WHITE);
				this.lbFeld.setForeground(Color.BLACK);
			}
			
			this.btFeld.addActionListener(
				new ActionListener() { 
					public void actionPerformed(ActionEvent e) { 
						btFeld_ActionPerformed(e);
					}
				}
			);
			
			this.add(this.btFeld, spalte, zeile, 1.0, 1.0);
		}
		else
		{
			this.lbFeld = new JLabel(feldbeschreibung);
			this.lbFeld.setHorizontalAlignment(JLabel.CENTER);
		}
		
		this.add(this.lbFeld, spalte, zeile, 1.0, 1.0);
	}
	
	//
	// Methoden
	//
	// Setzt eine Figur auf das Schachfeld
	public void setzeFigur(Figur figur)
	{
		this.figur = figur;
		
		//this.lbFeld.setText(this.figur.name);
		this.lbFeld.setIcon(this.figur.icon);
		this.lbFeld.setVisible(false);
		
		//this.btFeld.setText(this.figur.name);
		this.btFeld.setIcon(this.figur.icon);
		this.btFeld.setVisible(true);
	}
	
	
	public void loescheFigur()
	{
		System.out.println("Schachfeld/loescheFigur # ");
		this.figur = null;
		
		//this.lbFeld.setText("");
		this.lbFeld.setIcon(this.icon);
		this.lbFeld.setVisible(true);
		
		//this.btFeld.setText("");
		this.btFeld.setIcon(this.icon);
		this.btFeld.setVisible(false);
	}
	
	// Wird ausgeführt, wenn der Button geklickt wird
	public void btFeld_ActionPerformed(ActionEvent e) {
		// TODO hier Quelltext einfügen
		if(!this.b.statusAngriff)
		{
			System.out.println("Schachfeld/btFeld_ActionPerformed # Mögliche Züge anzeigen *******");
			this.b.statusAngriff = true;
			this.b.gewaehltesFeld = this;
			this.b.alleFelderDeaktivieren();
			this.b.felderAktivieren(this.figur.zuege());
		}
		else
		{
			this.b.statusAngriff = false;
			this.b.gewaehltesFeld.figur.bewege(this.pos, this.b.gewaehltesFeld, this);
			this.b.alleFelderDeaktivieren();
			Spiel.getInstance().spielerwechsel();
		}
	}
	
	// Prüft ob das Feld mit der gegebenen Spalte und Ziele ein schwarzes Feld ist
	// True: schwarzes Feld
	// False: weißes Feld
	private boolean schwarzesFeld(int spalte, int zeile)
	{
		// ungerade Spalte und ungerade Ziele
		if( (spalte % 2) != 0 && (zeile % 2) != 0 )
		{
			return true;
		}
		// gerade Spalte und ungerade Ziele
		else if( (spalte % 2) == 0 && (zeile % 2) != 0 )
		{
			return false;
		}
		// ungerade Spalte und gerade Ziele
		else if( (spalte % 2) != 0 && (zeile % 2) == 0 )
		{
			return false;
		}
		// gerade Spalte und gerade Ziele
		else if( (spalte % 2) == 0 && (zeile % 2) == 0 )
		{
			return true;
		}
		// alles was nicht passt
		else
		{
			return false;
		}
	}
	
	// Aktiviert das Feld (Button)
	public void feldAktivieren()
	{
		this.btFeld.setVisible(true);
		this.lbFeld.setVisible(false);
	}
	
	public void feldAktivieren(Color c)
	{
		this.btFeld.setBackground(c);
		this.btFeld.setVisible(true);
		this.lbFeld.setVisible(false);
	}
	
	// 0 - Figurauswahl, 1 - Zug, 2 - Angriff
	public void feldAktivieren(int feldart)
	{
		//this.btFeld.setBackground(c);
		this.btFeld.setVisible(true);
		this.lbFeld.setVisible(false);
	}
	
	// Deaktiviert das Feld (Button)
	public void feldDeaktivieren()
	{
		if(schwarzesFeld(pos.zahl, pos.buchstabe))
		{
			this.btFeld.setBackground(Color.BLACK);
		}
		else
		{
			this.btFeld.setBackground(Color.WHITE);
		}
		
		this.btFeld.setVisible(false);
		this.lbFeld.setVisible(true);
	}
	
	// Fügt ein Objekt in das GridBagLayout ein
	private void add(
		Component c,
		int x, int y,
		double weightx, double weighty)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x; gbc.gridy = y;
		gbc.weightx = weightx; gbc.weighty = weighty;
		gbc.insets = new Insets(1, 1, 1, 1);
		this.b.gbl.setConstraints(c, gbc);
		this.b.add(c);
	}
	
	// Fügt ein Objekt in das GridBagLayout ein
	private void add(
		Component c,
		int x, int y,
		int width, int height,
		double weightx, double weighty)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x; gbc.gridy = y;
		//gbc.gridwidth = width; gbc.gridheight = height;
		gbc.weightx = weightx; gbc.weighty = weighty;
		gbc.insets = new Insets(1, 1, 1, 1);
		c.setPreferredSize(new Dimension(width,height));
		this.b.gbl.setConstraints(c, gbc);
		this.b.add(c);
	}
}