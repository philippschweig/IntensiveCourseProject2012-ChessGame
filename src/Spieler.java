import java.util.*;

public class Spieler
{
	// Eigenschaften
	public String name;
	public List<Schachfigur> schachfiguren = new ArrayList<Schachfigur>();
	
	// Konstruktor
	public Spieler(String name)
	{
		this.name = name;
		this.ladeFiguren();
	}
	
	private void ladeFiguren()
	{
		for(int i = 1; i < 9; i++)
		{
			this.schachfiguren.add( new Schachfigur("Bauer " + i, 0) );
		}
	}
	
	// Methoden
}