package lab.factory;

import lab.component.CircleComponent;
import lab.component.RectangleComponent;
import lab.model.Circle;
import lab.model.Rectangle;

public class ComponentsFactory {

	public static CircleComponent createCircle(Circle model) {
		CircleComponent component = new CircleComponent(model);
		
		return component;
	}
	
	public static RectangleComponent createRectangle(Rectangle model) {
		RectangleComponent component = new RectangleComponent(model);
		
		return component;
	}
}
