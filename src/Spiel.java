public class Spiel
{
	// Eigenschaften
	private Schachbrett b;
	
	public Spieler s1;
	public Spieler s2;
	
	private int aktuellerSpieler = 1;
	
	
	// Konstruktor
	public Spiel(Schachbrett bTemp)
	{
		this.b = bTemp;
		
		s1 = new Spieler("Spieler 1", 0, this.b);
		s2 = new Spieler("Spieler 2", 1, this.b);
	}
	
	// Methoden
	public Spieler aktuellerSpeiler()
	{
		if(aktuellerSpieler == 1)
		{
			return s1;
		}
		else
		{
			return s2;
		}
	}
	
	public void wechseleSpieler()
	{
		if(aktuellerSpieler == 1)
		{
			aktuellerSpieler = 2;
		}
		else
		{
			aktuellerSpieler = 1;
		}
	}
}