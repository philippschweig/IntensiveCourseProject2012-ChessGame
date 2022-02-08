import javax.swing.*;
import java.util.*;
import java.lang.reflect.*;

public class F_Bauer extends Figur
{
	// Eigenschaften
	private boolean ersterZug;
	
	// Figurentausch-Callback
	private IBauer callback_ch;
	
	// Methoden
	public F_Bauer(String name, Position pos, int farbe, Schachfeld[][] felderTemp, IBauer c)
	{
		super(name, pos, farbe, felderTemp);
		
		this.callback_ch = c;
		
		if(this.farbe == 0)
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Bauer/Bauer.black.gif"));
		}
		else
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Bauer/Bauer.white.gif"));
		}
		
		this.ersterZug = true;
	}
	
	// Figur bewegen
	public void bewege(Position pos, Schachfeld feldAlt, Schachfeld feldNeu)
	{
		if(ersterZug)
		{
			this.ersterZug = false;
		}
		
		super.bewege(pos, feldAlt, feldNeu);
		
		if(pos.zahl == 1 || pos.zahl == 8)
		{
			// Figurauswahl
			String classString = this.callback_ch.Tausche();
			
			try
			{
				Class fclass = Class.forName("F_" + classString);
				
				Constructor c = fclass.getConstructor(
					new Class[] {String.class, Position.class, int.class, Schachfeld[][].class}
				);
				
				this.austauschen();
			
				Object[] arguments = new Object[] {classString, pos, this.farbe, this.alleFelder};
				Figur f = (Figur)c.newInstance(arguments);
				
				Spiel.getInstance().aktuellerSpieler().schachfiguren.add(f);
				feldNeu.setzeFigur(f);
			}
			catch(ClassNotFoundException e) {}
			catch(NoSuchMethodException e) {}
			catch(InstantiationException e) {}
			catch(IllegalAccessException e) {}
			catch(InvocationTargetException e) {}
		}
	}
	
	// Mögl. Züge anzeigen
	public List<Position> zuege()
	{
		List<Position> moeglichePositionen = new ArrayList<Position>();
		
		// Laufzüge
		if(this.ersterZug)
		{
			System.out.println("F_Bauer/zuege # zahl: " + this.pos.zahl + " buchstabe: " + this.pos.buchstabe);
			// Prüft ob dort eine Figur steht
			if(this.alleFelder[this.pos.zahl + this.zugrichtung(1)][this.pos.buchstabe].figur == null)
			{
				if(this.alleFelder[this.pos.zahl + this.zugrichtung(2)][this.pos.buchstabe].figur == null)
				{
					moeglichePositionen.add( new Position(this.pos.zahl + this.zugrichtung(2), this.pos.buchstabe, false) );
				}
				
			}
		}
		
		// Schwarze Figuren
		if(this.farbe == 0)
		{
			// Position nicht am Ende und keine Figur im Weg
			if(this.pos.zahl > 1 && this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe].figur == null)
			{
				moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe, false) );
			}
		}
		// Weiße Figuren
		else
		{
			// Position nicht am Ende und keine Figur im Weg
			if(this.pos.zahl < 8 && this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe].figur == null)
			{
				moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe, false) );
			}
		}
		
		// Angriffszüge
		// Schwarze Figuren
		if(this.farbe == 0)
		{
			if(this.pos.zahl > 1)
			{
				if(this.pos.buchstabe > 1 && this.pos.buchstabe < 8)
				{
					// Prüft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe + 1].figur != null)
					{
						// Prüft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe + 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe + 1, true) );
						}
					}
					
					// Prüft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe - 1].figur != null)
					{
						// Prüft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe - 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe - 1, true) );
						}
					}
				}
				else if(this.pos.buchstabe == 1)
				{
					// Prüft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe + 1].figur != null)
					{
						// Prüft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe + 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe + 1, true) );
						}
					}
				}
				else if(this.pos.buchstabe == 8)
				{
					// Prüft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe - 1].figur != null)
					{
						// Prüft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe - 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe - 1, true) );
						}
					}
				}
			}
		}
		// Weiße Figuren
		else
		{
			if(this.pos.zahl < 8)
			{
				if(this.pos.buchstabe > 1 && this.pos.buchstabe < 8)
				{
					// Prüft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe + 1].figur != null)
					{
						// Prüft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe + 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe + 1, true) );
						}
					}
					
					// Prüft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe - 1].figur != null)
					{
						// Prüft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe - 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe - 1, true) );
						}
					}
				}
				else if(this.pos.buchstabe == 1)
				{
					// Prüft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe + 1].figur != null)
					{
						// Prüft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe + 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe + 1, true) );
						}
					}
				}
				else if(this.pos.buchstabe == 8)
				{
					// Prüft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe - 1].figur != null)
					{
						// Prüft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe - 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe - 1, true) );
						}
					}
				}
			}
		}
		
		return moeglichePositionen;
	}
}