package lab.model;

import lab.model.Figure;

public class Circle extends Figure {
	private float _diamater;
	
	public Circle(float diameter, float x, float y) {
		super(x, y);
		_diamater = diameter;
	}
	
	public float getDiameter() {
		return _diamater;
	}
}
