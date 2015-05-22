package lab.model;

public class CarModel {
	private Rectangle _rect;
	private double _angularVelocity;
	private double _angle;
	
	public CarModel(Rectangle rect, double angularVelocity, double angle) {
		_rect = rect;
		_angularVelocity = angularVelocity;
		_angle = angle;
	}
	
	public Rectangle getRect() {
		return _rect;
	}
	
	public void setPosition(float x, float y) {
		_rect.setX(x);
		_rect.setY(y);
	}
	
	public void setAngularVelocity(double angularVelocity) {
		_angularVelocity = angularVelocity;
	}
	
	public double getAngularVelocity() {
		return _angularVelocity;
	}
	
	public double getAngle() {
		return _angle;
	}
	
	public void setAngle(double angle) {
		_angle = angle;
	}
	
}
