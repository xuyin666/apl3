package Morpion;

import java.awt.Point;

public class PointAndScore {
    
	private int score;
	Point point;
	
    public PointAndScore(int score, Point point) {
    	this.score=score;
    	this.point=point;
    }
    
    public int getScore() {
		return score;
    }
    
    public Point getPoint() {
    	return point;
    }
    
}
