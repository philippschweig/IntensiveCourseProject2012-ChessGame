import java.util.*;

public class F_Dame extends Figur
{
	// Eigenschaften
	
	// Konstruktor
	public F_Dame(String name, Position pos, int farbe, Schachfeld[][] felderTemp)
	{
		super(name, pos, farbe, felderTemp);
	}
	
	// Methoden
	// Mögl. Züge anzeigen
	public List<Position> zuege()
	{
		List<Position> moeglichePositionen = new ArrayList<Position>();
		
		//moeglichePositionen.add( new Position(this.pos.buchstabe + 2, this.pos.zahl) );
		
		return moeglichePositionen;
	}
}