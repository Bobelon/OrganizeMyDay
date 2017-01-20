import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.*;
import java.awt.*;

/*
 * BOCZNY PASEK MENU Z PRZYCISKAMI "Dodaj" ORAZ "Kalendarz"
 */

public class Menu extends JPanel {
	
	private JButton add;
	private JButton calendar;
	
	public Menu() {
		add = new JButton("Dodaj");
		calendar = new JButton("Kalendarz");
		
		add.addActionListener(addListener);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(add);
		add(calendar);
	}
	
	// Klasa wewnêtrzna "AddWindow", wyœwietlaj¹ca okienko do dodawania zadañ
		public class AddWindow extends JFrame {
			
			private JLabel name;
			private JTextField nameTF;
			private JLabel description;
			private JTextArea descriptionTA;
			private JLabel date;
			private JTextField dateTF;
			private JLabel time;
			private JTextField timeTF;
			private JLabel toastDate;
			private JTextField toastDateTA;
			private JButton addBtn;
			
			private ActionListener addListener = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Cash.Tasks.add(new Task(nameTF.getText(), descriptionTA.getText()));
					InfoPanel.updateTasks();
				}
				
			};
			
			// Konstruktor
			public AddWindow() {
				// W³aœciwoœci okna
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setTitle("Dodaj zadanie");
					setBounds(Window.DESKTOP_WIDTH / 4, 0, Window.DESKTOP_WIDTH / 2, Window.DESKTOP_HEIGHT);
					
					addWindowListener(close);
					
					SpringLayout layout = new SpringLayout();
					setLayout(layout);
					
					
					name = new JLabel("Nazwa zadania: ");
					nameTF = new JTextField(15);
					description = new JLabel("Opis: ");
					descriptionTA = new JTextArea(10, 20);
					date = new JLabel("Data: ");
					dateTF = new JTextField(15);
					time = new JLabel("Czas: ");
					timeTF = new JTextField(15);
					toastDate = new JLabel("Data przypomnienia: ");
					toastDateTA = new JTextField(15);
					addBtn = new JButton("Dodaj");
					addBtn.addActionListener(addListener);

					int margin = getWidth() * 5 / 100;
					int padding = margin / 2;
					
					layout.putConstraint(SpringLayout.WEST, name, margin, SpringLayout.WEST, getContentPane());
					layout.putConstraint(SpringLayout.NORTH, name, margin, SpringLayout.NORTH, getContentPane());
					layout.putConstraint(SpringLayout.WEST, nameTF, padding, SpringLayout.EAST, name);
					layout.putConstraint(SpringLayout.NORTH, nameTF, margin, SpringLayout.NORTH, getContentPane());
					
					layout.putConstraint(SpringLayout.WEST, description, margin, SpringLayout.WEST, getContentPane());
					layout.putConstraint(SpringLayout.NORTH, description, padding, SpringLayout.SOUTH, name);
					layout.putConstraint(SpringLayout.NORTH, descriptionTA, padding, SpringLayout.SOUTH, name);
					layout.putConstraint(SpringLayout.WEST, descriptionTA, padding, SpringLayout.EAST, description);
					
					layout.putConstraint(SpringLayout.WEST, date, margin, SpringLayout.WEST, getContentPane());
					layout.putConstraint(SpringLayout.NORTH, date, padding, SpringLayout.SOUTH, descriptionTA);
					layout.putConstraint(SpringLayout.NORTH, dateTF, padding, SpringLayout.SOUTH, descriptionTA);
					layout.putConstraint(SpringLayout.WEST, dateTF, padding, SpringLayout.EAST, date);
					
					layout.putConstraint(SpringLayout.WEST, time, margin, SpringLayout.WEST, getContentPane());
					layout.putConstraint(SpringLayout.NORTH, time, padding, SpringLayout.SOUTH, date);
					layout.putConstraint(SpringLayout.NORTH, timeTF, padding, SpringLayout.SOUTH, date);
					layout.putConstraint(SpringLayout.WEST, timeTF, padding, SpringLayout.EAST, time);
					
					layout.putConstraint(SpringLayout.WEST, toastDate, margin, SpringLayout.WEST, getContentPane());
					layout.putConstraint(SpringLayout.NORTH, toastDate, padding, SpringLayout.SOUTH, time);
					layout.putConstraint(SpringLayout.NORTH, toastDateTA, padding, SpringLayout.SOUTH, time);
					layout.putConstraint(SpringLayout.WEST, toastDateTA, padding, SpringLayout.EAST, toastDate);

					layout.putConstraint(SpringLayout.WEST, addBtn, margin, SpringLayout.WEST, getContentPane());
					layout.putConstraint(SpringLayout.NORTH, addBtn, padding, SpringLayout.SOUTH, toastDate);

					
					add(name);
					add(nameTF);
					add(description);
					add(descriptionTA);
					add(date);
					add(dateTF);
					add(time);
					add(timeTF);
					add(toastDate);
					add(toastDateTA);
					add(addBtn);
					
					
					setVisible(true);
			}
			// Przy zamkniêciu okna, w³¹cz przyciski "Dodaj" oraz "Kalendarz"
			WindowAdapter close = new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					add.setEnabled(true);
					calendar.setEnabled(true);
				}
			};				
		} // <- Koniec klasy wewnêtrznej "AddWindow"
		
	
	// Listener przycisku do dodawania zadañ
		ActionListener addListener = new ActionListener() {
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
}
