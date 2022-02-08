public class Position
{
	// Eigenschaften
	// Wert des Buchstaben auf dem Schachbrett
	// 1 - 8 (A - H)
	public int buchstabe;
	// Wert der Zahl auf dem Schachbrett
	// 1 - 8
	public int zahl;
	
	public boolean angriff = false;
	public boolean spielzug = false;
	
	// Konstruktor
	public Position()
	{
	}
	
	public Position(int b, int z)
	{
		this.set(b, z);
	}
	
	public Position(int b, int z, boolean a)
	{
		this.set(b, z, a);
	}
	
	// Methoden
	public void set(int b, int z)
	{
		this.buchstabe = z;
		this.zahl = b;
	}
	
	public void set(int b, int z, boolean a)
	{
		this.buchstabe = z;
		this.zahl = b;
		this.angriff = a;
		this.spielzug = true;
	}
}