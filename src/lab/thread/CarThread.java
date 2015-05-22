package lab.thread;

import lab.model.CarModel;
import lab.model.Circle;

public class CarThread extends Thread {
	private CarModel _model;
	private int _updateInterval;
	private Circle _circle;
	
	public CarThread(CarModel model, Circle circle) { 
		_updateInterval = 1000 / 60;
		_model = model;
		_circle = circle;
    } 

    public void run() { 
        while (true) { 
        	updatePosition();
            yield();
            try {
				sleep(_updateInterval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
    }
    
    private void updatePosition() {
    	_model.setAngle(_model.getAngle() + _model.getAngularVelocity());
    	if (_model.getAngle() >= Math.PI * 2.0f) {
    		_model.setAngle(0.0f);
    	}
    	
    	float radius = _circle.getDiameter() / 2.0f;
    	int newX = (int)(_circle.getX() + radius * Math.cos(_model.getAngle()));
        int newY = (int)(_circle.getY() + radius * Math.sin(_model.getAngle()));
        _model.setPosition(newX + radius - _model.getRect().getWidth() / 2.0f, newY + radius - _model.getRect().getHeight() / 2.0f);
    }
    
}
