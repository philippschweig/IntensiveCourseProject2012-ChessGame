import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Schachbrett extends GridBagLayout
{
	// Eigenschaften
	// [Buchstaben][]
	private Panel gamePanel;
	public Schachfeld felder[][] = new Schachfeld[10][10];
	
	// Konstruktor
	public Schachbrett(Panel gamePanel)
	{
		//super(null);
		this.gamePanel = gamePanel;
		
		String feldbeschreibung = new String();
		boolean figurplatz = false;
		
		for(int f1 = 0; f1 < felder.length; f1++)
		{
			for(int f2 = 0; f2 < felder[f1].length; f2++)
			{
				if((f2 == 0 || f2 == 9) && (f1 > 0 && f1 < 9))
				{
					switch(f1)
					{
						case 1:
							feldbeschreibung = "A";
							break;
						case 2:
							feldbeschreibung = "B";
							break;
						case 3:
							feldbeschreibung = "C";
							break;
						case 4:
							feldbeschreibung = "D";
							break;
						case 5:
							feldbeschreibung = "E";
							break;
						case 6:
							feldbeschreibung = "F";
							break;
						case 7:
							feldbeschreibung = "G";
							break;
						case 8:
							feldbeschreibung = "H";
							break;
					}
				} else if((f1 == 0 || f1 == 9) && (f2 > 0 && f2 < 9))
				{
					feldbeschreibung = ""+f2;
				}
				else if((f1 == 0 || f1 == 9) && (f2 == 0 || f2 == 9))
				{
					feldbeschreibung = "";
				}
				else
				{
					feldbeschreibung = "B" + f1 + ", Z" + f2;
					figurplatz = true;
				}
				
				
				felder[f1][f2] = new Schachfeld(this, this.gamePanel);
				felder[f1][f2].add(f2, f1, feldbeschreibung, figurplatz);
			}
		}
	}
	
	// Methoden
	public void setzeFiguren(java.util.List<Schachfigur> figuren)
	{
		
	}
}