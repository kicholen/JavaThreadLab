package lab.thread;

import java.util.List;

import javax.swing.JComponent;

public class RepaintThread extends Thread {
	private List<JComponent> _children;
	private int _updateInterval;
	
	public RepaintThread(List<JComponent> children) {
		_updateInterval = 1000 / 60;
		_children = children; 
    } 

    public void run() { 
        while (true) { 
        	for (JComponent component : _children) {
        		component.repaint();
    		}
        	
            try {
				sleep(_updateInterval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
    } 
}
