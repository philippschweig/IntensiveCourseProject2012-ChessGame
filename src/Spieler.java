import java.util.*;

public class Spieler
{
	// Eigenschaften
	private Schachbrett b;
	
	public String name;
	// farbe: 0 - Schwarz, 1 - Wei�
	private int farbe;
	public List<Figur> schachfiguren = new ArrayList<Figur>();
	
	// Konstruktor
	public Spieler(String name, int farbe, Schachbrett bTemp, IKoenig c)
	{
		this.b = bTemp;
		this.name = name;
		this.farbe = farbe;
		this.ladeFiguren(c);
		this.setzeFiguren();
	}
	
	// Methoden
	private void ladeFiguren(IKoenig c)
	{
		// Schwarze Figuren
		if(this.farbe == 0)
		{
			// Bauernreihen
			for(int i = 1; i < 9; i++)
			{
				//this.schachfiguren.add( new Schachfigur("Bauer " + i, new Position(7,i), 0, this.farbe, this.b) );
				this.schachfiguren.add( new F_Bauer("Bauer " + i, new Position(7,i), this.farbe, this.b.felder) );
			}
			
			// Turm
			this.schachfiguren.add( new F_Turm("Turm", new Position(8,1), this.farbe, this.b.felder) );
			this.schachfiguren.add( new F_Turm("Turm", new Position(8,8), this.farbe, this.b.felder) );
			
			// Springer
			this.schachfiguren.add( new F_Springer("Springer", new Position(8,2), this.farbe, this.b.felder) );
			this.schachfiguren.add( new F_Springer("Springer", new Position(8,7), this.farbe, this.b.felder) );
			
			// L�ufer
			this.schachfiguren.add( new F_Laeufer("L�ufer", new Position(8,3), this.farbe, this.b.felder) );
			this.schachfiguren.add( new F_Laeufer("L�ufer", new Position(8,6), this.farbe, this.b.felder) );
			
			// Dame
			this.schachfiguren.add( new F_Dame("Dame", new Position(8,4), this.farbe, this.b.felder) );
			
			// K�nig
			this.schachfiguren.add( new F_Koenig("K�nig", new Position(8,5), this.farbe, this.b.felder, c) );
		}
		// Wei�e Figuren
		else
		{
			// Bauernreihe
			for(int i = 1; i < 9; i++)
			{
				//this.schachfiguren.add( new Schachfigur("Bauer " + i, new Position(2,i), this.farbe, this.b) );
				this.schachfiguren.add( new F_Bauer("Bauer " + i, new Position(2,i), this.farbe, this.b.felder) );
			}
			
			// Turm
			this.schachfiguren.add( new F_Turm("Turm", new Position(1,1), this.farbe, this.b.felder) );
			this.schachfiguren.add( new F_Turm("Turm", new Position(1,8), this.farbe, this.b.felder) );
			
			// Springer
			this.schachfiguren.add( new F_Springer("Springer", new Position(1,2), this.farbe, this.b.felder) );
			this.schachfiguren.add( new F_Springer("Springer", new Position(1,7), this.farbe, this.b.felder) );
			
			// L�ufer
			this.schachfiguren.add( new F_Laeufer("L�ufer", new Position(1,3), this.farbe, this.b.felder) );
			this.schachfiguren.add( new F_Laeufer("L�ufer", new Position(1,6), this.farbe, this.b.felder) );
			
			// Dame
			this.schachfiguren.add( new F_Dame("Dame", new Position(1,4), this.farbe, this.b.felder) );
			
			// K�nig
			this.schachfiguren.add( new F_Koenig("Koenig", new Position(1,5), this.farbe, this.b.felder, c) );
		}
	}
	
	private void setzeFiguren()
	{
		this.b.setzeFiguren(this.schachfiguren);
		this.b.alleFelderDeaktivieren();
	}
	
	public void aktiviereZug()
	{
		boolean schachmatt = false;
		/*F_Koenig koenig = (F_Koenig)Figur.getFromList(this.schachfiguren);
		List<Position> koenigZuege = koenig.zuege();
		
		if(koenigZuege.size() > 0)
		{
			// Auf Schach bzw. Schach-Matt pr�fen # start			
			List<Position> gegnerZuege = Spiel.getInstance().gegnerischerSpieler().alleMoeglichenZuege();
			
			// Pr�fen, ob der K�nig im Schach bzw. Schach-Matt steht
			boolean schach[] = new boolean[koenigZuege.size()];
			
			for(int x = 0; x < koenigZuege.size(); x++)
			{
				for(int y = 0; y < gegnerZuege.size(); y++)
				{
					if(koenigZuege.get(x) == gegnerZuege.get(y))
					{
						schach[x] = true;
					}
				}
			}
			
			// Pr�fen, ob Schach-Matt
			schachmatt = true;
			for(int y = 0, z = 0; y < schach.length; y++)
			{
				if(!schach[y])
				{
					schachmatt = false;
					break;
				}
			}
		}*/
		
		if(!schachmatt)
		{
			//Spieler.debugFiguren(this.schachfiguren);
			System.out.println("Spieler/aktiviereZug # *******************************************");
			this.b.figurenAktivieren(this.schachfiguren);
		}
		// Auf Schach bzw. Schach-Matt pr�fen # ende
	}
	
	public List<Position> alleMoeglichenZuege()
	{
		List<Position> zuege = new ArrayList<Position>();
		
		// Alle Figuren durchgehen
		for(int i = 0; i < Spiel.getInstance().gegnerischerSpieler().schachfiguren.size(); i++)
		{
			zuege.addAll(Spiel.getInstance().gegnerischerSpieler().schachfiguren.get(i).zuege());
		}
		
		// Doppelte Eintr�ge l�schen
		HashSet<Position> hashSet = new HashSet<Position>(zuege);
		zuege.clear();
		zuege.addAll(hashSet);
		
		// Alle Angriffsz�ge rausfiltern
		/*for(int b = 0; b < zuege.size(); b++)
		{
			if(!zuege.get(b).angriff)
			{
				zuege.remove(b);
				b--;
			}
		}*/
		
		Position.debugPositionList(zuege);
		
		return zuege;
	}
	
	public static void debugFiguren(java.util.List<Figur> figuren)
	{
		for(int x = 0; x < figuren.size(); x++)
		{
			System.out.println("Spieler/debugFiguren # Name: " + figuren.get(x).name);
			System.out.println("******************** # Farbe: " + figuren.get(x).farbe);
			System.out.println("******************** # Besiegt: " + figuren.get(x).besiegt);
			System.out.println("******************** # Position: zahl " + figuren.get(x).pos.zahl + ", buchstabe " + figuren.get(x).pos.buchstabe);
		}
	}
}