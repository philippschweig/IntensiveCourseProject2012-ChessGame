public class Position
{
	// Eigenschaften
	// Wert der Zahl auf dem Schachbrett
	// 1 - 8
	public int zahl;
	// Wert des Buchstaben auf dem Schachbrett
	// 1 - 8 (A - H)
	public int buchstabe;
	
	// Konstruktor
	public Position()
	{
	}
	
	public Position(int b, int z)
	{
		this.set(b, z);
	}
	
	// Methoden
	public void set(int b, int z)
	{
		this.zahl = z;
		this.buchstabe = b;
	}
}