public class Schachfigur
{
	// Eigenschaften
	private int figurart;
	
	private F_Bauer bauer = null;
	//private F_Dame dame = null;
	//private F_Koenig koenig = null;
	//private F_Laeufer laeufer = null;
	//private F_Springer springer = null;
	//private F_Turm turm = null;
	
	private boolean besiegt = false;
	
	// Konstruktor
	/* Figurarten:
			0: Bauer
			1: Dame
			2: König
			3: Läufer
			4: Springer
			5: Turm
	*/
	public Schachfigur(String name, int figurart)
	{	
		this.figurart = figurart;
		
		switch(this.figurart)
		{
			case 0:
				bauer = new F_Bauer(name);
				break;
			/*case 1:
				dame = new F_Dame(name);
				break;
			case 2:
				koenig = new F_Koenig(name);
				break;
			case 3:
				laeufer = new F_Laeufer(name);
				break;
			case 4:
				springer = new F_Springer(name);
				break;
			case 5:
				turm = new F_Turm(name);
				break;*/
		}
	}
	
	// Methoden
	public String getName()
	{
		switch(this.figurart)
		{
			case 0:
				return bauer.name;
			default:
				return "fehlerhaft";
			/*case 1:
				dame = new F_Dame(name);
				break;
			case 2:
				koenig = new F_Koenig(name);
				break;
			case 3:
				laeufer = new F_Laeufer(name);
				break;
			case 4:
				springer = new F_Springer(name);
				break;
			case 5:
				turm = new F_Turm(name);
				break;*/
		}	
	}
	
	// Figur bewegen
	private void bewege() {}
	// Mögl. Züge anzeigen
	public void zuege() {}
}