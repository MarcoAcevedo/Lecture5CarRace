import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class PoliceCar extends MutableCar {
	public PoliceCar(double x, double y, Color color, int horizontalSpeed, int horizontalDirection, int number) {
		super(x,y,color,horizontalSpeed,horizontalDirection,number);
	}
	
	public void draw(Graphics g){
		super.draw(g);
		Graphics2D g2 = (Graphics2D) g;
		//this.setColor(Color.BLACK);
		Ellipse2D.Double biombo = new Ellipse2D.Double(this.getXPos()+27,this.getYPos(),5,5);
		g2.setColor(Color.BLUE);
		g2.fill(biombo);
	}
	
}
