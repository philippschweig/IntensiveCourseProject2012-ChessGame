import javax.swing.*;
import java.util.*;

public class F_Laeufer extends Figur
{
	// Eigenschaften
	
	// Methoden
	public F_Laeufer(String name, Position pos, int farbe, Schachfeld[][] felderTemp)
	{
		super(name, pos, farbe, felderTemp);
		
		if(this.farbe == 0)
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Laeufer/Laeufer.black.gif"));
		}
		else
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Laeufer/Laeufer.white.gif"));
		}
	}
	
	// Mögl. Züge anzeigen
	public List<Position> zuege()
	{
		List<Position> moeglichePositionen = new ArrayList<Position>();
		
		// Laufzüge
		// nach oben rechts
		for(int x = this.pos.zahl + 1, y = this.pos.buchstabe - 1; x <= 8 && y >= 1; x++, y--)
		{
			System.out.println("F_Laeufer/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Laeufer/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Laeufer/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Laeufer/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Laeufer/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach oben links
		for(int x = this.pos.zahl - 1, y = this.pos.buchstabe - 1; x >= 1 && y >= 1; x--, y--)
		{
			System.out.println("F_Laeufer/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Laeufer/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Laeufer/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Laeufer/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Laeufer/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach unten rechts
		for(int x = this.pos.zahl + 1, y = this.pos.buchstabe + 1; x <= 8 && y <= 8; x++, y++)
		{
			System.out.println("F_Laeufer/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Laeufer/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Laeufer/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Laeufer/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Laeufer/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		// nach unten links
		for(int x = this.pos.zahl - 1, y = this.pos.buchstabe + 1; x >= 1 && y <= 8; x--, y++)
		{
			System.out.println("F_Laeufer/zuege # x: " + x + " y: " + y);
			if(this.alleFelder[x][y].figur != null)
			{
				System.out.println("F_Laeufer/zuege # figur != null");
				if(this.alleFelder[x][y].figur.farbe != this.farbe)
				{
					System.out.println("F_Laeufer/zuege # figur.farbe != this.farbe");
					moeglichePositionen.add( new Position(x, y, true) );
					break;
				}
				else
				{
					System.out.println("F_Laeufer/zuege # figur.farbe == this.farbe");
					break;
				}
			}
			else
			{
				System.out.println("F_Laeufer/zuege # figur == null");
				moeglichePositionen.add( new Position(x, y, false) );
			}
		}
		
		return moeglichePositionen;
	}
}