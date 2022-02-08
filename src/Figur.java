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
	
	// Konstruktor
	public Figur(String name, Position pos, int farbe, Schachfeld[][] felderTemp)
	{
		this.alleFelder = felderTemp;
		
		this.name = name;
		this.pos = pos;
		this.farbe = farbe;
		System.out.println("Figur/Figur# farbe: " + this.farbe);
	}
	
	// Methoden
	// Neues Spielfeld referenzieren
	public void setze(Schachfeld fTemp)
	{
		this.feld = fTemp;
	}
	
	// Figur bewegen
	public void bewege(Position pos, Schachfeld feldAlt, Schachfeld feldNeu)
	{
		if(feldNeu.figur != null)
		{
			System.out.println("Figur/bewege # besiege");
			feldNeu.figur.besiege();
		}
		
		//this.setze(feldNeu);
		feldAlt.loescheFigur();
		System.out.println("Figur/bewege # zahl: " + pos.zahl + " buchstabe: " + pos.buchstabe);
		this.pos = pos;
		//this.alleFelder[this.pos.zahl][this.pos.buchstabe].figur = this;
		feldNeu.setzeFigur(this);
	}
	
	// Figur austauschen
	public void austauschen()
	{
		System.out.println("Figur/austauschen # remove");
		Spiel.getInstance().aktuellerSpieler().schachfiguren.remove(this);
		System.out.println("Figur/austauschen # loescheFigur");
		this.feld.loescheFigur();
	}
	
	// Figur besiegen
	public void besiege()
	{
		this.besiegt = true;
		System.out.println("Figur/besiege # remove");
		Spiel.getInstance().gegnerischerSpieler().schachfiguren.remove(this);
		System.out.println("Figur/besiege # loescheFigur");
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
	
	// Statische Methoden
	public static Figur getFromList(List<Figur> figuren)
	{
		Figur f = null;
		
		for(int x = 0; x < figuren.size(); x++)
		{
			if(figuren.get(x) instanceof F_Koenig)
			{
				return figuren.get(x);
			}
		}
		
		return f;
	}
}