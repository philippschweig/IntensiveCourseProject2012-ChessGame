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
	private Schachfigur figur = null;
	
	public JButton btFeld = null;
	private JLabel lbFeld = null;
	private ImageIcon iiPicture = null;
	
	//
	// Konstruktor
	//
	public Schachfeld(String feldbeschreibung, Schachbrett bTemp, int spalte, int zeile, boolean figurfeld)
	{
		// Referenziert dsa Schachbrett
		this.b = bTemp;
		
		// Setzt das Label
		this.lbFeld = new JLabel(feldbeschreibung);
		this.lbFeld.setHorizontalAlignment(JLabel.CENTER);
		
		// Prüft ob das Feld ein Figurenfeld ist
		if(figurfeld)
		{
			this.lbFeld.setOpaque(true);
			this.lbFeld.setVisible(false);
			
			this.btFeld = new JButton("B: " + spalte + ", Z: " + zeile);
			this.btFeld.setMargin(new Insets(2, 2, 2, 2));
			this.btFeld.setVisible(true);
			
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
					public void actionPerformed(ActionEvent evt) { 
						btFeld_ActionPerformed(evt);
					}
				}
			);
			
			this.add(this.btFeld, spalte, zeile, 1.0, 1.0);
		}
		
		this.add(this.lbFeld, spalte, zeile, 1.0, 1.0);
	}
	
	//
	// Methoden
	//
	// Setzt eine Figur auf das Schachfeld
	public void setzeFigur(Schachfigur figur)
	{
		this.figur = figur;
		
		this.lbFeld.setText(this.figur.getName());
		this.btFeld.setText(this.figur.getName());
		
	}
	
	// Wird ausgeführt, wenn der Button geklickt wird
	public void btFeld_ActionPerformed(ActionEvent evt) {
		// TODO hier Quelltext einfügen
		this.btFeld.setText("@");
	}
	
	// Prüft ob das Feld mit der gegebenen Spalte und Ziele ein schwarzes Feld ist
	// True: schwartes Feld
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