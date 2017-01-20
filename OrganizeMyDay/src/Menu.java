import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Menu extends JPanel {
	private JButton add;
	private JButton calendar;
	
	ActionListener addListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			add.setEnabled(false);
			calendar.setEnabled(false);
			
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new AddWindow();
				}
			});
		}
		
	};
	
	public Menu() {
		add = new JButton("Dodaj");
		calendar = new JButton("Kalendarz");
		
		add.addActionListener(addListener);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(add);
		add(calendar);
	}
}
