import javax.swing.*;

public class Tools
{
	public static int betrag(int x)
	{
		if(x < 0) return -x;
		else return x;
	}
	
	public static String auswahlbox(String text, String title, String[] werte, Object[] options, int selectedIndex)
	{
		JLabel lb = new JLabel(text);
		JComboBox cb = new JComboBox(werte);
		cb.setSelectedIndex(selectedIndex);
		
		Object[] message = {lb, cb};
		
		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null, options);
		
		pane.createDialog(null, title).setVisible(true);
		
		return (String)cb.getSelectedItem();
	}
}