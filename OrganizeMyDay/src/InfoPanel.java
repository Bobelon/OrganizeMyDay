
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	
	private static JLabel date;
	private static JLabel tasksNumber;
	private static InfoPanel instance;
	
	private InfoPanel() {
		date = new JLabel(DateCalculations.getDate(new Date()));
		date.setForeground(Color.WHITE);
		tasksNumber = new JLabel("Liczba zadañ: 0");
		tasksNumber.setForeground(Color.WHITE);
		add(date);
		add(tasksNumber);
		setBackground(Color.BLACK);
	}
	
	public static InfoPanel getInstance() {
		return instance = instance == null ? new InfoPanel() : instance;
	}
	
	public static void updateTasks() {
		tasksNumber.setText("Liczba zadañ: " + Cash.Tasks.size());		
	}
}
