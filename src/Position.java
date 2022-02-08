import java.util.*;

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
	
	// Konstruktoren
	public Position()
	{
	}
	
	public Position(int z, int b)
	{
		this.set(z, b);
	}
	
	public Position(int z, int b, boolean a)
	{
		this.set(z, b, a);
	}
	
	// Methoden
	public void set(int z, int b)
	{
		this.buchstabe = b;
		this.zahl = z;
	}
	
	public void set(int z, int b, boolean a)
	{
		this.set(z, b);
		this.angriff = a;
		this.spielzug = true;
	}
	
	public static boolean pruefeObPosInListVorhanden(List<Position> poslist, Position pos)
	{
		for(int x = 0; x < poslist.size(); x++)
		{
			if(poslist.get(x).buchstabe == pos.buchstabe && poslist.get(x).zahl == pos.zahl)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static void debugPositionList(List<Position> poslist)
	{
		System.out.println("Position/debugPositionList #");
		for(int x = 0; x < poslist.size(); x++)
		{
			System.out.println("-------------------------- # ID: " + x);
			System.out.println("************************** # Buchstabe: " + poslist.get(x).buchstabe);
			System.out.println("************************** # Zahl: " + poslist.get(x).zahl);
			System.out.println("************************** # Angriff: " + poslist.get(x).angriff);
			System.out.println("************************** # Spielzug: " + poslist.get(x).spielzug);
		}
	}
}