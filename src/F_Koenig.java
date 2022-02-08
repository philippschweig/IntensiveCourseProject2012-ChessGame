import javax.swing.*;
import java.util.*;

public class F_Koenig extends Figur
{
	// Eigenschaften
	private boolean ersterZug;
	public boolean rochade;
	
	// SchachMatt-Callback
	private IKoenig callback_sm;
	
	// Methoden
	public F_Koenig(String name, Position pos, int farbe, Schachfeld[][] felderTemp, IKoenig c)
	{
		super(name, pos, farbe, felderTemp);
		
		this.callback_sm = c;
		
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
		//Figur tempFigur = null;
		
		if(ersterZug)
		{
			this.ersterZug = false;
			
			// Prüfen ob die Position mehr als ein Schritt ist
			int schrittlaenge = Tools.betrag(this.pos.buchstabe - pos.buchstabe);
			if(schrittlaenge > 1)
			{
				// Prüft ob kleine oder Große Rochade
				// Kleine Rochade
				if(schrittlaenge == 2)
				{
					((F_Turm)this.alleFelder[this.pos.zahl][8].figur).rochade(true);
				}
				// Große Rochade
				else
				{
					((F_Turm)this.alleFelder[this.pos.zahl][1].figur).rochade(false);
				}
			}
			
			// Rochade vollziehen
			if(pos.rochade == true)
			{
				System.out.println("rochade");
				
			}
		}
		
		super.bewege(pos, feldAlt, feldNeu);
	}
	// Figur besiegen
	public void besiege()
	{
		super.besiege();
		this.callback_sm.SchachMatt(new Object());
	}
	// Mögl. Züge anzeigen
	public List<Position> zuege()
	{
		List<Position> moeglichePositionen = new ArrayList<Position>();
		
		// kleine Rochade
		if(this.ersterZug)
		{
			// kleine Rochade
			if(this.alleFelder[this.pos.zahl][this.pos.buchstabe + 3].figur != null)
			{
				if(this.alleFelder[this.pos.zahl][this.pos.buchstabe + 3].figur instanceof F_Turm)
				{
					if(((F_Turm)this.alleFelder[this.pos.zahl][this.pos.buchstabe + 3].figur).ersterZug)
					{
						if(this.alleFelder[this.pos.zahl][this.pos.buchstabe + 1].figur == null && this.alleFelder[this.pos.zahl][this.pos.buchstabe + 2].figur == null)
						{
							moeglichePositionen.add(new Position(this.pos.zahl, this.pos.buchstabe + 2,	false));
						}
						
					}
				}
			}
			
			// große Rochade
			if(this.alleFelder[this.pos.zahl][this.pos.buchstabe - 4].figur != null)
			{
				if(this.alleFelder[this.pos.zahl][this.pos.buchstabe - 4].figur instanceof F_Turm)
				{
					if(((F_Turm)this.alleFelder[this.pos.zahl][this.pos.buchstabe - 4].figur).ersterZug)
					{
						if(this.alleFelder[this.pos.zahl][this.pos.buchstabe - 3].figur == null && this.alleFelder[this.pos.zahl][this.pos.buchstabe - 2].figur == null)
						{
							moeglichePositionen.add( new Position(this.pos.zahl, this.pos.buchstabe - 3, false) );
						}
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