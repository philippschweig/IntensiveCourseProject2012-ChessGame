public class Spiel implements IKoenig
{
	// Globale Instanz
	private static Spiel instance = null;
	public static Spiel getInstance()
	{
		return instance;
	}
	
	public static void setInstance(Schachbrett bTemp, IGameCallback c, String s1, String s2)
	{
		instance = new Spiel(bTemp, s1, s2);
		instance.callback = c;
	}
	
	// Eigenschaften
	private Schachbrett b;
	private IGameCallback callback;
	
	public Spieler s1;
	public Spieler s2;
	
	private int aktuellerSpieler = 2;
	private boolean ende = false;
	
	// Konstruktor
	private Spiel(Schachbrett bTemp, String s1, String s2)
	{
		this.b = bTemp;
		
		this.s1 = new Spieler(s1, 0, this.b, this);
		this.s2 = new Spieler(s2, 1, this.b, this);
	}
	
	// IKoenig
	public void SchachMatt(Object o)
	{
		this.ende = true;
	}
	// IKoenig
	
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
		if(!this.ende)
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
		else
		{
			this.callback.GameOver(gegnerischerSpieler());
		}
	}
	
	public void starten()
	{
		aktuellerSpieler().aktiviereZug();
	}
	
	private void beenden()
	{
		
	}
}