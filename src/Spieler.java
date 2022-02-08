import java.util.*;

public class Spieler
{
	// Eigenschaften
	private Schachbrett b;
	
	public String name;
	// farbe: 0 - Schwarz, 1 - Weiﬂ
	private int farbe;
	public List<Figur> schachfiguren = new ArrayList<Figur>();
	
	// Konstruktor
	public Spieler(String name, int farbe, Schachbrett bTemp)
	{
		this.b = bTemp;
		this.name = name;
		this.farbe = farbe;
		this.ladeFiguren();
		this.setzeFiguren();
	}
	
	// Methoden
	private void ladeFiguren()
	{
		// Schwarze Figuren
		if(this.farbe == 0)
		{
			// Bauernreihen
			for(int i = 1; i < 9; i++)
			{
				//this.schachfiguren.add( new Schachfigur("Bauer " + i, new Position(7,i), 0, this.farbe, this.b) );
				this.schachfiguren.add( new F_Bauer("Bauer " + i, new Position(7,i), this.farbe, this.b.felder) );
			}
			
			// Dame
			//this.schachfiguren.add( new F_Dame("Dame", new Position(8,4), this.farbe, this.b.felder) );
		}
		// Weiﬂe Figuren
		else
		{
			// Bauernreihe
			for(int i = 1; i < 9; i++)
			{
				//this.schachfiguren.add( new Schachfigur("Bauer " + i, new Position(2,i), this.farbe, this.b) );
				this.schachfiguren.add( new F_Bauer("Bauer " + i, new Position(2,i), this.farbe, this.b.felder) );
			}
			
			// Dame
			//this.schachfiguren.add( new F_Dame("Dame", new Position(1,4), this.farbe, this.b.felder) );
		}
	}
	
	private void setzeFiguren()
	{
		this.b.setzeFiguren(this.schachfiguren);
		this.b.alleFelderDeaktivieren();
	}
	
	public void aktiviereZug()
	{
		//Spieler.debugFiguren(this.schachfiguren);
		this.b.figurenAktivieren(this.schachfiguren);
	}
	
	public static void debugFiguren(java.util.List<Figur> figuren)
	{
		for(int x = 0; x < figuren.size(); x++)
		{
			System.out.println("Spieler/debugFiguren # Name: " + figuren.get(x).name);
			System.out.println("******************** # Farbe: " + figuren.get(x).farbe);
			System.out.println("******************** # Besiegt: " + figuren.get(x).besiegt);
			System.out.println("******************** # Position: Buchstabe " + figuren.get(x).pos.buchstabe + ", Zahl " + figuren.get(x).pos.zahl);
		}
	}
}