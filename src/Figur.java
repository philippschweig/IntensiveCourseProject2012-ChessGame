import javax.swing.*;
import java.util.*;

abstract class Figur
{
	// Eigenschaften
	protected Schachfeld[][] alleFelder;
	protected Schachfeld feld;
	public ImageIcon icon;
	
	// Name der Figur
	public String name;
	// Position der Figur
	public Position pos;
	// Figurfarbe
	public int farbe;
	// Status ob Figur besiegt ist
	public boolean besiegt = false;
	
	// Methoden
	public Figur(String name, Position pos, int farbe, Schachfeld[][] felderTemp)
	{
		this.alleFelder = felderTemp;
		
		this.name = name;
		this.pos = pos;
		this.farbe = farbe;
		System.out.println("Figur/Figur# farbe: " + this.farbe);
	}
	
	// Figur aufs Spielfeld setzen
	public void setze(Schachfeld fTemp)
	{
		this.feld = fTemp;
	}
	// Figur bewegen
	public void bewege(Position pos, Schachfeld feldAlt, Schachfeld feldNeu)
	{
		if(feldNeu.figur != null)
		{
			feldNeu.figur.besiege();
		}
		
		this.setze(feldNeu);
		feldAlt.loescheFigur();
		System.out.println("Figur/bewege # Buchstabe: " + pos.buchstabe + " Zahl: " + pos.zahl);
		this.pos = pos;
		this.alleFelder[this.pos.buchstabe][this.pos.zahl].figur = this;
		this.feld.setzeFigur(this);
	}
	// Figur besiegen
	public void besiege()
	{
		this.besiegt = true;
		Spiel.getInstance().gegnerischerSpieler().schachfiguren.remove(this);
		this.feld.loescheFigur();
	}
	// Mögl. Züge anzeigen
	public abstract List<Position> zuege();
	
	protected int zugrichtung(int wert)
	{
		System.out.println("Figur/zugrichttung # farbe: " + this.farbe);
		if(this.farbe == 1)
		{
			return wert;
		}
		else
		{
			return -wert;
		}
	}
}