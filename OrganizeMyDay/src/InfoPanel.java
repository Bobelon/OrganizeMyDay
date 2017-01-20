
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	
	private JLabel date;
	private JLabel day;
	private JLabel tasksNumber;
	
	public InfoPanel() {
		date = new JLabel(DateCalculations.getDate(new Date()));
		date.setForeground(Color.WHITE);
		add(date);
		setBackground(Color.BLACK);
	}
}
