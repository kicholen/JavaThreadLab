package lab.thread;

import java.util.List;

import lab.model.CarModel;

public class AccelerateThread extends Thread {
	private List<CarModel> _models;
	private int _updateInterval;
	private double _maxSpeed;
	
	public AccelerateThread(List<CarModel> models) {
		_updateInterval = 1000 / 40;
		_models = models;
		_maxSpeed = 0.05f;
    } 

    public void run() { 
        while (true) { 
        	for (int i = 0; i < _models.size(); i++) {
        		double closestAngle = Integer.MAX_VALUE;
        		double lowestAngle = Integer.MAX_VALUE;
        		Boolean wasFound = false;
        		double firstAngle = _models.get(i).getAngle();
        		for (int j = 0; j < _models.size(); j++) {
        			if (i != j) {
        				double secondAngle = _models.get(j).getAngle();
        				if (firstAngle < secondAngle && closestAngle > secondAngle) {
        					closestAngle = secondAngle;
        					wasFound = true;
        				}
        				if (lowestAngle > secondAngle) {
        					lowestAngle = secondAngle;
        				}
        			}
        		}
        		int diff = 0;
        		if (wasFound) {
        			diff = radToDeg(closestAngle - firstAngle);
        		}
        		else {
        			diff = radToDeg(degToRad(360) - firstAngle + lowestAngle);
        		}
        		double vel = _models.get(i).getAngularVelocity();
        		
    			if (diff <= 15) {
    				vel /= 2.0;
    			}
    			else if (diff > 15) {
    				vel += 0.02;
    			}
    			
        		_models.get(i).setAngularVelocity(Math.min(Math.max(0.005, vel), _maxSpeed));
    		}
        	
            try {
				sleep(_updateInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        } 
    }
    
    public void setMaxSpeed(float value) {
    	_maxSpeed = value;
    }
    
    public int radToDeg(double rad) {
    	return (int) (rad * 180 / Math.PI);
    }
    
    public int degToRad(double deg) {
    	return (int) (deg * Math.PI / 180);
    }
}
