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
		this.ladeFiguren();
		this.setzeFiguren();
	}
	
	private void ladeFiguren()
	{
		for(int i = 1; i < 9; i++)
		{
			this.schachfiguren.add( new Schachfigur("Bauer " + i, 0) );
			this.b.felder[2][i].setzeFigur(this.schachfiguren.get(i - 1));
		}
	}
	
	private void setzeFiguren()
	{
		if(this.farbe == 0)
		{
			
		}
	}
	
	// Methoden
}