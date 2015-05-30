package lab;

import java.awt.Dimension;

import lab.component.Root;

import javax.swing.JFrame;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class RaceSimulationFrame extends JFrame {
	Root _root;
	
	public void setData(int width, int height) {
		setSize(width, height);
		setBounds(0, 0, width, height);
		setLocationRelativeTo(null);
		setLayout(null);
        add(createRoot());
        
        setVisible(true);
	}
	
	public void start() {
		revalidate();
		repaint();
	}
	
	 private Root createRoot() {
		 _root = new Root(getWidth() * 9 / 10, getHeight() * 9 / 10);
		 _root.setData();
		 
		 return _root;
	 }
}
