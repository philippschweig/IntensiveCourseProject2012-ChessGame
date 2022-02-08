public class Spiel
{
	// Eigenschaften
	private Schachbrett b;
	
	public Spieler s1;
	public Spieler s2;
	
	
	// Konstruktor
	public Spiel(Schachbrett bTemp)
	{
		this.b = bTemp;
		
		s1 = new Spieler("Spieler 1", 0, this.b);
		s2 = new Spieler("Spieler 2", 1, this.b);
	}
	
	// Methoden
}