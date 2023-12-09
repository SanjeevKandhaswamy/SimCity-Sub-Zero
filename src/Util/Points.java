package Util;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Points {
	
	private Map<Point, Point> pointsMap;
	
	public Points() {
		this.pointsMap = new HashMap<>();
	}
	
	
	public void addPoint(Point keyPoint, Point valuePoint) {
		pointsMap.put(keyPoint, valuePoint);
	}
	
	
	public void buildPoints(int length, int breadth, int x, int y) {
		
		Point starting_point = new Point(x,y);
		for(int i = 0; i <= length - 1; i++) {
			for(int j = 0; j <= breadth - 1; j++) {
				Point current_point = new Point(x + i, y + j);
				this.addPoint(current_point, starting_point);
			}
		}
	}
	
	public Point getPoint(Point keyPoint) {
		return pointsMap.get(keyPoint);
	}
}
