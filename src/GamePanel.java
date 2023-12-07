import javax.swing.*;
import java.awt.*;
<<<<<<< HEAD
<<<<<<< Updated upstream
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
=======
>>>>>>> Stashed changes
=======
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a


public class GamePanel {
	
	private JPanel panel;
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
	private Point coordinates;
	
	public GamePanel() {
		this.panel = new JPanel();
		this.coordinates = new Point(0,0); // Initialize the point object
<<<<<<< HEAD
=======
	
	public GamePanel() {
		this.panel = new JPanel();
>>>>>>> Stashed changes
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
	}
	
	public void fillPanel(String[][] mapArray) {
		panel.setLayout(new GridLayout(mapArray.length, mapArray[0].length));
		
		for(int i = 0; i <= mapArray.length - 1; i++) {
			for(int j = 0; j <= mapArray[0].length - 1; j++) {
				JLabel label = new JLabel(mapArray[i][j], SwingConstants.CENTER);
				
				if(mapArray[i][j] == " ") {
					label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				}
				panel.add(label);
			}
		}
	}
	
<<<<<<< HEAD
<<<<<<< Updated upstream
	
=======
>>>>>>> Stashed changes
=======
	
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
	// Function to display the gamePanel.
	public void displayPanel(String[][] mapArray) {
		fillPanel(mapArray);
		
		JFrame frame = new JFrame("Sim-City");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
	
	public Point MouseTracker() {
        panel.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// Get the coordinates from mouse listener and assigned those to point object
        		coordinates.setLocation(e.getX(), e.getY()); 
        	}
        });
        return coordinates;
	}
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
=======
>>>>>>> 690e630056052486eab7322126b4187b4b359b9a
}
