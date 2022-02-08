public class GUIObjektDaten
{
	// Eigenschaften
	public Koordinaten punkt;
	public int x()
	{
		return punkt.x;
	}
	public void x(int x)
	{
		this.punkt.x = x;
	}
	public int y()
	{
		return punkt.y;
	}
	public void y(int y)
	{
		this.punkt.y = y;
	}
	
	public int breite, hoehe;
	
	// Konstruktoren
	public GUIObjektDaten(int xweite, int yweite)
	{
		this(0, 0, xweite, yweite);
	}
	
	public GUIObjektDaten(int x, int y, int xweite, int yweite)
	{
		this(new Koordinaten(x,y), xweite, yweite);
	}
	
	public GUIObjektDaten(Koordinaten cords, int xweite, int yweite)
	{
		this.punkt = cords;
		this.breite = xweite;
		this.hoehe = yweite;
	}
	
	// Methoden
	// liefert ein Int
	public static int zentriertX(int frameWidth, int objektBreite)
	{
		int frameL = frameWidth / 2;
		int objektL = objektBreite / 2;
		int zentriertL = frameL - objektL;
		
		return zentriertL;
	}
	
	public static int zentriertY(int frameHeight, int objektHoehe)
	{
		return 0;
	}
	
	// liefert ein Punkt
	public static Koordinaten zentriert(int frameWidth, int frameHeight, int objektBreite, int objektHoehe)
	{
		return new Koordinaten();
	}
}