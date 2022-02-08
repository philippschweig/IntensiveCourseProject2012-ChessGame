import java.awt.*;
import java.awt.event.*;

public class Schachfeld
{
	// Eigenschaften
	private Panel gamePanel;
	private Schachbrett b;
	private Schachfigur figur;
	
	private Button btFeld = null;
	private Label lbFeld = null;
	
	// Konstruktor
	public Schachfeld(Schachbrett bTemp, Panel gamePanel)
	{
		this.b = bTemp;
		this.gamePanel = gamePanel;
	}
	
	/*public void addDescription(int x, int y, int width, int height, double weightx, double weighty)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x; gbc.gridy = y;
		gbc.gridwidth = width; gbc.gridheight = height;
		//gbc.weightx = weightx; gbc.weighty = weighty;
		this.b.setConstraints( c, gbc );
		this.gamePanel.add();
	}*/
	
	// Methoden
	/*public void add(int x, int y, int width, int height, double weightx, double weighty, boolean figurplatz)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridx = x;
		gbc.gridy = y;
		
		gbc.gridwidth = width;
		gbc.gridheight = height;
		//gbc.weightx = weightx; gbc.weighty = weighty;
		
		this.b.setConstraints( c, gbc );
		this.gamePanel.add();
	}*/
	
	public void add(int x, int y, String feldbeschreibung, boolean figurplatz)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridx = x;
		gbc.gridy = y;
		
		//gbc.gridwidth = width;
		//gbc.gridheight = height;
		//gbc.weightx = weightx; gbc.weighty = weighty;
		
		if(figurplatz)
		{
			this.lbFeld = new Label(feldbeschreibung);
			this.btFeld = new Button("b");
			
			this.b.setConstraints( this.lbFeld, gbc );
			this.b.setConstraints( this.btFeld, gbc );
			
			this.gamePanel.add(this.lbFeld);
			this.gamePanel.add(this.btFeld);
		}
		else
		{
			this.lbFeld = new Label(feldbeschreibung);
			
			this.b.setConstraints( this.lbFeld, gbc );
			
			this.gamePanel.add(this.lbFeld);
		}
	}
	
	public void setzeFigur(Schachfigur figurTemp)
	{
		this.figur = figurTemp;
		lbFeld.setText(this.figur.getName());
	}
}