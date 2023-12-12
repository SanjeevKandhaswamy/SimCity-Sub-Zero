package Util;

import javax.swing.*;
import java.awt.*;

public class DialogBox {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowDialog());
    }

    public static int createAndShowDialog() {
        // Set the default font for JOptionPane buttons
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));

        // Array of building options
        String[] options = {
                "Residential Building",
                "Commercial Building",
                "Industrial Building",
                "Park",
                "Power Generator",
                "School"
        };

        // Display the option dialog
        int choice = JOptionPane.showOptionDialog(
                null,
                "Select the building you want to build:",
                "Building Selection",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        handleUserChoice(choice);
        return choice;
    }

    private static int handleUserChoice(int choice) {
        switch (choice) {
            case 0:
                // User selected Residential Building
                return handleResidentialBuildingConfirmation();
            case 1:
                // User selected Commercial Building
                return handleCommercialBuildingConfirmation();
            case 2:
                // User selected Industrial Building
                return handleIndustrialBuildingConfirmation();
            // Add cases for other building types if needed
            default:
                return -1; // Default value for invalid choice
        }
    }

    private static int handleResidentialBuildingConfirmation() {
        // Residential Building cost
        int buildCost = 5000;

        // Display confirmation dialog for Residential Building with cost
        int confirmChoice = JOptionPane.showConfirmDialog(
                null,
                "Build a Residential Building?\nCost: " + buildCost,
                "Residential Building Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        return confirmChoice;
    }

    private static int handleCommercialBuildingConfirmation() {
        // Commercial Building cost
        int buildCost = 7000;

        // Display confirmation dialog for Commercial Building with cost
        int confirmChoice = JOptionPane.showConfirmDialog(
                null,
                "Build a Commercial Building?\nCost: " + buildCost,
                "Commercial Building Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        // Process the user's confirmation
        if (confirmChoice == JOptionPane.YES_OPTION) {
            System.out.println("Building: Commercial Building - Confirmed");
            // Now you can proceed with building the commercial building
        } else {
            System.out.println("Building: Commercial Building - Not Confirmed");
            // Handle the case where the user didn't confirm
        }
        return confirmChoice;
    }
    
    
    private static int handleIndustrialBuildingConfirmation() {
        // Industrial Building cost
        int buildCost = 12000;

        // Display confirmation dialog for Industrial Building with cost
        int confirmChoice = JOptionPane.showConfirmDialog(
                null,
                "Build an Industrial Building?\nCost: " + buildCost,
                "Industrial Building Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        // Process the user's confirmation
        if (confirmChoice == JOptionPane.YES_OPTION) {
            System.out.println("Building: Industrial Building - Confirmed");
            // Now you can proceed with building the industrial building
        } else {
            System.out.println("Building: Industrial Building - Not Confirmed");
            // Handle the case where the user didn't confirm
        }
        return confirmChoice;
    }

    // ... (similar methods for other building types)
}
