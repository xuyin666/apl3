package triangle;

import java.awt.Polygon;

public class Sierpinski {

	public Polygon[] polyList;
	public int count = 0;
	
	public Sierpinski( int splits )
	{
		int nombre=(int)Math.pow(3,splits);
		this.polyList = new Polygon[nombre];
	}
	
	public void computeTriangles(int splits, int ax, int ay, int bx, int by, int cx, int cy)
	{
		//TODO	
		if(splits==0) {
			//create basic triangle
			int[]xs={ax,bx,cx};
			int[]ys={ay,by,cy};
			Polygon p = new Polygon(xs,ys,xs.length);
			 
			polyList[count] = p;
			count++;
		}
		else if(splits==1) {
			int[] m1=getMidpoint(ax,ay,bx,by);
			int[] m2=getMidpoint(ax,ay,cx,cy);
			int[] m3=getMidpoint(bx,by,cx,cy);
			
			int[] xs1= {ax,m1[0],m2[0]};
			int[] ys1= {ay,m1[1],m2[1]};
			Polygon p1 = new Polygon(xs1,ys1,xs1.length);
			polyList[count] = p1;
			count++;
			
			int[] xs2= {cx,m2[0],m3[0]};
			int[] ys2= {cy,m2[1],m3[1]};
			Polygon p2 = new Polygon(xs2,ys2,xs2.length);
			polyList[count] = p2;
			count++;
			
			int[] xs3= {bx,m1[0],m3[0]};
			int[] ys3= {by,m1[1],m3[1]};
			Polygon p3 = new Polygon(xs3,ys3,xs3.length);
			polyList[count] = p3;
			count++;
		}
		else {
			int[] m1=getMidpoint(ax,ay,bx,by);
			int[] m2=getMidpoint(ax,ay,cx,cy);
			int[] m3=getMidpoint(bx,by,cx,cy);
			
			computeTriangles(splits-1,ax,ay,m2[0],m2[1],m1[0],m1[1]);
			computeTriangles(splits-1,bx,by,m1[0],m1[1],m3[0],m3[1]);
			computeTriangles(splits-1,cx,cy,m2[0],m2[1],m3[0],m3[1]);
		}
	}
	
	// returns the midpoint as an array [x,y] of any line given the coordinates
	public static int[] getMidpoint(int ax, int ay, int bx, int by)
	{
		//TODO
		int midX=(ax+bx)/2;
		int midY=(ay+by)/2;
		return new int[] {midX,midY};
	}
}
