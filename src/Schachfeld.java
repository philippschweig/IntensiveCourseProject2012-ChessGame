import java.awt.*;
import java.awt.event.*;

public class Schachfeld
{
	// Eigenschaften
	Button btFeld = null;
	Label lbFeld = null;
	// Konstruktor
	Schachfeld(String feldbeschreibung, Schachbrett b)
	{
		//this.btFeld = new Button("Test");
		this.lbFeld = new Label(feldbeschreibung);
		b.add(this.lbFeld);
	}
	
	// Methoden
	
}