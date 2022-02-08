import javax.swing.*;
import java.util.*;

public class F_Koenig extends Figur
{
	// Eigenschaften
	private boolean ersterZug;
	public boolean rochade;
	
	// Methoden
	public F_Koenig(String name, Position pos, int farbe, Schachfeld[][] felderTemp)
	{
		super(name, pos, farbe, felderTemp);
		
		if(this.farbe == 0)
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Koenig/Koenig.black.gif"));
		}
		else
		{
			this.icon = new ImageIcon(getClass().getResource("/Images/Koenig/Koenig.white.gif"));
		}
		
		this.ersterZug = true;
	}
	
	// Figur bewegen
	public void bewege(Position pos, Schachfeld feldAlt, Schachfeld feldNeu)
	{
		Figur tempFigur = null;
		
		if(ersterZug)
		{
			this.ersterZug = false;
			
			// Rochade vollziehen
			if(feldNeu.figur instanceof F_Turm)
			{
				if(((F_Turm)feldNeu.figur).ersterZug)
				{
					tempFigur = feldNeu.figur;
					tempFigur.pos = this.pos;
				}
			}
		}
		else
		{
			if(feldNeu.figur != null)
			{
				System.out.println("Figur/bewege # besiege");
				feldNeu.figur.besiege();
			}
		}
		
		this.setze(feldNeu);
		feldAlt.loescheFigur();
		System.out.println("Figur/bewege # zahl: " + pos.zahl + " buchstabe: " + pos.buchstabe);
		this.pos = pos;
		this.alleFelder[this.pos.zahl][this.pos.buchstabe].figur = this;
		this.feld.setzeFigur(this);
		
		if(tempFigur != null)
		{
			tempFigur.setze(feldAlt);
			tempFigur.alleFelder[tempFigur.pos.zahl][tempFigur.pos.buchstabe].figur = tempFigur;
			tempFigur.feld.setzeFigur(tempFigur);
		}
	}
	
	// Mögl. Züge anzeigen
	public List<Position> zuege()
	{
		List<Position> moeglichePositionen = new ArrayList<Position>();
		
		// kleine Rochade
		if(this.ersterZug)
		{
			// kleine Rochade
			if(alleFelder[this.pos.zahl][this.pos.buchstabe + 3].figur != null)
			{
				if(alleFelder[this.pos.zahl][this.pos.buchstabe + 3].figur instanceof F_Turm)
				{
					if(((F_Turm)alleFelder[this.pos.zahl][this.pos.buchstabe + 3].figur).ersterZug)
					{
						moeglichePositionen.add( new Position(this.pos.zahl, this.pos.buchstabe + 3, false) );
					}
				}
			}
			
			// große Rochade
			if(alleFelder[this.pos.zahl][this.pos.buchstabe - 4].figur != null)
			{
				if(alleFelder[this.pos.zahl][this.pos.buchstabe - 4].figur instanceof F_Turm)
				{
					if(((F_Turm)alleFelder[this.pos.zahl][this.pos.buchstabe - 4].figur).ersterZug)
					{
						moeglichePositionen.add( new Position(this.pos.zahl, this.pos.buchstabe - 4, false) );
					}
				}
			}
		}
		
		// Laufzüge
		// Diagonal
		// links oben
		if(this.pos.zahl > 1 && this.pos.buchstabe > 1)
		{
			if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe - 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe - 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe - 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe - 1, false) );
			}
		}
		
		// rechts oben
		if(this.pos.zahl < 8 && this.pos.buchstabe > 1)
		{
			if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe - 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe - 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe - 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe - 1, false) );
			}
		}
		
		// links unten
		if(this.pos.zahl > 1 && this.pos.buchstabe < 8)
		{
			if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe + 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe + 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe + 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe + 1, false) );
			}
		}
		
		// rechts unten
		if(this.pos.zahl < 8 && this.pos.buchstabe < 8)
		{
			if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe + 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe + 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe + 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe + 1, false) );
			}
		}
		
		// Horizontal und Vertikal
		// links
		if(this.pos.zahl > 1)
		{
			if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe].figur != null)
			{
				if(this.alleFelder[this.pos.zahl - 1][this.pos.buchstabe].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl - 1, this.pos.buchstabe, false) );
			}
		}
		
		// rechts
		if(this.pos.zahl < 8)
		{
			if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe].figur != null)
			{
				if(this.alleFelder[this.pos.zahl + 1][this.pos.buchstabe].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl + 1, this.pos.buchstabe, false) );
			}
		}
		
		// oben
		if(this.pos.buchstabe > 1)
		{
			if(this.alleFelder[this.pos.zahl][this.pos.buchstabe - 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl][this.pos.buchstabe - 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl, this.pos.buchstabe - 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl, this.pos.buchstabe - 1, false) );
			}
		}
		
		// unten
		if(this.pos.buchstabe < 8)
		{
			if(this.alleFelder[this.pos.zahl][this.pos.buchstabe + 1].figur != null)
			{
				if(this.alleFelder[this.pos.zahl][this.pos.buchstabe + 1].figur.farbe != this.farbe)
				{
					moeglichePositionen.add( new Position(this.pos.zahl, this.pos.buchstabe + 1, true) );
				}
			}
			else
			{
				moeglichePositionen.add( new Position(this.pos.zahl, this.pos.buchstabe + 1, false) );
			}
		}
		
		return moeglichePositionen;
	}
}