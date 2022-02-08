import javax.swing.*;
import java.util.*;

public class F_Bauer extends Figur
{
	// Eigenschaften
	private boolean ersterZug;
	
	// Methoden
	public F_Bauer(String name, Position pos, int farbe, Schachfeld[][] felderTemp)
	{
		super(name, pos, farbe, felderTemp);
		
		if(this.farbe == 0)
		{
			this.icon = new ImageIcon("./Images/Bauer.black.gif");
		}
		else
		{
			this.icon = new ImageIcon("./Images/Bauer.white.gif");
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
	}
	
	// M�gl. Z�ge anzeigen
	public List<Position> zuege()
	{
		List<Position> moeglichePositionen = new ArrayList<Position>();
		
		// Laufz�ge
		if(this.ersterZug)
		{
			System.out.println("F_Bauer/zuege # Buchstabe: " + this.pos.buchstabe + " Zahl: " + this.pos.zahl);
			// Pr�ft ob dort eine Figur steht
			if((this.alleFelder[this.pos.buchstabe + this.zugrichtung(1)][this.pos.zahl].figur == null) && (this.alleFelder[this.pos.buchstabe + this.zugrichtung(2)][this.pos.zahl].figur == null))
			{
				moeglichePositionen.add( new Position(this.pos.buchstabe + this.zugrichtung(1), this.pos.zahl) );
				moeglichePositionen.add( new Position(this.pos.buchstabe + this.zugrichtung(2), this.pos.zahl) );
			}
		}
		else
		{
			// Schwarze Figuren
			if(this.farbe == 0)
			{
				// Position nicht am Ende und keine Figur im Weg
				if(this.pos.buchstabe > 1 && this.alleFelder[this.pos.buchstabe - 1][this.pos.zahl].figur == null)
				{
					moeglichePositionen.add( new Position(this.pos.buchstabe - 1, this.pos.zahl) );
				}
			}
			// Wei�e Figuren
			else
			{
				// Position nicht am Ende und keine Figur im Weg
				if(this.pos.buchstabe < 8 && this.alleFelder[this.pos.buchstabe + 1][this.pos.zahl].figur == null)
				{
					moeglichePositionen.add( new Position(this.pos.buchstabe + 1, this.pos.zahl) );
				}
			}
		}
		
		// Angriffsz�ge
		// Schwarze Figuren
		if(this.farbe == 0)
		{
			if(this.pos.buchstabe > 1)
			{
				if(this.pos.zahl > 1 && this.pos.zahl < 8)
				{
					// Pr�ft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.buchstabe - 1][this.pos.zahl + 1].figur != null)
					{
						// Pr�ft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.buchstabe - 1][this.pos.zahl + 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.buchstabe - 1, this.pos.zahl + 1) );
						}
					}
					
					// Pr�ft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.buchstabe - 1][this.pos.zahl - 1].figur != null)
					{
						// Pr�ft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.buchstabe - 1][this.pos.zahl - 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.buchstabe - 1, this.pos.zahl - 1) );
						}
					}
				}
				else if(this.pos.zahl == 1)
				{
					// Pr�ft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.buchstabe - 1][this.pos.zahl + 1].figur != null)
					{
						// Pr�ft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.buchstabe - 1][this.pos.zahl + 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.buchstabe - 1, this.pos.zahl + 1) );
						}
					}
				}
				else if(this.pos.zahl == 8)
				{
					// Pr�ft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.buchstabe - 1][this.pos.zahl - 1].figur != null)
					{
						// Pr�ft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.buchstabe - 1][this.pos.zahl - 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.buchstabe - 1, this.pos.zahl - 1) );
						}
					}
				}
			}
		}
		// Wei�e Figuren
		else
		{
			if(this.pos.buchstabe < 8)
			{
				if(this.pos.zahl > 1 && this.pos.zahl < 8)
				{
					// Pr�ft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.buchstabe + 1][this.pos.zahl + 1].figur != null)
					{
						// Pr�ft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.buchstabe + 1][this.pos.zahl + 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.buchstabe + 1, this.pos.zahl + 1) );
						}
					}
					
					// Pr�ft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.buchstabe + 1][this.pos.zahl - 1].figur != null)
					{
						// Pr�ft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.buchstabe + 1][this.pos.zahl - 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.buchstabe + 1, this.pos.zahl - 1) );
						}
					}
				}
				else if(this.pos.zahl == 1)
				{
					// Pr�ft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.buchstabe + 1][this.pos.zahl + 1].figur != null)
					{
						// Pr�ft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.buchstabe + 1][this.pos.zahl + 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.buchstabe + 1, this.pos.zahl + 1) );
						}
					}
				}
				else if(this.pos.zahl == 8)
				{
					// Pr�ft ob dort keine eigene Figur steht
					if(this.alleFelder[this.pos.buchstabe + 1][this.pos.zahl - 1].figur != null)
					{
						// Pr�ft ob es nicht die eigene Figur ist
						if(this.alleFelder[this.pos.buchstabe + 1][this.pos.zahl - 1].figur.farbe != this.farbe)
						{
							moeglichePositionen.add( new Position(this.pos.buchstabe + 1, this.pos.zahl - 1) );
						}
					}
				}
			}
		}
		
		return moeglichePositionen;
	}
}