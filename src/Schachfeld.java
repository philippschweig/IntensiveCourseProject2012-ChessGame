import java.awt.*;
import java.awt.event.*;

public class Schachfeld
{
	// Eigenschaften
	private Schachbrett b;
	private Schachfigur figur = null;
	
	private Button btFeld = null;
	private Label lbFeld = null;
	
	// Konstruktor
	public Schachfeld(String feldbeschreibung, Schachbrett bTemp)
	{
		//this.btFeld = new Button("Test");
		this.b = bTemp;
		this.lbFeld = new Label(feldbeschreibung);
		this.b.add(this.lbFeld);
	}
	
	// Methoden
	
	public void setzeFigur(Schachfigur figurTemp)
	{
		this.figur = figurTemp;
		lbFeld.setText(this.figur.getName());
	}
}