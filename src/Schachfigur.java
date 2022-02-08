public class Schachfigur
{
	// Eigenschaften
	private int figurart;
	
	private F_Bauer bauer = null;
	private F_Dame dame = null;
	//private F_Koenig koenig = null;
	//private F_Laeufer laeufer = null;
	//private F_Springer springer = null;
	//private F_Turm turm = null;
	
	// Konstruktor
	/* Figurarten:
			0: Bauer
			1: Dame
			2: König
			3: Läufer
			4: Springer
			5: Turm
	*/
	public Schachfigur(String name, Position pos, int figurart)
	{	
		this.figurart = figurart;
		
		switch(this.figurart)
		{
			case 0:
				bauer = new F_Bauer(name, pos);
				break;
			case 1:
				dame = new F_Dame(name, pos);
				break;
			/*case 2:
				koenig = new F_Koenig(name, pos);
				break;
			case 3:
				laeufer = new F_Laeufer(name, pos);
				break;
			case 4:
				springer = new F_Springer(name, pos);
				break;
			case 5:
				turm = new F_Turm(name, pos);
				break;*/
		}
	}
	
	// Methoden
	public String getName()
	{
		switch(this.figurart)
		{
			case 0:
				return this.bauer.name;
			case 1:
				return this.dame.name;
			/*case 2:
				return this.koenig.name;
				break;
			case 3:
				return this.laeufer.name;
				break;
			case 4:
				return this.springer.name;
				break;
			case 5:
				return this.turm.name;
				break;*/
			default:
				return "fehlerhaft";
		}	
	}
	
	// Figur bewegen
	private void bewege()
	{
		switch(this.figurart)
		{
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
		}
	}
	
	// Mögl. Züge anzeigen
	public void zuege()
	{
		switch(this.figurart)
		{
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
		}
	}
	
	public Position getPosition()
	{
		switch(this.figurart)
		{
			case 0:
				return this.bauer.pos;
			case 1:
				return this.dame.pos;
			/*case 2:
				return;
			case 3:
				return;
			case 4:
				return;
			case 5:
				return;*/
			default:
				return new Position(1,1);
		}
	}
}