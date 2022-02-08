import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Schachbrett extends JPanel implements MouseListener
{
	// Eigenschaften
	public boolean statusAngriff = false;
	// [zahln][buchstabeen]
	public Schachfeld felder[][] = new Schachfeld[10][10];
	public Schachfeld gewaehltesFeld;
	
	public GridBagLayout gbl = new GridBagLayout();
	// Konstruktor
	public Schachbrett()
	{
		super(null);
		
		this.setLayout(this.gbl);
		
		String feldbeschreibung = new String();
		boolean figurFeld;
		
		for(int f1 = 0; f1 < felder.length; f1++)
		{
			for(int f2 = 0; f2 < felder[f1].length; f2++)
			{
				figurFeld = false;
				
				if((f1 == 0 || f1 == 9) && (f2 > 0 && f2 < 9))
				{
					switch(f2)
					{
						case 1:
							feldbeschreibung = "A";
							break;
						case 2:
							feldbeschreibung = "B";
							break;
						case 3:
							feldbeschreibung = "C";
							break;
						case 4:
							feldbeschreibung = "D";
							break;
						case 5:
							feldbeschreibung = "E";
							break;
						case 6:
							feldbeschreibung = "F";
							break;
						case 7:
							feldbeschreibung = "G";
							break;
						case 8:
							feldbeschreibung = "H";
							break;
					}
				} else if((f2 == 0 || f2 == 9) && (f1 > 0 && f1 < 9))
				{
					feldbeschreibung = ""+f1;
				}
				else if((f1 == 0 || f1 == 9) && (f2 == 0 || f2 == 9))
				{
					feldbeschreibung = "";
				}
				else
				{
					//feldbeschreibung = "B" + f1 + ", Z" + f2;
					feldbeschreibung = "";
					figurFeld = true;
				}
				
				
				felder[f1][f2] = new Schachfeld(feldbeschreibung, this , f1, f2, figurFeld);
			}
		}
		
		this.addMouseListener(this);
	}
	
	// Methoden
	public void setzeFiguren(java.util.List<Figur> figuren)
	{
		for(int i = 0; i < figuren.size(); i++)
		{
			figuren.get(i).setze(this.felder[figuren.get(i).pos.zahl][figuren.get(i).pos.buchstabe]);
			this.felder[figuren.get(i).pos.zahl][figuren.get(i).pos.buchstabe].setzeFigur(figuren.get(i));
			
		}
	}
	
	public void loescheFigur(Figur f)
	{
		boolean gefunden = false;
		
		for(int x = 1; x < this.felder.length - 1; x++)
		{
			for(int y = 1; y < this.felder[x].length - 1; y++)
			{
				System.out.println("Schachbrett/loescheFigur # x: " + x + " y:" + y);
				if(this.felder[x][y].figur == f)
				{
					this.felder[x][y].loescheFigur();
					gefunden = true;
					break;
				}
			}
			
			if(gefunden)
			{
				break;
			}
		}
	}
	
	public void loescheAlleFiguren()
	{
		for(int x = 1, y = 1; x < this.felder.length - 1 && y < this.felder[x].length - 1; x++, y++)
		{
			this.felder[x][y].loescheFigur();
		}
		
		gewaehltesFeld = null;
	}
	
	public void feldAktivieren(Position pos)
	{
		System.out.println("Schachbrett/feldAktivieren # zahl: " + pos.zahl + " buchstabe: " + pos.buchstabe);
		if(pos.spielzug)
		{
			if(pos.angriff)
			{
				this.felder[pos.zahl][pos.buchstabe].feldAktivieren(new Color(135, 0, 0));
			}
			else
			{
				//this.felder[pos.zahl][pos.buchstabe].feldAktivieren(new Color(0, 106, 255));
				this.felder[pos.zahl][pos.buchstabe].feldAktivieren(new Color(135, 185, 255));
			}
		}
		else
		{
			this.felder[pos.zahl][pos.buchstabe].feldAktivieren();
		}
	}
	
	public void feldDeaktivieren(Position pos)
	{
		this.felder[pos.zahl][pos.buchstabe].feldDeaktivieren();
	}
	
	public void felderAktivieren(java.util.List<Position> positionen)
	{
		for(int x = 0; x < positionen.size(); x++)
		{
			this.feldAktivieren(positionen.get(x));
		}
	}
	
	public void felderDeaktivieren(java.util.List<Position> positionen)
	{
		for(int x = 0; x < positionen.size(); x++)
		{
			this.feldDeaktivieren(positionen.get(x));
		}
	}
	
	public void alleFelderDeaktivieren()
	{
		for(int x = 1; x < felder.length - 1; x++)
		{
			for(int y = 1; y < felder[x].length - 1; y++)
			{
				felder[x][y].feldDeaktivieren();
			}
		}
	}
	
	public void figurenAktivieren(java.util.List<Figur> figuren)
	{
		for(int i = 0; i < figuren.size(); i++)
		{
			//this.felder[figuren.get(i).pos.zahl][figuren.get(i).pos.buchstabe].feldAktivieren(new Color(136, 255, 0));
			if(figuren.get(i).zuege().size() > 0)
			{
				this.felder[figuren.get(i).pos.zahl][figuren.get(i).pos.buchstabe].feldAktivieren(new Color(185, 255, 135));
			}
		}
	}
	
	public void figurenDeaktivieren(java.util.List<Figur> figuren)
	{
		for(int i = 0; i < figuren.size(); i++)
		{
			this.felder[figuren.get(i).pos.zahl][figuren.get(i).pos.buchstabe].feldDeaktivieren();
		}
	}
	
	// Mouse
	public void mouseClicked(MouseEvent e) {
		if(this.statusAngriff)
		{
			this.statusAngriff = false;
			this.alleFelderDeaktivieren();
			Spiel.getInstance().aktuellerSpieler().aktiviereZug();
		}
	}

	public void mouseEntered(MouseEvent e) {
		//System.out.println("The mouse entered the frame.");
	}

	public void mouseExited(MouseEvent e) {
		//System.out.println("The mouse exited the frame.");
	}

	public void mousePressed(MouseEvent e) {
		//System.out.println("The left mouse button was pressed.");
	}

	public void mouseReleased(MouseEvent e) {
		//System.out.println("The left mouse button was released.");
	}
}