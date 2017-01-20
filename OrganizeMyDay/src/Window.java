import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public static int DESKTOP_WIDTH = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth();
	public static int DESKTOP_HEIGHT = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight();
	
	public Window() {
			
		// W³aœciwoœci okna
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("OrganizeMyDay");
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			
		// Dodawanie panelów	
			getContentPane().add(BorderLayout.NORTH, InfoPanel.getInstance());
			getContentPane().add(BorderLayout.EAST, new Menu());
			
			setVisible(true);
	}
}
