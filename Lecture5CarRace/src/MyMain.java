import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMain {
	public static void main(String[] args) throws InterruptedException {
		final int FRAME_HEIGHT =600;
		final int FRAME_WIDTH=800;
		
		JFrame frame = new JFrame();
		
		Vehicle[] theVehicles = new Vehicle[10];
		
		int nextYPos=0;
		
		for(int i=1;i<theVehicles.length;i++){
			theVehicles[0]=new PoliceCar(0,0,Color.GRAY,10,1,0);
			
			if(i%2==0){
				theVehicles[i] = new Truck(0,0,Color.BLUE,10,1,i);
			}
			else{
				theVehicles[i] = new MutableCar(0,0,Color.BLUE,10,1,i);
			}
		}
		
		CarStage theComponent = new CarStage(FRAME_HEIGHT,theVehicles);
		
		frame.add(theComponent);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Random Car Race");	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		while(!theComponent.someCarWon()) {
			frame.repaint();
			Thread.sleep(100);
		}
		JOptionPane.showMessageDialog(null, "END OF RACE Vehicle#"+CarStage.Win + " Won!!!");
		System.exit(0);
	}
}