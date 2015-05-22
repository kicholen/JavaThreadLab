package lab.component;

import lab.model.Rectangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent {
	private Rectangle _model;
	private Color _color;
	
	public RectangleComponent(Rectangle model) {
		_model = model;
		Random rand = new Random();
		_color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	 @Override
     public Dimension getPreferredSize() {
         return new Dimension((int)_model.getX() + (int)_model.getWidth(), (int)_model.getY() + (int)_model.getHeight());
     }
	 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(_color);
        g.fillRect((int)_model.getX(), (int)_model.getY(), (int)_model.getWidth(), (int)_model.getHeight());
    }
}
