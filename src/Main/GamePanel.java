package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel {

    private JPanel panel;
    private Point lastClickedCoordinates; // Added to store the last clicked coordinates
    private String[][] mapArray; // Added to store the mapArray
    private JFrame frame; // Added to store the JFrame

    public GamePanel(String[][] mapArray) {
        this.mapArray = mapArray; // Initialize the mapArray
        this.panel = new JPanel();
        this.lastClickedCoordinates = new Point(-1, -1); // Initialize to invalid coordinates
    }

    private void fillPanel() {
        panel.setLayout(new GridLayout(mapArray.length, mapArray[0].length));

        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[0].length; j++) {
                JLabel label = new JLabel(mapArray[i][j], SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(label);
            }
        }
    }

    // Function to display the gamePanel.
    public void displayPanel() {
        fillPanel();

        frame = new JFrame("Sim-City");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Call the MouseTracker method
        mouseTracker();
    }

    private void mouseTracker() {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Calculate the cell width and height based on the map size
                int cellWidth = frame.getContentPane().getWidth() / mapArray[0].length;
                int cellHeight = frame.getContentPane().getHeight() / mapArray.length;

                // Calculate the coordinates of the clicked cell
                int x = (int) (e.getX() / cellWidth);
                int y = (int) (e.getY() / cellHeight);

                // Update the last clicked coordinates
                lastClickedCoordinates.setLocation(x, y);

                // Display the coordinates
                System.out.println("Clicked at coordinates: (" + x + ", " + y + ")");
            }
        });
    }

    // Method to get the last clicked coordinates
    public Point getLastClickedCoordinates() {
        return lastClickedCoordinates;
    }
}
