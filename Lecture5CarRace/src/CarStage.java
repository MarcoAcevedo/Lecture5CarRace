import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;
import java.lang.System;

public class CarStage extends JComponent {
	private static final long serialVersionUID = 1L;
	
	int counter = 0;
	Vehicle[] vehicles;
	boolean onAWall = false;
	boolean someCarWon = false;
	Random randomNumber = new Random();
	static int Win;
	
	public CarStage(int FrameHeight, Vehicle[] vehicles){
		this.vehicles = new Vehicle[vehicles.length];
		int nextYPos=0;
		for(int i=0;i<vehicles.length;i++){
			vehicles[i].setPosition(0, nextYPos);
			this.vehicles[i]=vehicles[i];
			nextYPos+= vehicles[i].getHeight()+20;
		}
	}
	
	public boolean someCarWon() {
		return someCarWon;
		}

	public void paintComponent (Graphics g) {
		for(Vehicle vehicle : vehicles) {
			vehicle.draw(g);
			int deltaxCar = randomNumber.nextInt(vehicle.getHorizontalSpeed());
			vehicle.moveInX(deltaxCar);
			if (vehicle.getXPos()+60 >= this.getWidth()){
				//Car 1 hit wall
				vehicle.setPosition(this.getWidth()-60, vehicle.getYPos());
				someCarWon=true;
				Win=vehicle.getNumber()+1;
			}
		}
		System.out.println(counter++);
	}
}