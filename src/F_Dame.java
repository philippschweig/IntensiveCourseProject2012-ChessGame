import javax.swing.*;
import java.util.*;

public class F_Dame extends Figur
{
	// Eigenschaften
	
	// Konstruktor
	public F_Dame(String name, Position pos, int farbe, Schachfeld[][] felderTemp)
	{
		super(name, pos, farbe, felderTemp);
		
		if(this.farbe == 0)
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Dame/Dame.black.gif"));
		}
		else
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Dame/Dame.white.gif"));
		}
	}
	
	// Methoden
	// Mögl. Züge anzeigen
	public List<Position> zuege()
	{
		List<Position> moeglichePositionen = new ArrayList<Position>();
		
		// Laufzüge
		// Diagonal
		// nach oben rechts
		for(int x = this.pos.zahl + 1, y = this.pos.buchstabe - 1; x <= 8 && y >= 1; x++, y--)
		{
			System.out.println("F_Dame/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Dame/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Dame/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Dame/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Dame/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach oben links
		for(int x = this.pos.zahl - 1, y = this.pos.buchstabe - 1; x >= 1 && y >= 1; x--, y--)
		{
			System.out.println("F_Dame/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Dame/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Dame/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Dame/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Dame/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach unten rechts
		for(int x = this.pos.zahl + 1, y = this.pos.buchstabe + 1; x <= 8 && y <= 8; x++, y++)
		{
			System.out.println("F_Dame/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Dame/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Dame/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Dame/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Dame/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach unten links
		for(int x = this.pos.zahl - 1, y = this.pos.buchstabe + 1; x >= 1 && y <= 8; x--, y++)
		{
			System.out.println("F_Dame/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Dame/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Dame/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Dame/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Dame/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// Vertikal und Horizontal
		// nach rechts
		for(int x = this.pos.zahl + 1, y = this.pos.buchstabe; x <= 8; x++)
		{
			System.out.println("F_Dame/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Dame/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Dame/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Dame/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Dame/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach links
		for(int x = this.pos.zahl - 1, y = this.pos.buchstabe; x >= 1; x--)
		{
			System.out.println("F_Dame/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Dame/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Dame/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Dame/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Dame/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach oben
		for(int x = this.pos.zahl, y = this.pos.buchstabe - 1; y >= 1; y--)
		{
			System.out.println("F_Dame/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Dame/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Dame/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Dame/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Dame/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach unten
		for(int x = this.pos.zahl, y = this.pos.buchstabe + 1; y <= 8; y++)
		{
			System.out.println("F_Dame/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Dame/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Dame/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Dame/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Dame/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		return moeglichePositionen;
	}
}