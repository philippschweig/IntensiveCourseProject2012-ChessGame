import java.util.*;

public class Spieler
{
	// Eigenschaften
	private Schachbrett b;
	
	public String name;
	// farbe: 0 - Schwarz, 1 - Weiﬂ
	private int farbe;
	public List<Schachfigur> schachfiguren = new ArrayList<Schachfigur>();
	
	// Konstruktor
	public Spieler(String name, int farbe, Schachbrett bTemp)
	{
		this.b = bTemp;
		this.name = name;
		this.farbe = farbe;
		this.ladeFiguren();
		this.setzeFiguren();
	}
	
	private void ladeFiguren()
	{
		if(this.farbe == 0)
		{
			// Bauernreihe
			for(int i = 1; i < 9; i++)
			{
				this.schachfiguren.add( new Schachfigur("Bauer " + i, new Position(2,i) , 0) );
			}
			
			// Dame
			this.schachfiguren.add( new Schachfigur("Dame", new Position(1,4), 1) );
		}
		else
		{
			// Bauernreihen
			for(int i = 1; i < 9; i++)
			{
				this.schachfiguren.add( new Schachfigur("Bauer " + i, new Position(7,i), 0) );
			}
			
			// Dame
			this.schachfiguren.add( new Schachfigur("Dame", new Position(8,4), 1) );
		}
	}
	
	private void setzeFiguren()
	{
		this.b.setzeFiguren(this.schachfiguren);
	}
	
	// Methoden
}