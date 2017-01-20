import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private int desktopWidth;
	private int desktopHeight;
	
	public Window() {
		
		// Wymiary ekranu
			Rectangle desktopSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
			desktopWidth = (int) desktopSize.getWidth();
			desktopHeight = (int) desktopSize.getHeight();
			
		// W³aœciwoœci okna
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("OrganizeMyDay");
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			
		// Dodawanie panelów	
			getContentPane().add(BorderLayout.NORTH, new InfoPanel());
			getContentPane().add(BorderLayout.EAST, new Menu());
			
			setVisible(true);
	}
}
