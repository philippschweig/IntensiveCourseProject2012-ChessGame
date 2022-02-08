import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Schachbrett extends JPanel
{
	// Eigenschaften
	// [Buchstaben][]
	public Schachfeld felder[][] = new Schachfeld[10][10];
	public GridBagLayout gbl = new GridBagLayout();
	// Konstruktor
	public Schachbrett()
	{
		super(null);
		
		this.setLayout(this.gbl);
		
		String feldbeschreibung = new String();
		boolean figur;
		
		for(int f1 = 0; f1 < felder.length; f1++)
		{
			for(int f2 = 0; f2 < felder[f1].length; f2++)
			{
				figur = false;
				
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
					//feldbeschreibung = "B" + f1 + ", Z" + f2;
					feldbeschreibung = "";
					figur = true;
				}
				
				
				felder[f1][f2] = new Schachfeld(feldbeschreibung, this , f1, f2, figur);
			}
		}
	}
	
	// Methoden
	public void setzeFiguren(java.util.List<Schachfigur> figuren)
	{
		Schachfigur tempFigur;
		
		for(int i = 0; i < figuren.size(); i++)
		{
			tempFigur = figuren.get(i);
			this.felder[tempFigur.getPosition().buchstabe][tempFigur.getPosition().zahl].setzeFigur(tempFigur);
		}
	}
	
	public void alleFelderDeaktivieren()
	{
		for(int x = 1; x < felder.length - 1; x++)
		{
			for(int y = 1; y < felder[x].length - 1; y++)
			{
				felder[x][y].feldDeaktivieren();
			}
		}
	}
	
	public void feldDeaktivieren(Position pos)
	{
		this.felder[pos.buchstabe][pos.zahl].feldDeaktivieren();
	}
	
	public void felderDeaktivieren(java.util.List<Schachfigur> figuren)
	{
		Schachfigur tempFigur;
		
		for(int i = 0; i < figuren.size(); i++)
		{
			tempFigur = figuren.get(i);
			this.felder[tempFigur.getPosition().buchstabe][tempFigur.getPosition().zahl].feldDeaktivieren();
		}
	}
}