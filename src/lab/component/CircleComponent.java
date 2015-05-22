package lab.component;

import lab.model.Circle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class CircleComponent extends JComponent {
	private Circle _model;
	private Color _color;

	public CircleComponent(Circle model) {
		_model = model;
		Random rand = new Random();
		_color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	 @Override
     public Dimension getPreferredSize() {
         return new Dimension((int)_model.getX() + (int)_model.getDiameter(), (int)_model.getY() + (int)_model.getDiameter());
     }
	 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(_color);
        g.drawOval((int)_model.getX(), (int)_model.getY(), (int)_model.getDiameter(), (int)_model.getDiameter());
    }
}
