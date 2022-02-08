import javax.swing.*;
import java.util.*;

public class F_Turm extends Figur
{
	// Eigenschaften
	public boolean ersterZug;
	
	// Methoden
	public F_Turm(String name, Position pos, int farbe, Schachfeld[][] felderTemp)
	{
		super(name, pos, farbe, felderTemp);
		
		if(this.farbe == 0)
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Turm/Turm.black.gif"));
		}
		else
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Turm/Turm.white.gif"));
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
	
	public void rochade(boolean kleineRochade)
	{
		Position pos;
		
		if(kleineRochade) this.bewege(pos = new Position(this.pos.zahl, this.pos.buchstabe - 2), this.alleFelder[this.pos.zahl][this.pos.buchstabe], this.alleFelder[pos.zahl][pos.buchstabe]);
		else this.bewege(pos = new Position(this.pos.zahl, this.pos.buchstabe + 2), this.alleFelder[this.pos.zahl][this.pos.buchstabe], this.alleFelder[pos.zahl][pos.buchstabe]);
	}
	
	// Mögl. Züge anzeigen
	public List<Position> zuege()
	{
		List<Position> moeglichePositionen = new ArrayList<Position>();
		
		// Laufzüge
		// nach rechts
		for(int x = this.pos.zahl + 1, y = this.pos.buchstabe; x <= 8; x++)
		{
			System.out.println("F_Turm/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Turm/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Turm/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Turm/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Turm/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach links
		for(int x = this.pos.zahl - 1, y = this.pos.buchstabe; x >= 1; x--)
		{
			System.out.println("F_Turm/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Turm/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Turm/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Turm/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Turm/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach oben
		for(int x = this.pos.zahl, y = this.pos.buchstabe - 1; y >= 1; y--)
		{
			System.out.println("F_Turm/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Turm/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Turm/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Turm/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Turm/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach unten
		for(int x = this.pos.zahl, y = this.pos.buchstabe + 1; y <= 8; y++)
		{
			System.out.println("F_Turm/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Turm/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Turm/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Turm/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Turm/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		return moeglichePositionen;
	}
}