import javax.swing.*;
import java.util.*;

public class F_Springer extends Figur
{
	// Eigenschaften
	
	// Methoden
	public F_Springer(String name, Position pos, int farbe, Schachfeld[][] felderTemp)
	{
		super(name, pos, farbe, felderTemp);
		
		if(this.farbe == 0)
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Springer/Springer.black.gif"));
		}
		else
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Springer/Springer.white.gif"));
		}
	}
	
	// Mögl. Züge anzeigen
	public List<Position> zuege()
	{
		List<Position> moeglichePositionen = new ArrayList<Position>();
		
		// Laufzüge
		// oben links
		if(this.pos.zahl > 1 && this.pos.buchstabe > 2)
		{
			if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe - 2].figur != null)
			{
				if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe - 2].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe - 2, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe - 2, false) );
			}
		}
		
		// oben rechts
		if(this.pos.zahl < 8 && this.pos.buchstabe > 2)
		{
			if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe - 2].figur != null)
			{
				if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe - 2].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe - 2, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe - 2, false) );
			}
		}
		
		// rechts oben
		if(this.pos.zahl < 7 && this.pos.buchstabe > 1)
		{
			if(this.alleFelder[this.pos.zahl + 2][this.pos.buchstabe - 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl + 2][this.pos.buchstabe - 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl + 2, this.pos.buchstabe - 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl + 2, this.pos.buchstabe - 1, false) );
			}
		}
		
		// rechts unten
		if(this.pos.zahl < 7 && this.pos.buchstabe < 8)
		{
			if(this.alleFelder[this.pos.zahl + 2][this.pos.buchstabe + 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl + 2][this.pos.buchstabe + 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl + 2, this.pos.buchstabe + 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl + 2, this.pos.buchstabe + 1, false) );
			}
		}
		
		// unten rechts
		if(this.pos.zahl < 8 && this.pos.buchstabe < 7)
		{
			if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe + 2].figur != null)
			{
				if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe + 2].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe + 2, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe + 2, false) );
			}
		}
		
		// unten links
		if(this.pos.zahl > 1 && this.pos.buchstabe < 7)
		{
			if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe + 2].figur != null)
			{
				if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe + 2].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe + 2, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe + 2, false) );
			}
		}
		
		// links oben
		if(this.pos.zahl > 2 && this.pos.buchstabe > 1)
		{
			if(this.alleFelder[this.pos.zahl - 2][this.pos.buchstabe - 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl - 2][this.pos.buchstabe - 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl - 2, this.pos.buchstabe - 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl - 2, this.pos.buchstabe - 1, false) );
			}
		}
		
		// links unten
		if(this.pos.zahl > 2 && this.pos.buchstabe < 8)
		{
			if(this.alleFelder[this.pos.zahl - 2][this.pos.buchstabe + 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl - 2][this.pos.buchstabe + 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl - 2, this.pos.buchstabe + 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl - 2, this.pos.buchstabe + 1, false) );
			}
		}
		
		return moeglichePositionen;
	}
}