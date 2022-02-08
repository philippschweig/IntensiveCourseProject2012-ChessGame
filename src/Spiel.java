public class Spiel
{
	// Globale Instanz
	private static Spiel instance = null;
	public static Spiel getInstance()
	{
		return instance;
	}
	
	public static void setInstance(Schachbrett bTemp)
	{
		if(instance == null)
		{
			instance = new Spiel(bTemp);
		}
	}
	
	// Eigenschaften
	private Schachbrett b;
	
	public Spieler s1;
	public Spieler s2;
	
	private int aktuellerSpieler = 2;
	
	// Konstruktor
	private Spiel(Schachbrett bTemp)
	{
		this.b = bTemp;
		
		s1 = new Spieler("Spieler 1", 0, this.b);
		s2 = new Spieler("Spieler 2", 1, this.b);
	}
	
	// Methoden
	public Spieler aktuellerSpieler()
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
	
	public Spieler gegnerischerSpieler()
	{
		if(aktuellerSpieler == 1)
		{
			return s2;
		}
		else
		{
			return s1;
		}
	}
	
	public void spielerwechsel()
	{
		if(aktuellerSpieler == 1)
		{
			aktuellerSpieler = 2;
		}
		else
		{
			aktuellerSpieler = 1;
		}
		
		aktuellerSpieler().aktiviereZug();
	}
	
	public void starten()
	{
		aktuellerSpieler().aktiviereZug();
	}
}