package lab;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShow();
            }
        });
		
	}

	private static void createAndShow() {
		
		RaceSimulationFrame simulationFrame = new RaceSimulationFrame();
		simulationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simulationFrame.setData(500, 500);
		simulationFrame.start();
	}
}
