abstract class Figur
{
	// Eigenschaften
	// Name einer Figur
	public String name;
	public Position pos;
	public boolean besiegt = false;
	
	// Methoden
	public Figur(String name, Position pos)
	{
		this.name = name;
		this.pos = pos;
	}
	
	// Figur bewegen
	public abstract void bewege();
	
	// Mögl. Züge anzeigen
	public abstract void zuege();
}