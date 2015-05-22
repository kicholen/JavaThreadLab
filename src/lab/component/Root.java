package lab.component;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JPanel;

import lab.factory.ComponentsFactory;
import lab.model.CarModel;
import lab.model.Circle;
import lab.model.Rectangle;
import lab.thread.AccelerateThread;
import lab.thread.CarThread;
import lab.thread.RepaintThread;

public class Root extends JPanel {
	CircleComponent _circleComponent;
	List<JComponent> _children;
	List<CarModel> _models;
	private Circle _circle;
	
	public Root(int width, int height) {
		_children = new ArrayList<JComponent>();
		_models = new ArrayList<CarModel>();
		
		new RepaintThread(_children).start();
		new AccelerateThread(_models).start();
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		setSize(width, height);
		setVisible(true);
	}

	public void setData() {
		float circleRadius = getWidth() < getHeight() ? getWidth() * 0.9f : getHeight() * 0.9f;
		_circle = new Circle(circleRadius, (getWidth() - circleRadius) / 2.0f, (getHeight() - circleRadius) / 2.0f);
		_circleComponent = ComponentsFactory.createCircle(_circle);
		addComponent(_circleComponent);
		
		for (int i = 0; i < 15; i++) {
			addCar();
		}
	}
	
	private void addCar() {
		Rectangle model = new Rectangle(10, 20, 5, 50);
		CarModel car = new CarModel(model, (double)randomFloat(0.0f, 0.05f), (double)randomFloat(0.0f, 6.0f));
		JComponent component = ComponentsFactory.createRectangle(car.getRect());
		addComponent(component);
		_children.add(component);
		_models.add(car);
		
		new CarThread(car, _circle).start(); 
	}
	
	private float randomFloat(float min, float max) {
		Random rand = new Random();
		return rand.nextFloat() * (max - min) + min;
	}
	
	private void addComponent(JComponent component) {
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.weightx = 1;
	    constraints.weighty = 1;
	    constraints.fill = GridBagConstraints.BOTH;
	
	    add(component, constraints);
	}

}